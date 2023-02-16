package com.technoelevate.postsharing.request;

import com.technoelevate.postsharing.model.Post;
import com.technoelevate.postsharing.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LikeRequest {

    private Post post;
    private User user;


}
