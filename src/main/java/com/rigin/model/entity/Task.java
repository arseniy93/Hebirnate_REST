package com.rigin.model.entity;

import com.rigin.enums.TasksList;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;


    @Column(name = "status")
    private String tasksList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @OneToMany(mappedBy = "task", orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Activity> activities = new HashSet<>();
    ;
    @OneToMany(mappedBy = "task", orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();

    @Builder(builderMethodName = "updateDescriptionTitle")
    public Task(Task task, String description, String title, String tasksList) {
        this.id = task.getId();
        this.description = description;
        this.title = title;
        this.user = task.getUser();
        this.tasksList = tasksList;
    }


    @Builder(builderMethodName = "updateActivityOfTaskByIdAndUser")
    public Task(Set<Activity> activities, Long id, User user) {
        this.id = id;
        this.activities = activities;
        this.user = user;
    }

    @Builder(builderMethodName = "updateCommentOfTaskByIdAndUser")
    public Task(Long id, Set<Comment> comments, User user) {
        this.id = id;
        this.comments = comments;
        this.user = user;
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "title = " + title + ", " +
                "description = " + description +
                "tasksList=" + tasksList + ")";
    }
}
