package com.zft.esinaction.controller;

import com.zft.esinaction.dao.es.EsBlogDao;
import com.zft.esinaction.entity.es.EsBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {



    @Autowired
    private EsBlogDao esBlogDao;

    //localhost:8080/blog/list?title=明&content=testContent

    @GetMapping("/list")
    public List<EsBlog> list(@RequestParam(value = "title", defaultValue = "") String title,
                             @RequestParam(value = "content", required = false, defaultValue = "") String content,
                             @RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                             @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize) {
        Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<EsBlog> result = esBlogDao.findByTitleLikeOrContentLike(title, content, pageable);
        return result.getContent();
    }
}
