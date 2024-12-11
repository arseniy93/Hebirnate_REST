package com.rigin.service;

import com.rigin.enums.TasksList;
import com.rigin.repository.TaskRepository;
import com.rigin.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserCabinetService {

    private final TaskRepository taskRepository;
    private final TaskService taskService;

//    public void createNewTask(String title, String description) {
//        taskRepository.save(taskService.createTask(title,description));
//    }


}
