package com.sprint.OnlineShoppingApplication.Repository;

import com.sprint.OnlineShoppingApplication.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
}
