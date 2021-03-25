package com.elganiesta.springboot101.dao;

import com.elganiesta.springboot101.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
