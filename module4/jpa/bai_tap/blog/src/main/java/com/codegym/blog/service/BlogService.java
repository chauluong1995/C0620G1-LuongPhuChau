package com.codegym.blog.service;

import com.codegym.blog.entity.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(String id);

    void save(Blog blog);

    void edit(Blog blog);

    void delete(String id);
}
