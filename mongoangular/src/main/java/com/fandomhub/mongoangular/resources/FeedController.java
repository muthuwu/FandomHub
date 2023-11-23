package com.fandomhub.mongoangular.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fandomhub.mongoangular.model.Forums;
import com.fandomhub.mongoangular.model.Posts;
import com.fandomhub.mongoangular.model.User;
import com.fandomhub.mongoangular.repository.CommentsRepository;
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
	
	@Autowired
	private CommentsRepository commentsrepo;
	
	@GetMapping("/getfollowingforums/{id}")
	public List<Optional<Forums>> getFollowingForums(@PathVariable int id) {
		Optional<User> user = userrepo.findById(id);
		ArrayList<Integer> forumids = new ArrayList<Integer>();
		if (user.isPresent()) {
			User us = user.get();
			forumids = us.getFollowingForums();
		}
		List<Optional<Forums>> forums = new ArrayList<Optional<Forums>>();
		Optional<Forums> forum;
		for (int forumid: forumids) {
			forum = forumsrepo.findById(forumid);
			forums.add(forum);
		}
		return forums;
	}
	
	@GetMapping("/getforumposts/{forumid}")
	public List<Optional<Posts>> getForumPosts(@PathVariable int forumid) {
		Optional<Forums> forum = forumsrepo.findById(forumid);
		Set<Integer> postids = new HashSet<Integer>();
		if (forum.isPresent()) {
			Forums fo = forum.get();
			postids = fo.getPosts();
		}
		List<Optional<Posts>> posts = new ArrayList<Optional<Posts>>();
		Optional<Posts> post;
		for (int postid: postids) {
			post = postsrepo.findById(postid);
			posts.add(post);
		}
		return posts;
	}
	
	@PutMapping("/followunfollowforum")
	public String followUnfollowForum(@RequestBody Forums forum) {
		this.forumsrepo.save(forum);
		return "Forum Followers Updates";
	}
	
	@GetMapping("/getallforums")
	public List<Forums> getAllForums() {
		return forumsrepo.findAll();
	}
	
	@PutMapping("/updatepost")
	public String updatePost(@RequestBody Posts post) {
		this.postsrepo.save(post);
		return "Updated Post with id: " + post.getPostid();
	}
	
}
