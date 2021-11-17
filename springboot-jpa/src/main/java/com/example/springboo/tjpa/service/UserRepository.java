package com.example.springboo.tjpa.service;

import com.example.springboo.tjpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.Id;

@Service
public interface UserRepository extends JpaRepository<User, Id> {
    User findByName(String name);
    User findByNameAndAge(String name,Integer age);
    @Query("from User where name=:name")
    User findUser(@Param("name")String name);
}
