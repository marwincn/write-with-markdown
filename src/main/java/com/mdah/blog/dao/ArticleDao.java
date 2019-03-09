package com.mdah.blog.dao;

import com.mdah.blog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleDao extends JpaRepository<Article, Integer> {
    List<Article> findByFolderId(Integer id);

}
