package com.shl.shardingjdbc.shopping.entity;

import lombok.Data;

/**
 * 商品描述
 * @author songhengliang
 * @date 2020/5/17
 */
@Data
public class ProductDescript {

  private Long id;

  /**
   * 所属商品id
   */
  private Long productInfoId;

  /**
   * 商品描述
   */
  private String descript;

  /**
   * 所属店铺id
   */
  private Long storeInfoId;

}
