package com.rigin.service;

import com.rigin.repository.ActivityRepository;
import com.rigin.repository.CommentRepository;
import com.rigin.repository.TaskRepository;
import com.rigin.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserPersonalCabinetService {

    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final TaskRepository taskRepository;
    private final CommentRepository commentRepository;
    private final TaskService taskService;

//    public void createNewTask(String title, String description) {
//        taskRepository.save(taskService.createTask(title,description));
//    }

//    public void updateTask()

    


}
