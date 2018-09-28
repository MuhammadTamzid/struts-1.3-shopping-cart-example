package com.cart.service;

import com.cart.model.Category;
import com.cart.persistence.ICategoryRepo;

public class CategoryService implements ICategoryService {

    private ICategoryRepo categoryRepo;

    public CategoryService(ICategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public boolean createCategory(Category category) {
        return categoryRepo.createCategory(category);
    }
}
