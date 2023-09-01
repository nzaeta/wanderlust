package com.nicoz.NZWanderlust.Repositories;


import com.nicoz.NZWanderlust.Entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
