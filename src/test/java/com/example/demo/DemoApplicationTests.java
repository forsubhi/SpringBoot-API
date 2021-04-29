package com.example.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    CommentService commentService;

	@Autowired
	CommentWriterService commentWriterService;

    @Test
    void testGetComments() {
        List<CommentDTO> comments = commentService.getComments();
        assert comments.size() > 0;
    }


	@Test
	void testWriteComments() {
		List<CommentDTO> comments = commentService.getComments();
		try {
			File file = commentWriterService.writeComments(comments);
			assert file.exists();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
