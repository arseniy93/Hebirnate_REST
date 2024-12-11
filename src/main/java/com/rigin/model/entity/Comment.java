package com.rigin.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private Task task;

    @Override
    public String toString() {
        return "Comment{" +
                "updatedDate=" + updatedDate +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                ", id=" + id +
                '}';
    }


    private Date updatedDate;
    private String content;
    private Date createdDate;


    public Comment(Date createdDate, String content,Task task,User user) {
        this.createdDate = createdDate;
        this.content = content;
        this.task=task;
        this.user=user;
    }

    @Builder(builderMethodName = "updateComment")
    public Comment(Comment comment, String content, Date updatedDate) {
        this.id = comment.getId();
        this.createdDate=comment.getCreatedDate();
        this.updatedDate = updatedDate;
        this.content = content;
        this.task=comment.getTask();
        this.user=comment.getUser();
    }


}
