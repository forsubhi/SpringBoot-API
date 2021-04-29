package com.example.demo;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.Arrays;
import java.util.List;

@Service
public class CommentWriterService {


    Logger logger = LoggerFactory.getLogger(CommentService.class);


    public File writeComments(List<CommentDTO> comments) throws IOException {
        logger.info("writeComments started");
        StringWriter out = new StringWriter();
        CSVPrinter csvPrinter = new CSVPrinter(out, CSVFormat.DEFAULT.withHeader("id", "body", "postId"));
        for (CommentDTO comment : comments) {
            csvPrinter.printRecord(Arrays.asList(comment.getId(), comment.getBody(), comment.getPostId()));
        }

        csvPrinter.flush();
        String fileName = "test.xlsx";
        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(out);
        printWriter.close();
        File f = new File(fileName);
        return f;
    }

}
