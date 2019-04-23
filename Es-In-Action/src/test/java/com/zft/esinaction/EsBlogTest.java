package com.zft.esinaction;

import com.zft.esinaction.dao.es.EsBlogDao;
import com.zft.esinaction.entity.es.EsBlog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Description: es blog test.
 * @author  fengtan.zhang
 * @date    2019/4/22 0022 下午 7:53
 * @email   fengtan_zhang@sina.com
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EsBlogTest {

    @Autowired
    private EsBlogDao esBlogDao;


    @Before
    public void initRepository() {
        //清楚所有数据
        esBlogDao.deleteAll();

        esBlogDao.save(new EsBlog("登黄鹤楼","王焕之的登黄鹤楼","白日依山尽，黄河入海流。欲穷千里目，更上一层楼 geek"));
        esBlogDao.save(new EsBlog("清明","杜牧的清明","清明时节雨纷纷，路上行人欲断魂。借问酒家何处有？牧童遥指杏花村 geek"));
        esBlogDao.save(new EsBlog("江雪","柳宗元的江雪","千山鸟飞绝，万径人踪灭.孤舟蓑笠翁，独钓寒江雪。"));
    }


    @Test
    public void testFindDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining() {
        Pageable pageable = new PageRequest(0, 20);
        Page<EsBlog> page = esBlogDao.findByTitleLikeOrContentLike("清明", "geek", pageable);
        assertEquals(2,page.getTotalElements());
    }
}
