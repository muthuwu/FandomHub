package com.fandomhub.mongoangular.resources;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fandomhub.mongoangular.model.ForumsDTO;
import com.fandomhub.mongoangular.model.PostsDTO;
import com.fandomhub.mongoangular.model.UserDTO;
import com.fandomhub.mongoangular.repository.ForumsRepository;
import com.fandomhub.mongoangular.repository.PostsRepository;
import com.fandomhub.mongoangular.repository.UserRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/feedapi")
public class FeedController {
	@Autowired
	private ForumsRepository forumsrepo;
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private PostsRepository postsrepo;
	
	
	@GetMapping("/getfollowingforums/{id}")
	public List<Optional<ForumsDTO>> getFollowingForums(@PathVariable int id) {
		Optional<UserDTO> user = userrepo.findById(id);
		List<Integer> forumids = new ArrayList<>();
		if (user.isPresent()) {
			UserDTO us = user.get();
			forumids = us.getFollowingForums();
		}
		List<Optional<ForumsDTO>> forums = new ArrayList<>();
		Optional<ForumsDTO> forum;
		for (int forumid: forumids) {
			forum = forumsrepo.findById(forumid);
			forums.add(forum);
		}
		return forums;
	}
	
	@GetMapping("/getforumposts/{forumid}")
	public List<Optional<PostsDTO>> getForumPosts(@PathVariable int forumid) {
		Optional<ForumsDTO> forum = forumsrepo.findById(forumid);
		Set<Integer> postids = new HashSet<>();
		if (forum.isPresent()) {
			ForumsDTO fo = forum.get();
			postids = fo.getPosts();
		}
		List<Optional<PostsDTO>> posts = new ArrayList<>();
		Optional<PostsDTO> post;
		for (int postid: postids) {
			post = postsrepo.findById(postid);
			posts.add(post);
		}
		return posts;
	}
	
	@PutMapping("/followunfollowforum")
	public String followUnfollowForum(@RequestBody ForumsDTO forum) {
		this.forumsrepo.save(forum);
		return "Forum Followers Updates";
	}
	
	@GetMapping("/getallforums")
	public List<ForumsDTO> getAllForums() {
		return forumsrepo.findAll();
	}
	
	@PutMapping("/updatepost")
	public String updatePost(@RequestBody PostsDTO post) {
		this.postsrepo.save(post);
		return "Updated Post with id: " + post.getPostid();
	}
	
}
