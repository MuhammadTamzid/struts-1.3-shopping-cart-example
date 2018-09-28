package com.cart.persistence;

import com.cart.model.Category;

public interface ICategoryRepo {

    boolean createCategory(Category category);
}
