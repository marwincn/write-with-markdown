package com.mdah.blog.controller;

import com.mdah.blog.dao.ArticleDao;
import com.mdah.blog.dao.FolderDao;
import com.mdah.blog.entity.Article;
import com.mdah.blog.entity.Folder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("article")
public class ArticleController {
    @Autowired
    ArticleDao articleDao;
    @Autowired
    FolderDao folderDao;

    @RequestMapping("publish")
    public String publish(Article article, Model model) {
        Date dateTime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(dateTime);
        article.setPublishTime(time);
        articleDao.save(article);
        model.addAttribute("message", "文章发布成功!");
        return "success";
    }

    @RequestMapping("update")
    public String update(Article article, Model model) {
        Date dateTime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(dateTime);
        article.setModifyTime(time);
        articleDao.save(article);
        model.addAttribute("message", "文章修改成功!");
        return "success";
    }

    @RequestMapping("delete")
    public String publish(Integer id) {
        articleDao.deleteById(id);
        return "redirect:/config";
    }

    @RequestMapping("editor")
    public String update(Integer id, Model model) {
        Article article = articleDao.findById(id).orElse(null);
        List<Folder> folders = folderDao.findAll();
        model.addAttribute("folders", folders);
        model.addAttribute("article", article);
        return "editor";
    }
}
