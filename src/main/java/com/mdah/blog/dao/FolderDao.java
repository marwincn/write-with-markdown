package com.mdah.blog.dao;

import com.mdah.blog.entity.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderDao extends JpaRepository<Folder, Integer> {
}
