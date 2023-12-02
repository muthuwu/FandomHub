package com.fandomhub.mongoangular;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

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
import com.fandomhub.mongoangular.resources.CommentsController;
import com.fandomhub.mongoangular.resources.FeedController;
import com.fandomhub.mongoangular.resources.LastIdController;
import com.fandomhub.mongoangular.resources.MyforumController;
import com.fandomhub.mongoangular.resources.UserProfController;

@RunWith(SpringRunner.class)
@SpringBootTest
class MongoangularApplicationTests {
	@MockBean
	private UserRepository UserDTOrepo;
	
	@Autowired
	private UserProfController UserDTOctrlr;
	
	@Autowired
	private LastIdController LastidDTOctrlr;
	
	@Autowired
	private CommentsController CommentsDTOctrlr;
	
	@Autowired
	private FeedController Feedctrlr;
	
	@Autowired
	private MyforumController Myforumctrlr;
	
	@MockBean
	private ForumsRepository ForumsDTOrepo;
	
	@MockBean
	private LastIdRepository LastidDTOrepo;
	
	@MockBean
	private PostsRepository PostsDTOrepo;

	@MockBean
	private CommentsRepository CommentsDTOrepo;
	
	
	@Test
	void postUserDTO() {
		UserDTO UserDTO = new UserDTO(1, "sgf", "sgf", 1, "sgf", "sgf", false, null);
		when(UserDTOrepo.save(UserDTO)).thenReturn(UserDTO);
		assertEquals("Added user with id: 1", UserDTOctrlr.addUser(UserDTO));
	}
	
	@Test
	void getUserDTOs() {
		UserDTO UserDTO = new UserDTO(1, "sgf", "sgf", 1, "sgf", "sgf", false, null);
		when(UserDTOrepo.findAll()).thenReturn(Stream.of(UserDTO, UserDTO, UserDTO).collect(Collectors.toList()));
		assertEquals(3, UserDTOctrlr.getAllUsers().size());
	}
	
	@Test
	void deleteUserDTO() {
		UserDTO UserDTO = new UserDTO(1, "sgf", "sgf", 1, "sgf", "sgf", false, null);
		when(UserDTOrepo.findAll()).thenReturn(Stream.of(UserDTO, UserDTO, UserDTO).collect(Collectors.toList()));
		assertEquals("Deleted user with id: 1", UserDTOctrlr.deleteMyUser(1));
	}
	
	@Test
	void postForum() {
		ForumsDTO forum = new ForumsDTO(1, 1, "sgf", "sgf", null, null, 1);
		when(ForumsDTOrepo.save(forum)).thenReturn(forum);
		assertEquals("Added forum with id: 1", UserDTOctrlr.addForum(forum));
	}
	
	@Test
	void getForumsDTO() {
		ForumsDTO forum = new ForumsDTO(1, 1, "sgf", "sgf", null, null, 1);
		when(ForumsDTOrepo.findAll()).thenReturn(Stream.of(forum, forum, forum).collect(Collectors.toList()));
		assertEquals(3, UserDTOctrlr.getAllForums().size());
	}
	
	@Test
	void deleteForum() {
		ForumsDTO forum = new ForumsDTO(1, 1, "sgf", "sgf", null, null, 1);
		when(ForumsDTOrepo.findAll()).thenReturn(Stream.of(forum, forum).collect(Collectors.toList()));
		assertEquals("Deleted forum with id: 1", UserDTOctrlr.deleteForum(1));
	}
	
	@Test
	void postPost() {
		PostsDTO post = new PostsDTO(1,2,3,4,null,"asd","asd");
		when(PostsDTOrepo.save(post)).thenReturn(post);
		assertEquals("Added post with id: 1", UserDTOctrlr.addPost(post));
	}
	
	@Test
	void getPostsDTO() {
		PostsDTO post = new PostsDTO(1,2,3,4,null,"asd","asd");
		when(PostsDTOrepo.findAll()).thenReturn(Stream.of(post, post, post).collect(Collectors.toList()));
		assertEquals(3, UserDTOctrlr.getAllPosts().size());
	}
	
	@Test
	void deletePost() {
		PostsDTO post = new PostsDTO(1,2,3,4,null,"asd","asd");
		when(PostsDTOrepo.findAll()).thenReturn(Stream.of(post, post).collect(Collectors.toList()));
		assertEquals("Deleted post with id: 1", UserDTOctrlr.deletePost(1));
	}
	
	@Test
	void postComment() {
		CommentsDTO comment = new CommentsDTO(1,2,3,4,"asd");
		when(CommentsDTOrepo.save(comment)).thenReturn(comment);
		assertEquals("Added comment with id: 1", UserDTOctrlr.addComment(comment));
	}
	
	@Test
	void getCommentsDTO() {
		CommentsDTO comment = new CommentsDTO(1,2,3,4,"asd");
		when(CommentsDTOrepo.findAll()).thenReturn(Stream.of(comment, comment, comment).collect(Collectors.toList()));
		assertEquals(3, UserDTOctrlr.getAllComments().size());
	}
	
