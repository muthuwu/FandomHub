package com.fandomhub.mongoangular.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fandomhub.mongoangular.model.Comments;
import com.fandomhub.mongoangular.model.Forums;
import com.fandomhub.mongoangular.model.Posts;
import com.fandomhub.mongoangular.model.User;
import com.fandomhub.mongoangular.model.lastid;
import com.fandomhub.mongoangular.repository.CommentsRepository;
import com.fandomhub.mongoangular.repository.ForumsRepository;
import com.fandomhub.mongoangular.repository.LastIdRepository;
import com.fandomhub.mongoangular.repository.PostsRepository;
import com.fandomhub.mongoangular.repository.UserRepository;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserProfController {
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private ForumsRepository myforumsrepo;
	
	@Autowired
	private LastIdRepository lastidrepo;
	
	@Autowired
	private PostsRepository postsrepo;
	
	@Autowired
	private CommentsRepository commentsrepo;

	
	@PostMapping("/adduser")
	public String addUser(@RequestBody User user) {
		userrepo.save(user);
		return "Added user with id: " + user.getUserId();
	}
	
	@PostMapping("/addforum")
	public String addForum(@RequestBody Forums forum) {
		myforumsrepo.save(forum);
		return "Added forum with id: " + forum.getForumid();
	}
	
	@PutMapping("/updateuser")
	public String updateUser(@RequestBody User user) {
		userrepo.save(user);
		return "Updated user with id: " + user.getUserId();
	}
	
	@PutMapping("/updateforum")
	public String updateForum(@RequestBody Forums forum) {
		myforumsrepo.save(forum);
		return "Updated Forum with id: " + forum.getForumid();
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userrepo.findAll();
	}
	
	@GetMapping("/loginauth/{email}")
	public User getUserDetails(@PathVariable String email) {
		User user = userrepo.findByEmail(email);
		return user;
	}
	
	@GetMapping("/forums")
	public List<Forums> getAllForums() {
		return myforumsrepo.findAll();
	}
	
	@GetMapping("/getmyuser/{id}")
	public Optional<User> getMyUser(@PathVariable int id) {
		return userrepo.findById(id);
	}
	
	@GetMapping("/getforum/{id}")
	public Optional<Forums> getForum(@PathVariable int id) {
		return myforumsrepo.findById(id);
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public String deleteMyUser(@PathVariable int id) {
		commentsrepo.deleteByCommenterid(id);
		postsrepo.deleteByOwnerid(id);
		myforumsrepo.deleteByOwnerid(id);
		userrepo.deleteById(id);
		return "Deleted user with id: " + id;
	}
	
	@DeleteMapping("/deleteforum/{id}")
	public String deleteForum(@PathVariable int id) {
		myforumsrepo.deleteById(id);
		return "Deleted forum with id: " + id;
	}
	
	@GetMapping("/getlastid")
	public Optional<lastid> getlastid() {
		int id = 1;
		return lastidrepo.findById(id);
	}
	
	@PostMapping("/postlastid")
	public String putlastid(@RequestBody lastid latestid) {
		lastidrepo.save(latestid);
		return "Updated latest id";
	}
	
	@PostMapping("/addpost")
	public String addPost(@RequestBody Posts post) {
		postsrepo.save(post);
		return "Added post with id: " + post.getPostid();
	}
	
	@GetMapping("/posts")
	public List<Posts> getAllPosts() {
		return postsrepo.findAll();
	}
	
	@GetMapping("/getpost/{id}")
	public Optional<Posts> getPosts(@PathVariable int id) {
		return postsrepo.findById(id);
	}
	
	@DeleteMapping("/deletepost/{id}")
	public String deletePost(@PathVariable int id) {
		postsrepo.deleteById(id);
		return "Deleted post with id: " + id;
	}
	
	@PostMapping("/addcomment")
	public String addComment(@RequestBody Comments comment) {
		commentsrepo.save(comment);
		return "Added post with id: " + comment.getcommentid();
	}
	
	@GetMapping("/comments")
	public List<Comments> getAllComments() {
		return commentsrepo.findAll();
	}
	
	@GetMapping("/getcomment/{id}")
	public Optional<Comments> getComments(@PathVariable int id) {
		return commentsrepo.findById(id);
	}
	
	@DeleteMapping("/deletecomment/{id}")
	public String deleteComments(@PathVariable int id) {
		commentsrepo.deleteById(id);
		return "Deleted comment with id: " + id;
	}
	
	@GetMapping("/getmyforums/{userid}")
	public List<Forums> getMyForums(@PathVariable int userid){
		return myforumsrepo.findByOwnerid(userid);
	}
}


