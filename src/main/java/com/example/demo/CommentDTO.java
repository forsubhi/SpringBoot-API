package com.example.demo;

import io.swagger.annotations.ApiModelProperty;

public class CommentDTO {

    @ApiModelProperty(example = "1")
    Long id;

    @ApiModelProperty(example = "some comment")
    String body;

    @ApiModelProperty(example = "1")
    Long postId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
