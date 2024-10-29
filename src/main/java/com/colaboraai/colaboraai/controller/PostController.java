package com.colaboraai.colaboraai.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colaboraai.colaboraai.Model.Post;
import com.colaboraai.colaboraai.Service.PostService;

@RestController
@RequestMapping("/api/categorias")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping(value = { "/", "/{category}" }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<Post>> getPostsByCategory(
            @PathVariable(value = "category", required = false) String category) {

        ArrayList<Post> postList = new ArrayList<>();

        if (category == null) {
            postList = postService.getAllPosts();
            return new ResponseEntity<>(postList, HttpStatus.OK);
        }

        postList = postService.getPostsByCategory(category);

        if (postList == null || postList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createPost(@RequestBody Post post) {
        try {
            postService.createPost(post);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
