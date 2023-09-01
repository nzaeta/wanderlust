package com.nicoz.NZWanderlust.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicoz.NZWanderlust.Entities.Post;
import com.nicoz.NZWanderlust.Services.PostService;

@RestController
@RequestMapping("/")
public class PostController {

	
    @Autowired
    private PostService postService;
    
    @PostMapping("/post")
    public ResponseEntity<?> addPost(@RequestBody Post post) {
    	Post newPost = postService.newPost(post);
        return new ResponseEntity<>(newPost, HttpStatus.OK);
    }
	
    
    @DeleteMapping("/post/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Integer id) {
    	postService.deletePost(id);      	
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
	
    @GetMapping("/post/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Integer id) {
        try {
        	Post post = postService.searchPost(id);      	
            return new ResponseEntity<>(post, HttpStatus.OK);
        } catch (Exception e) {
        	return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/post")
    public List<Post> getPosts(){
        return postService.getPosts();
    }
      	
    @PutMapping("/post/{id}")
    public ResponseEntity<?> updatePost(@RequestBody Post post, @PathVariable Integer id) {
    	Post updatedPost = postService.updatePost(id, post);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }	
	
	
}
