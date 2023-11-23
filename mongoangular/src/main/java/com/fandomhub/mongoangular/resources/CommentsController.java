package com.fandomhub.mongoangular.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fandomhub.mongoangular.model.Comments;
import com.fandomhub.mongoangular.model.Forums;
import com.fandomhub.mongoangular.repository.CommentsRepository;
import com.fandomhub.mongoangular.repository.ForumsRepository;
import com.fandomhub.mongoangular.repository.PostsRepository;
import com.fandomhub.mongoangular.repository.UserRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/commentsapi")
public class CommentsController {
	@Autowired
	private ForumsRepository forumsrepo;
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private PostsRepository postsrepo;
	
	@Autowired
	private CommentsRepository commentsrepo;
	
	@GetMapping("/getcomment/{id}")
	public Optional<Comments> getComment(@PathVariable int id) {
		return commentsrepo.findById(id);
	}
	
	@GetMapping("/getpostcomments/{id}")
	public List<Comments> getPostComments(@PathVariable int id) {
		return commentsrepo.findAllByPostid(id);
	}
	
	@PostMapping("/postcomment")
	public String postComment(@RequestBody Comments comment) {
		commentsrepo.save(comment);
		return "Comment Added";
	}
	
	@DeleteMapping("/deletecomment/{id}")
	public String deleteComment(@PathVariable int id) {
		commentsrepo.deleteById(id);
		return "Comments Returned";
	}
}
