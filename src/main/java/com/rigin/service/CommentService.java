package com.rigin.service;

import com.rigin.model.entity.Activity;
import com.rigin.model.entity.Comment;
import com.rigin.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
public class CommentService {
//    private final CommentRepository commentRepository;
//
//    public void createComment(String content) {
//        commentRepository.save(Comment.createComment()
//                .createdDate(getNowDate())
//                .content(content)
//                .build());
//    }
//
//    public void updateComment(Long id, String content) {
//        var comment = commentRepository.findById(id);
//        if (comment.isPresent()) {
//            log.warn("{} id of activity  updated", id);
//            commentRepository.update(new Comment(id,content,getNowDate(),comment.get().getCreatedDate()));        } else {
//            log.warn("{} id of activity not updated", id);
//        }
//    }
//
//    private static Date getNowDate() {
//        Date updatedDate;
//        LocalDateTime localDateTime = LocalDateTime.now();
//        updatedDate = Date.from(localDateTime.toInstant(ZoneOffset.of("+08:00")));
//        return updatedDate;
//    }
}