	@Test
	void deleteComment() {
		CommentsDTO comment = new CommentsDTO(1,2,3,4,"asd");
		when(CommentsDTOrepo.findAll()).thenReturn(Stream.of(comment, comment).collect(Collectors.toList()));
		assertEquals("Deleted comment with id: 1", UserDTOctrlr.deleteComments(1));
	}
	
	@Test
	void postLastidDTO() {
		LastidDTO LastidDTO = new LastidDTO(1,2,3,4,5);
		when(LastidDTOrepo.save(LastidDTO)).thenReturn(LastidDTO);
		assertEquals("Lastid created", LastidDTOctrlr.createLastId(LastidDTO));
	}
	
	@Test
	void getLastids() {
		LastidDTO LastidDTO = new LastidDTO(1,2,3,4,5);
		when(LastidDTOrepo.findAll()).thenReturn(Stream.of(LastidDTO).collect(Collectors.toList()));
		assertEquals(Optional.empty(), LastidDTOctrlr.getLastId());
	}
	
	@Test
	void updateLastidDTO() {
		LastidDTO LastidDTO = new LastidDTO(1,2,3,4,5);
		when(LastidDTOrepo.findAll()).thenReturn(Stream.of(LastidDTO, LastidDTO).collect(Collectors.toList()));
		assertEquals("Lastid updated", LastidDTOctrlr.updateLastId(LastidDTO));
	}
	
	@Test
	void getComment() {
		CommentsDTO comment = new CommentsDTO(1, 2, 3, 4, "asd");
		when(CommentsDTOrepo.findAll()).thenReturn(Stream.of(comment).collect(Collectors.toList()));
		assertEquals(Optional.empty(), CommentsDTOctrlr.getComment(1));
	}
	
	@Test
	void getPostComments() {
		CommentsDTO comment = new CommentsDTO(1, 2, 2, 4, "asd");
		when(CommentsDTOrepo.findAll()).thenReturn(Stream.of(comment, comment).collect(Collectors.toList()));
		assertEquals(0, CommentsDTOctrlr.getPostComments(3).size());
	}
	
	@Test
	void postComment2() {
		CommentsDTO comment = new CommentsDTO(1,2,3,4,"asd");
		when(CommentsDTOrepo.save(comment)).thenReturn(comment);
		assertEquals("Comment Added", CommentsDTOctrlr.postComment(comment));
	}
	
	@Test
	void deleteComment2() {
		CommentsDTO comment = new CommentsDTO(1,2,3,4,"asd");
		when(CommentsDTOrepo.findAll()).thenReturn(Stream.of(comment, comment).collect(Collectors.toList()));
		assertEquals("Comments Returned", CommentsDTOctrlr.deleteComment(1));
	}
	
	@Test
	void getFollowingForums() {
		UserDTO UserDTO = new UserDTO(2, "sgf", "sgf", 1, "sgf", "sgf", false, null);
		when(UserDTOrepo.findAll()).thenReturn(Stream.of(UserDTO).collect(Collectors.toList()));

		ForumsDTO forum = new ForumsDTO(1, 1, "sgf", "sgf", null, null, 1);
		when(ForumsDTOrepo.findAll()).thenReturn(Stream.of(forum).collect(Collectors.toList()));
		
		assertEquals(0, Feedctrlr.getFollowingForums(1).size());
	}
	
	@Test
	void getForumPosts() {
		ForumsDTO forum = new ForumsDTO(2, 1, "sgf", "sgf", null, null, 1);
		when(ForumsDTOrepo.findAll()).thenReturn(Stream.of(forum).collect(Collectors.toList()));
		PostsDTO post = new PostsDTO(1,2,3,4,null,"asd","asd");
		when(PostsDTOrepo.findAll()).thenReturn(Stream.of(post).collect(Collectors.toList()));
		assertEquals(0, Feedctrlr.getForumPosts(1).size());
	}
	
	@Test
	void followUnfollowForum() {
		ForumsDTO forum = new ForumsDTO(2, 1, "sgf", "sgf", null, null, 1);
		when(ForumsDTOrepo.findAll()).thenReturn(Stream.of(forum).collect(Collectors.toList()));
		assertEquals("Forum Followers Updates", Feedctrlr.followUnfollowForum(forum));
	}
	
	@Test
	void getAllForums() {
		ForumsDTO forum = new ForumsDTO(2, 1, "sgf", "sgf", null, null, 1);
		when(ForumsDTOrepo.findAll()).thenReturn(Stream.of(forum, forum, forum).collect(Collectors.toList()));
		assertEquals(3, Feedctrlr.getAllForums().size());
	}
	
	@Test
	void updatePost() {
		PostsDTO post = new PostsDTO(1,2,3,4,null,"asd","asd");
		when(PostsDTOrepo.save(post)).thenReturn(post);
		assertEquals("Updated Post with id: 1", Feedctrlr.updatePost(post));
	}
	
