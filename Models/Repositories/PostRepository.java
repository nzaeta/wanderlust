package com.nicoz.NZWanderlust.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicoz.NZWanderlust.Entities.Post;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}