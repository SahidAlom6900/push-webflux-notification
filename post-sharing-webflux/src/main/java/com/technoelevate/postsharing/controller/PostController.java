package com.technoelevate.postsharing.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technoelevate.postsharing.model.Comment;
import com.technoelevate.postsharing.model.Post;
import com.technoelevate.postsharing.request.CommentRequest;
import com.technoelevate.postsharing.request.LikeRequest;
import com.technoelevate.postsharing.service.PostService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/stream")
    public Flux<ServerSentEvent<List<Post>>> streamPosts() {
        return postService.streamPosts();
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAll());
    }

    @GetMapping("/{postID}")
    public ResponseEntity<Post> getPostById(@PathVariable String postID) {
        return ResponseEntity.ok(postService.getPostByID(postID));
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.create(post));
    }

    @GetMapping("/comment/{postID}")
    public ResponseEntity<List<Comment>> getCommentsByPostID(@PathVariable String postID) {
        return ResponseEntity.ok(postService.getCommentsByPostID(postID));
    }

    @PostMapping("/comment")
    public ResponseEntity<Post> addComment(@RequestBody CommentRequest commentRequest) {
        return ResponseEntity.ok(postService.addComment(commentRequest));
    }

    @DeleteMapping("/comment")
    public ResponseEntity<Post> removeComment(@RequestBody CommentRequest commentRequest) {
        return ResponseEntity.ok(postService.removeComment(commentRequest));
    }

    @PostMapping("/like")
    public ResponseEntity<Post> addLike(@RequestBody LikeRequest likeRequest) {
        return ResponseEntity.ok(postService.addLike(likeRequest));
    }

    @DeleteMapping("/like")
    public ResponseEntity<Post> removeLike(@RequestBody LikeRequest likeRequest) {
        return ResponseEntity.ok(postService.removeLike(likeRequest));
    }

    @DeleteMapping("/{postID}")
    public ResponseEntity<?> deletePostByID(@PathVariable String postID) {
        postService.deletePostByID(postID);
        return ResponseEntity.ok().build();
    }

}
