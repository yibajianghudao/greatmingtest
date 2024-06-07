package com.greatming.greatmingtest.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    List<User> findByName(String name);
}
