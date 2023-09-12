package com.myshop.myShop.controller;

import com.myshop.myShop.dto.request.PostSaveRequest;
import com.myshop.myShop.dto.request.PostUpdateRequest;
import com.myshop.myShop.dto.response.IdResponse;
import com.myshop.myShop.dto.response.PostResponse;
import com.myshop.myShop.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("posts")
public class PostController {

    private final PostService postService;

    // 게시판글 조회
    @GetMapping("{id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable Long id) {

        PostResponse response = postService.getPost(id);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 게시판글 생성
    @PostMapping("save")
    public ResponseEntity<IdResponse> savePost(@RequestBody PostSaveRequest request) {

        Long feedId = postService.savePost(request);

        IdResponse response = IdResponse.builder()
                .id(feedId)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 게시판글 수정
    @PostMapping("{postId}")
    public ResponseEntity<Void> updatePost(@PathVariable Long postId, @RequestBody PostUpdateRequest request) throws IOException {

        postService.updatePost(postId, request);

        return new ResponseEntity(HttpStatus.OK);
    }


    // 게시판글 삭제
    @PostMapping("{postId}/delete")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) throws IOException {

        postService.deletePost(postId);

        return new ResponseEntity(HttpStatus.OK);
    }
}
