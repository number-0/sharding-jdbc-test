package com.shl.shardingjdbc.shopping.service.impl;

import com.shl.shardingjdbc.shopping.dao.ProductDao;
import com.shl.shardingjdbc.shopping.entity.ProductDescript;
import com.shl.shardingjdbc.shopping.entity.ProductInfo;
import com.shl.shardingjdbc.shopping.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author songhengliang
 * @date 2020/5/17
 */
@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductDao productDao;


  //添加商品
  @Override
  @Transactional
  public void createProduct(ProductInfo productInfo) {
    ProductDescript productDescript = new ProductDescript();
    //设置商品描述 信息
    productDescript.setDescript(productInfo.getDescript());
    //调用dao向商品信息表
    productDao.insertProductInfo(productInfo);
    //将商品信息id设置到productDescript
    productDescript.setProductInfoId(productInfo.getProductInfoId());
    //设置店铺id
    productDescript.setStoreInfoId(productInfo.getStoreInfoId());
    //向商品描述信息表插入数据
    productDao.insertProductDescript(productDescript);
  }

  @Override
  public List<ProductInfo> queryProduct(int page, int pageSize) {
    int start = (page - 1) * pageSize;
    return productDao.selectProductList(start, pageSize);
  }
}
