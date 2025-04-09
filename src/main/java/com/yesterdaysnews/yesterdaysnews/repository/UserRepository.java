package com.yesterdaysnews.yesterdaysnews.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yesterdaysnews.yesterdaysnews.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
