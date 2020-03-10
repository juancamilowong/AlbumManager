package com.albummanager;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.albummanager.model.Comment;
import com.albummanager.model.Photo;
import com.albummanager.model.User;
import com.albummanager.service.impl.CommentServiceImpl;
import com.albummanager.service.impl.PhotoServiceImpl;
import com.albummanager.service.impl.UserServiceImpl;

@SpringBootTest
class AlbumManagerApplicationTests {

	@Test
	void testUser() throws Exception {
		UserServiceImpl userService = new UserServiceImpl(); 
		User user = userService.getUser(1);
		assertEquals("Bret", user.getUsername());
	}
	
	@Test
	void testPhotosByAlbum() throws Exception {
		PhotoServiceImpl photosService= new PhotoServiceImpl(); 
		List<Photo> photos = photosService.getPhotosByAlbum(2);
		assertEquals(50, photos.size());
	}
	
	@Test
	void testCommentsByUser() throws Exception {
		CommentServiceImpl commentsService= new CommentServiceImpl(); 
		List<Comment> comments= commentsService.getCommentsByUserOrName(2, null);
		assertEquals(50, comments.size());
	}
	

}
