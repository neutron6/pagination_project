package com.rsn.pagination.pagination_with_sorting.repository;

import com.rsn.pagination.pagination_with_sorting.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
