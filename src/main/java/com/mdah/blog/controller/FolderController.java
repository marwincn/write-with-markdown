package com.mdah.blog.controller;

import com.mdah.blog.dao.FolderDao;
import com.mdah.blog.entity.Folder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("folder")
public class FolderController {
    @Autowired
    FolderDao folderDao;

    @RequestMapping("new")
    public String newFolder(Folder folder, HttpSession session) {
        if (null == session.getAttribute("HasPermission")) {
            return "pass";
        }
        folderDao.save(folder);
        return "redirect:/index";
    }

    @RequestMapping("delete")
    public String deleteFolder(Integer id, HttpSession session) {
        if (null == session.getAttribute("HasPermission")) {
            return "pass";
        }
        folderDao.deleteById(id);
        return "redirect:/config";
    }
}
