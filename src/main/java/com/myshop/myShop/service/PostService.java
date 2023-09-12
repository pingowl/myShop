package com.myshop.myShop.service;

import com.myshop.myShop.common.exception.CustomException;
import com.myshop.myShop.common.exception.ErrorCode;
import com.myshop.myShop.domain.Post;
import com.myshop.myShop.dto.request.PostSaveRequest;
import com.myshop.myShop.dto.request.PostUpdateRequest;
import com.myshop.myShop.dto.response.PostResponse;
import com.myshop.myShop.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class PostService {

    private final PostRepository postRepository;

    // 게시판글 조회
    public PostResponse getPost(Long postId) {

        Post findPost = getPostOrThrow(postId);

        PostResponse response = PostResponse.builder()
                .id(findPost.getId())
                .title(findPost.getTitle())
                .content(findPost.getContent())
                .author(findPost.getAuthor())
                .build();

        return response;
    }


    // 게시판글 등록
    public Long savePost(PostSaveRequest request) {

        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .author(request.getAuthor())
                .build();

        postRepository.save(post);

        return post.getId();
    }

    // 게시판글 수정
    public void updatePost(Long postId, PostUpdateRequest request) throws IOException {

        Post findPost = getPostOrThrow(postId);
        findPost.updatePost(request);
    }


    // 게시판글 삭제



    // 예외 처리 - 존재하는 post인지
    private Post getPostOrThrow(Long postId) {

        return postRepository.findById(postId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_POST));
    }
}
