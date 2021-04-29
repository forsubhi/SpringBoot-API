package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CommentService {

    final String URL = "https://my-json-server.typicode.com/typicode/demo/comments";
    Logger logger = LoggerFactory.getLogger(CommentService.class);

    public List<CommentDTO> getComments() {
        logger.info("getComments started");
        RestTemplate restTemplate = new RestTemplate();
        CommentDTO[] commentDTOS = restTemplate.getForObject(URL, CommentDTO[].class);
        List<CommentDTO> commentDTOList = Arrays.asList(commentDTOS);
        return commentDTOList;
    }

}
