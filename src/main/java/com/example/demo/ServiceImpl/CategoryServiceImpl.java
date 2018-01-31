package com.example.demo.ServiceImpl;

import com.example.demo.DaoImpl.CategoryDaoImpl;
import com.example.demo.Service.CategoryService;
import com.example.demo.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ahmed on 1/31/2018.
 */

@Service

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDaoImpl category1;
    @Override
    public Category saveCategory(Category category) {
        return category1.saveCategory(category);
    }

    @Override
    public Category updateCategory(int id, Category category) {
        return category1.updateCategory(id, category);
    }

    @Override
    public int deleteCategoryById(int id) {
        return category1.deleteCategoryById(id);
    }

    @Override
    public Category getCategoryById(int id) {
        return category1.getCategoryById(id);
    }

    @Override
    public List<Category> getAll() {
        return category1.getAll();
    }
}
