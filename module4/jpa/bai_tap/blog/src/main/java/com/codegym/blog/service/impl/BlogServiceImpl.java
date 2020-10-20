package com.codegym.blog.service.impl;

import com.codegym.blog.entity.Blog;
import com.codegym.blog.repository.BlogRepository;
import com.codegym.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return this.blogRepository.findAll();
    }

    @Override
    public Blog findById(String id) {
        return this.blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public void edit(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public void delete(String id) {
        this.blogRepository.deleteById(id);
    }
}
