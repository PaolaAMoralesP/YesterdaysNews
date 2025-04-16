package com.yesterdaysnews.yesterdaysnews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yesterdaysnews.yesterdaysnews.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // Custom query methods can be defined here if needed

}
