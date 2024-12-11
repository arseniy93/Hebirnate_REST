package com.rigin.service;

import com.rigin.enums.ChangeFieldOfUser;
import com.rigin.enums.TasksList;
import com.rigin.model.dto.UserLogInDto;
import com.rigin.model.entity.Activity;
import com.rigin.model.entity.Comment;
import com.rigin.model.entity.Task;
import com.rigin.model.entity.User;
import com.rigin.model.mapper.UserMapper;
import com.rigin.repository.ActivityRepository;
import com.rigin.repository.CommentRepository;
import com.rigin.repository.TaskRepository;
import com.rigin.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final ActivityRepository activityRepository;
    private final CommentRepository commentRepository;

    //TODO check all


    public Task getTaskById(Long id) {//work
        return taskRepository.findById(id).get();
    }


    public void deleteTask(Long id) {
        taskRepository.deleteById(id);//work
    }

    public void createTask(Task task){
        taskRepository.save(task);
    }

    public Task updateTask(Task task, String title, String description, TasksList tasksList) {
        String status="";
        if(title.isEmpty()){
            title=task.getTitle();
        }
        if(description.isEmpty()){
            description=task.getDescription();
        }
        if(tasksList==null){
            status=task.getTasksList();
        }
        else{
            status=tasksList.getNameOfField();
        }
        var task1 = Task.updateDescriptionTitle()
                .task(task)//work
                .description(description)
                .title(title)
                .tasksList(status)
                .build();
        taskRepository.update(task1);
        return task1;
    }

    public Activity getActivityById(Long id) {
        return activityRepository.findById(id).get();//work
    }


    public void createActivity(String content, User user, Task task) {
        activityRepository.save(Activity.createActivity()//work
                .createdDate(getNowDate())
                .content(content)
                .user(user)
                .task(task)
                .build());
    }

    private static Date getNowDate() {
        Date updatedDate;
        LocalDateTime localDateTime = LocalDateTime.now();
        updatedDate = Date.from(localDateTime.toInstant(ZoneOffset.of("+08:00")));
        return updatedDate;
    }

    public void updateActivity(Long id, String content, User user, Task task) {
        var activity = activityRepository.findById(id);//work
        if (activity.isPresent()) {
            log.warn("{} id of activity  found", id);
//            Activity activity,Date updatedDate,String content,User user,Task taskk
            activityRepository.update(new Activity(activity.get(), getNowDate(), content, user, task));
        } else {
            log.warn("{} id of activity not found", id);
        }
    }

    public void deleteActivity(Long id) {
        activityRepository.deleteById(id);//work
    }

    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).get();//work
    }

    public void createComment(String content, Task task, User user) {
        commentRepository.save(new Comment(getNowDate(), content, task, user));//work
    }

    public void updateComment(Comment comment, String content) {
        commentRepository.update(Comment.updateComment()
                .comment(comment)
                .updatedDate(getNowDate())
                .content(content)
                .build());

    }


    public Optional<User> getUserById(Long id) {//work
        try {
            return userRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void save(User user) {//work
        userRepository.save(user);
    }

    public List<User> getAll() {//work
        return userRepository.getAll();
    }



    public void deleteUserById(Long id) {
        userRepository.deleteById(id);//work
    }

    public User updateAllFieldsOfUserById(User user) {
        return userRepository.updateById(user.getId(), user);//work
    }

    public Long updateUserById(Long id, ChangeFieldOfUser nameOfField, String nameOfParametr) {//work
        ChangeFieldOfUser[] array = ChangeFieldOfUser.values();
        String fieldOfName = (Arrays.stream(ChangeFieldOfUser
                        .values())
                .filter(x -> (x.getNameOfField())
                        .equals(nameOfField.getNameOfField())).findFirst().get().getNameOfField());
        return userRepository.updateById(id, fieldOfName, nameOfParametr);
    }

    public Optional<UserLogInDto> getUserByEmailAndPassword(String email, String password) {//work
        Optional<UserLogInDto> userSignInDto = Optional.empty();
        var user = userRepository.getUserByEmailAndPassword(email, password);
        if (user.isEmpty()) {
            return userSignInDto;
        } else {
            UserLogInDto userLogInDto1 = UserMapper.INSTANCE.userToUserCommand(user.get());
            return Optional.ofNullable(userLogInDto1);
        }
    }
    public Set<Task> getUsersAndTheirTasks(Long idOfUser){
        return taskRepository.getUserTasksByUserId(idOfUser);
    }

}