	@Test
	void deleteForum2() {
		UserDTO UserDTO = new UserDTO(2, "sgf", "sgf", 1, "sgf", "sgf", false, null);
		when(UserDTOrepo.findAll()).thenReturn(Stream.of(UserDTO).collect(Collectors.toList()));
		ForumsDTO forum = new ForumsDTO(2, 2, "sgf", "sgf", null, null, 1);
		when(ForumsDTOrepo.findAll()).thenReturn(Stream.of(forum).collect(Collectors.toList()));
		PostsDTO post = new PostsDTO(1,2,3,4,null,"asd","asd");
		when(PostsDTOrepo.save(post)).thenReturn(post);
		
		assertEquals("Could not delete Forum. Try again later.", Myforumctrlr.deleteForum(3));
	}
	
	@Test
	void deletePost2() {
		ForumsDTO forum = new ForumsDTO(2, 2, "sgf", "sgf", null, null, 1);
		when(ForumsDTOrepo.findAll()).thenReturn(Stream.of(forum).collect(Collectors.toList()));
		PostsDTO post = new PostsDTO(1,2,3,4,null,"asd","asd");
		when(PostsDTOrepo.save(post)).thenReturn(post);
		assertEquals("Deleted Post with id: 1", Myforumctrlr.deletePost(1));
		
	}
	
	@Test
	void updateUser() {
		UserDTO UserDTO = new UserDTO(2, "sgf", "sgf", 1, "sgf", "sgf", false, null);
		when(UserDTOrepo.findAll()).thenReturn(Stream.of(UserDTO).collect(Collectors.toList()));
		assertEquals("Updated user with id: 2", UserDTOctrlr.updateUser(UserDTO));
	}
	
	@Test
	void updateForum() {
		ForumsDTO forum = new ForumsDTO(2, 2, "sgf", "sgf", null, null, 1);
		when(ForumsDTOrepo.findAll()).thenReturn(Stream.of(forum).collect(Collectors.toList()));
		assertEquals("Updated Forum with id: 2", UserDTOctrlr.updateForum(forum));
	}
	
	@Test
	void getUserDetails() {
		UserDTO UserDTO = new UserDTO(2, "sgf", "sgf", 1, "sgf", "sgf", false, null);
		when(UserDTOrepo.findAll()).thenReturn(Stream.of(UserDTO).collect(Collectors.toList()));
		assertEquals(null, UserDTOctrlr.getUserDetails(2));
	}
	
	@Test
	void getMyUser() {
		UserDTO UserDTO = new UserDTO(2, "sgf", "sgf", 1, "sgf", "sgf", false, null);
		when(UserDTOrepo.findAll()).thenReturn(Stream.of(UserDTO).collect(Collectors.toList()));
		assertEquals(Optional.empty(), UserDTOctrlr.getMyUser(1));
	}
	
	@Test
	void getForum() {
		ForumsDTO forum = new ForumsDTO(2, 2, "sgf", "sgf", null, null, 1);
		when(ForumsDTOrepo.findAll()).thenReturn(Stream.of(forum).collect(Collectors.toList()));
		assertEquals(Optional.empty(), UserDTOctrlr.getForum(1));
	}
	
	@Test
	void getlastid() {
		LastidDTO LastidDTO = new LastidDTO(1,2,3,4,5);
		when(LastidDTOrepo.findAll()).thenReturn(Stream.of(LastidDTO).collect(Collectors.toList()));
		assertEquals(Optional.empty(), UserDTOctrlr.getlastid());
	}
	
	@Test
	void putlastid() {
		LastidDTO LastidDTO = new LastidDTO(1,2,3,4,5);
		when(LastidDTOrepo.findAll()).thenReturn(Stream.of(LastidDTO).collect(Collectors.toList()));
		assertEquals("Updated latest id", UserDTOctrlr.putlastid(LastidDTO));
	}
	
	@Test
	void getPosts() {
		PostsDTO post = new PostsDTO(1,2,3,4,null,"asd","asd");
		when(PostsDTOrepo.save(post)).thenReturn(post);
		assertEquals(Optional.empty(), UserDTOctrlr.getPosts(1));
	}
	
	@Test
	void getComments() {
		CommentsDTO comment = new CommentsDTO(1,2,3,4,"asd");
		when(CommentsDTOrepo.findAll()).thenReturn(Stream.of(comment).collect(Collectors.toList()));
		assertEquals(Optional.empty(), UserDTOctrlr.getComments(1));
	}
	
	@Test
	void getMyForums() {
		ForumsDTO forum = new ForumsDTO(2, 2, "sgf", "sgf", null, null, 1);
		when(ForumsDTOrepo.findAll()).thenReturn(Stream.of(forum, forum, forum).collect(Collectors.toList()));
		assertEquals(0, UserDTOctrlr.getMyForums(2).size());
	}
}
