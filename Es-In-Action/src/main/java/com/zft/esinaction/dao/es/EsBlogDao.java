package com.zft.esinaction.dao.es;

import com.zft.esinaction.entity.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
/**
 * Description: es blog curd
 * @author  fengtan.zhang
 * @date    2019/4/22 0022 下午 7:46
 * @email   fengtan_zhang@sina.com
 * @version 1.0
 */
public interface EsBlogDao extends ElasticsearchCrudRepository<EsBlog, String>{

    /**
     * 分页查询博客，带去重
     * @param title
     * @param content
     * @return
     */
    Page<EsBlog> findByTitleLikeOrContentLike(String title, String content, Pageable pageable);
}
