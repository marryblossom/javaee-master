package com.tw.core.DAO.impl;

import com.tw.core.service.userService.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by marry on 8/4/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml",
                                    "classpath:hibernate_test.cfg.xml",})
@WebAppConfiguration
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class BaseServiceImplTest {
    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {
//        baseDao = new BaseServiceImpl();
    }

    @Test
//    @DirtiesContext//表示测试方法运行完成后，重新加载 applicationContext
    @Rollback(true)//在需要rollback的地方进行rollback

    public void testGetCurrentSession() throws Exception {
        assertEquals(1, 1);
//        baseDao.getCurrentSession();
    }

    @Test
    public void testCloseCurrentSession() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testSaveOrUpdate() throws Exception {

    }

    @Test
    public void testQueryAll() throws Exception {

    }

    @Test
    public void testDeleteById() throws Exception {

    }

    @Test
    public void testSave() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testQueryAllOfCondition() throws Exception {

    }

    @Test
    public void testDeleteAll() throws Exception {

    }

    @Test
    public void testSaveAll() throws Exception {

    }

    @Test
    public void testUpdateAll() throws Exception {

    }

    @Test
    public void testFindById() throws Exception {
        assertNotNull(userService.getUserById("013d49d4-f1fb-481c-a35a-7028d7455a84"));
//        assertNotNull(baseDao.findById(Employee.class, "0c857448-ba16-4691-bfb2-39527da11edb"));
    }
}