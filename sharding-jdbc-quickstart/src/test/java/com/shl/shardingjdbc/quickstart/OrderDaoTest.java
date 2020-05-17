package com.shl.shardingjdbc.quickstart;

import com.shl.shardingjdbc.quickstart.dao.OrderDao;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.junit.Test;

/**
 * @author songhengliang
 * @date 2020/5/16
 */
public class OrderDaoTest extends BaseTest {

  @Resource
  private OrderDao orderDao;

  @Test
  public void testInsertOrder() {
    for (int i = 1; i < 20; i++) {
      orderDao.insertOrder(new BigDecimal(i), 1L, "SUCCESS");
    }
  }

  @Test
  public void testSelectOrderbyIds() {
    List<Long> ids = new ArrayList<>();
    ids.add(468487586571091968L);
    ids.add(468487475698860032L);

    List<Map> maps = orderDao.selectOrderbyIds(ids);
    System.out.println(maps);
  }

  @Test
  public void testSelectOrderbyUserAndIds() {
    List<Long> ids = new ArrayList<>();
    ids.add(468487586571091968L);
//        ids.add(468487586571091968L);

    List<Map> maps = orderDao.selectOrderbyUserAndIds(2L, ids);
    System.out.println(maps);
  }
}
