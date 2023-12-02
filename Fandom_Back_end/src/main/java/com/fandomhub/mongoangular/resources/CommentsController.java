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

import com.fandomhub.mongoangular.model.CommentsDTO;
import com.fandomhub.mongoangular.repository.CommentsRepository;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/commentsapi")
public class CommentsController {

	
	@Autowired
	private CommentsRepository commentsrepo;
	
	@GetMapping("/getcomment/{id}")
	public Optional<CommentsDTO> getComment(@PathVariable int id) {
		return commentsrepo.findById(id);
	}
	
	@GetMapping("/getpostcomments/{id}")
	public List<CommentsDTO> getPostComments(@PathVariable int id) {
		return commentsrepo.findAllByPostid(id);
	}
	
	@PostMapping("/postcomment")
	public String postComment(@RequestBody CommentsDTO comment) {
		commentsrepo.save(comment);
		return "Comment Added";
	}
	
	@DeleteMapping("/deletecomment/{id}")
	public String deleteComment(@PathVariable int id) {
		commentsrepo.deleteById(id);
		return "Comments Returned";
	}
}
