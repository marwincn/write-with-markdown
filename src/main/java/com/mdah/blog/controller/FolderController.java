package com.mdah.blog.controller;

import com.mdah.blog.dao.FolderDao;
import com.mdah.blog.entity.Folder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("folder")
public class FolderController {
    @Autowired
    FolderDao folderDao;

    @RequestMapping("new")
    public String newFolder(Folder folder) {
        folderDao.save(folder);
        return "redirect:/index";
    }

    @RequestMapping("delete")
    public String deleteFolder(Integer id) {
        folderDao.deleteById(id);
        return "redirect:/config";
    }
}
