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

import com.fandomhub.mongoangular.model.CommentsDTO;
import com.fandomhub.mongoangular.model.ForumsDTO;
import com.fandomhub.mongoangular.model.PostsDTO;
import com.fandomhub.mongoangular.model.UserDTO;
import com.fandomhub.mongoangular.model.LastidDTO;
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
	public String addUser(@RequestBody UserDTO user) {
		userrepo.save(user);
		return "Added user with id: " + user.getUserId();
	}
	
	@PostMapping("/addforum")
	public String addForum(@RequestBody ForumsDTO forum) {
		myforumsrepo.save(forum);
		return "Added forum with id: " + forum.getForumid();
	}
	
	@PutMapping("/updateuser")
	public String updateUser(@RequestBody UserDTO user) {
		userrepo.save(user);
		return "Updated user with id: " + user.getUserId();
	}
	
	@PutMapping("/updateforum")
	public String updateForum(@RequestBody ForumsDTO forum) {
		myforumsrepo.save(forum);
		return "Updated Forum with id: " + forum.getForumid();
	}
	
	@GetMapping("/users")
	public List<UserDTO> getAllUsers() {
		return userrepo.findAll();
	}
	
	@GetMapping("/loginauth/{phonenumber}")
	public UserDTO getUserDetails(@PathVariable long phonenumber) {
		return userrepo.findByPhonenumber(phonenumber);
	}
	
	@GetMapping("/forums")
	public List<ForumsDTO> getAllForums() {
		return myforumsrepo.findAll();
	}
	
	@GetMapping("/getmyuser/{id}")
	public Optional<UserDTO> getMyUser(@PathVariable int id) {
		return userrepo.findById(id);
	}
	
	@GetMapping("/getforum/{id}")
	public Optional<ForumsDTO> getForum(@PathVariable int id) {
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
	public Optional<LastidDTO> getlastid() {
		int id = 1;
		return lastidrepo.findById(id);
	}
	
	@PostMapping("/postlastid")
	public String putlastid(@RequestBody LastidDTO latestid) {
		lastidrepo.save(latestid);
		return "Updated latest id";
	}
	
	@PostMapping("/addpost")
	public String addPost(@RequestBody PostsDTO post) {
		postsrepo.save(post);
		return "Added post with id: " + post.getPostid();
	}
	
	@GetMapping("/posts")
	public List<PostsDTO> getAllPosts() {
		return postsrepo.findAll();
	}
	
	@GetMapping("/getpost/{id}")
	public Optional<PostsDTO> getPosts(@PathVariable int id) {
		return postsrepo.findById(id);
	}
	
	@DeleteMapping("/deletepost/{id}")
	public String deletePost(@PathVariable int id) {
		postsrepo.deleteById(id);
		return "Deleted post with id: " + id;
	}
	
	@PostMapping("/addcomment")
	public String addComment(@RequestBody CommentsDTO comment) {
		commentsrepo.save(comment);
		return "Added comment with id: " + comment.getCommentid();
	}
	
	@GetMapping("/comments")
	public List<CommentsDTO> getAllComments() {
		return commentsrepo.findAll();
	}
	
	@GetMapping("/getcomment/{id}")
	public Optional<CommentsDTO> getComments(@PathVariable int id) {
		return commentsrepo.findById(id);
	}
	
	@DeleteMapping("/deletecomment/{id}")
	public String deleteComments(@PathVariable int id) {
		commentsrepo.deleteById(id);
		return "Deleted comment with id: " + id;
	}
	
	@GetMapping("/getmyforums/{userid}")
	public List<ForumsDTO> getMyForums(@PathVariable int userid){
		return myforumsrepo.findByOwnerid(userid);
	}
}


