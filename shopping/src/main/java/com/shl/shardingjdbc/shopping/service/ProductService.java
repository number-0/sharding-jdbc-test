package com.shl.shardingjdbc.shopping.service;

import com.shl.shardingjdbc.shopping.entity.ProductInfo;
import java.util.List;

/**
 * @author songhengliang
 * @date 2020/5/17
 */
public interface ProductService {

  //添加商品
  public void createProduct(ProductInfo product);

  //查询商品
  public List<ProductInfo> queryProduct(int page, int pageSize);
}

