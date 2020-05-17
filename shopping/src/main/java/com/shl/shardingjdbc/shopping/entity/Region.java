package com.shl.shardingjdbc.shopping.entity;

import lombok.Data;

/**
 * 地理区域信息
 * @author songhengliang
 * @date 2020/5/17
 */
@Data
public class Region {

  private Long id;

  /**
   * 地理区域编码
   */
  private String regionCode;

  /**
   * 地理区域名称
   */
  private String regionName;

  /**
   * 地理区域级别(省、市、县)
   */
  private int level;

  /**
   * 上级地理区域编码
   */
  private String parentRegionCode;

}
