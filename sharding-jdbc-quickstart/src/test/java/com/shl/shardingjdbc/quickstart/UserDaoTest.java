package com.shl.shardingjdbc.quickstart;

import com.shl.shardingjdbc.quickstart.dao.DictDao;
import com.shl.shardingjdbc.quickstart.dao.UserDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.junit.Test;

/**
 * @author songhengliang
 * @date 2020/5/16
 */
public class UserDaoTest extends BaseTest {

  @Resource
  private UserDao userDao;

  @Test
  public void testInsertUser() {
    for (int i = 0; i < 10; i++) {
      Long id = i + 1L;
      userDao.insertUser(id, "11" + id);
    }

  }

  @Test
  public void testSelectUserbyIds() {
    List<Long> userIds = new ArrayList<>();
    userIds.add(1L);
    userIds.add(2L);
    List<Map> users = userDao.selectUserbyIds(userIds);
    System.out.println(users);
  }



  @Resource
  private DictDao dictDao;

  /**
   * 新增字典
   */
  @Test
  public void testInsertDict(){
    dictDao.insertDict(3L,"user_type","2","超级管理员");
    dictDao.insertDict(4L,"user_type","3","二级管理员");
  }

  /**
   * 删除字典
   */
  @Test
  public void testDeleteDict(){
    dictDao.deleteDict(3L);
    dictDao.deleteDict(4L);
  }

  /**
   * 根据id列表查询多个用户，关联查询公共表-字典表
   */
  @Test
  public void testSelectUserInfobyIds(){
    List<Long> userIds = new ArrayList<>();
    userIds.add(1L);
    userIds.add(2L);
    List<Map> users = userDao.selectUserInfobyIds(userIds);
    System.out.println(users);
  }
}
