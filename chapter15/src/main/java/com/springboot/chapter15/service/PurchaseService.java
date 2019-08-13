package com.springboot.chapter15.service;

/**
 * @author moralok
 * @date 2019/8/12
 */
public interface PurchaseService {
    /**
     * 处理购买业务
     * @param userId 用户编号
     * @param productId 产品编号
     * @param quantity 购买数量
     * @return 成功 or 失败
     */
    boolean purchase(Long userId, Long productId, int quantity);
}
