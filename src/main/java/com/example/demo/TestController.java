package com.example.demo;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    CommentService commentService;

    @Autowired
    CommentWriterService commentWriterService;

    @RequestMapping("/getComments")
    void getComments(HttpServletRequest request,
                     HttpServletResponse response, @RequestParam(required = false) boolean showError) throws Exception {

        if (showError) {
            throw new CustomException("showError", "This error is for testing");
        }

        List<CommentDTO> comments =
                commentService.getComments();

        File file = commentWriterService.writeComments(comments);
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "attachment; filename=" + file.getName());
        Files.copy(file.toPath(), response.getOutputStream());
        response.getOutputStream().flush();

    }


}
