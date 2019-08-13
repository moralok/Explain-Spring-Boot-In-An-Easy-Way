package com.springboot.chapter15.dao;

import com.springboot.chapter15.pojo.ProductPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author moralok
 * @date 2019/8/12
 */
@Mapper
public interface ProductDao {
    // 获取产品
    ProductPo getProduct(Long id);

    // 减库存
    int decreaseProduct(@Param("id") Long id,
                        @Param("quantity") int quantity,
                        @Param("version") int version);
}
