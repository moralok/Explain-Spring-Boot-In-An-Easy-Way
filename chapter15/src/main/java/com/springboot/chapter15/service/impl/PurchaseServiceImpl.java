package com.springboot.chapter15.service.impl;

import com.springboot.chapter15.dao.ProductDao;
import com.springboot.chapter15.dao.PurchaseRecordDao;
import com.springboot.chapter15.pojo.ProductPo;
import com.springboot.chapter15.pojo.PurchaseRecordPo;
import com.springboot.chapter15.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author moralok
 * @date 2019/8/12
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private ProductDao productDao = null;

    @Autowired
    private PurchaseRecordDao purchaseRecordDao = null;

    @Override
    // 启动 Spring 数据库事务机制
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public boolean purchase(Long userId, Long productId, int quantity) {
        // 当前时间
        long start = System.currentTimeMillis();
        // 也可以使用限制重入次数的方法
        while (true) {
            // 循环时间
            long end = System.currentTimeMillis();
            // 如果循环时间大于100ms返回终止循环
            if ((end - start) > 100) {
                return false;
            }

            // 获取产品
            ProductPo product = productDao.getProduct(productId);
            // 比较库存和购买数量
            if (product.getStock() < quantity) {
                // 库存不足
                return false;
            }
            // 获取当前版本号
            int version = product.getVersion();
            // 扣减库存，同时将当前版本号发送给后台进行比较
            int result = productDao.decreaseProduct(productId, quantity, version);
            if (result == 0) {
                continue;
            }
            // 初始化购买记录
            PurchaseRecordPo purchaseRecord = this.initPurchaseRecord(userId, product, quantity);
            // 插入购买记录
            purchaseRecordDao.insertPurchaseRecord(purchaseRecord);
            return true;
        }
    }

    // 初始化购买信息
    private PurchaseRecordPo initPurchaseRecord(Long userId, ProductPo product, int quantity) {
        PurchaseRecordPo purchaseRecord = new PurchaseRecordPo();
        purchaseRecord.setNote("购买日志， 时间：" + System.currentTimeMillis());
        purchaseRecord.setPrice(product.getPrice());
        purchaseRecord.setProductId(product.getId());
        purchaseRecord.setQuantity(quantity);
        double sum = product.getPrice() * quantity;
        purchaseRecord.setSum(sum);
        purchaseRecord.setUserId(userId);
        return purchaseRecord;
    }
}
