package com.sprint.OnlineShoppingApplication.Repository;

import com.sprint.OnlineShoppingApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
