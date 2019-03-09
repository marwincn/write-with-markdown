package com.mdah.blog.dao;

import com.mdah.blog.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageDao extends JpaRepository<Message, Integer> {
}
