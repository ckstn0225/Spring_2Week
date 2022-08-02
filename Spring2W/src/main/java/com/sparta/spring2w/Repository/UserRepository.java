package com.sparta.spring2w.Repository;

import com.sparta.spring2w.Entity.PostUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<PostUser, Long> {
    Optional<PostUser> findByUsername(String username);
}