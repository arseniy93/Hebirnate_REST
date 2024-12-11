package com.rigin.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "activity")

public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", content='" + content + '\'' +
                '}';
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private Task task;

    @Builder(builderMethodName = "createActivity")
    public Activity(Date createdDate, Date updatedDate, String content, User user,Task task) {
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.content = content;
        this.user=user;
        this.task=task;
    }
   // @Builder(toBuilder = true, builderMethodName = "updateActivity")
    public Activity(Activity activity,Date updatedDate,String content,User user,Task task) {
        this.id = activity.getId();
        this.updatedDate = updatedDate;
        this.content = content;
        this.user=user;
        this.task=task;
        this.createdDate=activity.getCreatedDate();
    }

    private Date createdDate;
    private Date updatedDate;
    private String content;

}