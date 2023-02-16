package com.technoelevate.postsharing.request;

import com.technoelevate.postsharing.model.Comment;
import com.technoelevate.postsharing.model.Post;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentRequest {

    private Post post;
    private Comment comment;

}
