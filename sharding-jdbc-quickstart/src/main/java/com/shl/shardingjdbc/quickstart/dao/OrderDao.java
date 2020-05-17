package com.shl.shardingjdbc.quickstart.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author songhengliang
 * @date 2020/5/16
 */
@Mapper
@Component
public interface OrderDao {
  /**
   * 插入订单
   * 操作sql，只需要关注逻辑表t_order即可，不需要关注具体的表名
   * @param price
   * @param userId
   * @param status
   * @return
   */
  @Insert("insert into t_order(price, user_id, status) values(#{price}, #{userId}, #{status})")
  int insertOrder(@Param("price")BigDecimal price,@Param("userId")Long userId,@Param("status")String status);

  /**
   * 根据id列表查询订单
   * @param orderIds
   * @return
   */
  @Select("<script>" +
      "select" +
      " * " +
      " from t_order t " +
      " where t.order_id in " +
      " <foreach collection='orderIds' open='(' separator=',' close=')' item='id'>" +
      " #{id} " +
      " </foreach>" +
      "</script>")
  List<Map> selectOrderbyIds(@Param("orderIds") List<Long> orderIds);

  /**
   * 根据id列表和用户id查询订单
   * @param orderIds
   * @return
   */
  @Select("<script>" +
      "select" +
      " * " +
      " from t_order t " +
      " where t.order_id in " +
      " <foreach collection='orderIds' open='(' separator=',' close=')' item='id'>" +
      " #{id} " +
      " </foreach>" +
      " and user_id = #{userId} " +
      "</script>")
  List<Map> selectOrderbyUserAndIds(@Param("userId") Long userId, @Param("orderIds") List<Long> orderIds);
}