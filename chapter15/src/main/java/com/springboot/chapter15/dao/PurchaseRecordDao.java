package com.springboot.chapter15.dao;

import com.springboot.chapter15.pojo.PurchaseRecordPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author moralok
 * @date 2019/8/12
 */
@Mapper
public interface PurchaseRecordDao {
    int insertPurchaseRecord(PurchaseRecordPo purchaseRecordPo);
}
