package com.mdah.blog.controller;

import com.mdah.blog.dao.ArticleDao;
import com.mdah.blog.dao.FolderDao;
import com.mdah.blog.dao.MessageDao;
import com.mdah.blog.entity.Article;
import com.mdah.blog.entity.Folder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("")
public class MainController {
    @Autowired
    FolderDao folderDao;
    @Autowired
    ArticleDao articleDao;
    @Autowired
    MessageDao messageDao;

    @RequestMapping("index")
    public String index(Model model) {
        List<Folder> folders = folderDao.findAll();
        for (Folder folder: folders) {
            folder.setArticles(articleDao.findByFolderId(folder.getId()));
        }
        List<Article> articles = articleDao.findAll();
        model.addAttribute("folders", folders);
        model.addAttribute("articles", articles);
        return "index";
    }

    @ResponseBody
    @RequestMapping("showArticle")
    public Article article(Integer id) {
        return articleDao.findById(id).orElse(null);
    }

    @RequestMapping("write")
    public String write(Model model) {
        List<Folder> folders = folderDao.findAll();
        model.addAttribute("folders", folders);
        return "write";
    }

    @RequestMapping("config")
    public String config(Model model) {
        List<Folder> folders = folderDao.findAll();
        List<Article> articles = articleDao.findAll();
        model.addAttribute("folders", folders);
        model.addAttribute("articles", articles);
        return "config";
    }
}
