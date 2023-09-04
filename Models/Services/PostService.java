package com.nicoz.NZWanderlust.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nicoz.NZWanderlust.Entities.Post;
import com.nicoz.NZWanderlust.Repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Transactional
	public Post newPost(Post post) {

		Post newPost = new Post();
		
		newPost.setTitle(post.getTitle());		
		newPost.setDescription(post.getDescription());	
		newPost.setStartDate(post.getStartDate());
		newPost.setEndDate(post.getEndDate());
		newPost.setImages(post.getImages());
		newPost.setPrice(post.getPrice());
		newPost.setNumberOfTickets(0);
		newPost.setTransport(post.getTransport());
		newPost.setHotel(post.getHotel());
		newPost.setFood(post.getFood());
		newPost.setTuristicPlan(post.getTuristicPlan());
		
		return postRepository.save(newPost);

	}

	
    @Transactional
    public void deletePost(Integer id) {
    	Post post = searchPost(id);
    	postRepository.delete(post);
    }   
	
	@Transactional(readOnly = true)
	public Post searchPost(Integer id) {
		return postRepository.findById(id).get();
	}
	
	
    public List<Post> getPosts(){
        return postRepository.findAll();
    }
	
	@Transactional
	public Post updatePost(Integer id, Post post)  {
		Post postToUpdate = searchPost(id);
		postToUpdate.setTitle(post.getTitle());		
		postToUpdate.setDescription(post.getDescription());	
		postToUpdate.setStartDate(post.getStartDate());
		postToUpdate.setEndDate(post.getEndDate());
		postToUpdate.setImages(post.getImages());
		postToUpdate.setPrice(post.getPrice());
		postToUpdate.setNumberOfTickets(0);
		postToUpdate.setTransport(post.getTransport());
		postToUpdate.setHotel(post.getHotel());
		postToUpdate.setFood(post.getFood());
		postToUpdate.setTuristicPlan(post.getTuristicPlan());	

		return postRepository.save(postToUpdate);

	}

}
