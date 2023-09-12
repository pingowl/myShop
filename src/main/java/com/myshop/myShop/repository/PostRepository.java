package com.myshop.myShop.repository;

import com.myshop.myShop.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PostRepository extends JpaRepository<Post, Long> {

}
