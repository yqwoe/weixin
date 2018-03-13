package com.repository;

import com.models.AccessToken;
import com.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long>/* 必须指定，不然会无法注入bean*/ {
    List<User> findByName(String name);
}
