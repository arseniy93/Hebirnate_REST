package com.rigin;

import com.rigin.administration.Administrator;
import com.rigin.enums.ChangeFieldOfUser;
import com.rigin.enums.TasksList;
import com.rigin.model.entity.User;
import com.rigin.provider.PropertiesSessionProvider;
import com.rigin.provider.SessionProvider;
import com.rigin.repository.ActivityRepository;
import com.rigin.repository.CommentRepository;
import com.rigin.repository.TaskRepository;
import com.rigin.repository.UserRepository;
import com.rigin.service.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;


@Slf4j
public class Application {

//    private static final SessionProvider sessionProvider = new PropertiesSessionProvider();
//    private static final SessionFactory sessionFactory = sessionProvider.getSessionFactory();
//    private static final UserRepository userRepository = new UserRepository(sessionFactory);
//    private static final UserService userService = new UserService(userRepository);


    public static void main(String[] args) {


//        log.info("Start app");activity
//        System.out.println("ASdsad");


        SessionProvider sessionProvider = new PropertiesSessionProvider();
        SessionFactory sessionFactory = sessionProvider.getSessionFactory();
        TaskRepository taskRepository = new TaskRepository(sessionFactory);
        UserRepository userRepository = new UserRepository(sessionFactory);
        CommentRepository commentRepository = new CommentRepository(sessionFactory);
        ActivityRepository activityRepository = new ActivityRepository(sessionFactory);


        UserService userService = new UserService(userRepository, taskRepository, activityRepository, commentRepository);
        //System.out.println(userService.getTaskById(3L).getTasksList().getNameOfField());
        System.out.println(userService.getTaskById(4L).getTasksList());
        var task=userService.getTaskById(4L);
        userService.updateTask(task,task.getTitle(), task.getDescription(), TasksList.DONE);
//        Set<Activity> activities=new HashSet<>();
//        activities.add(activityRepository.findById(4L).get());
//        activities.add(activityRepository.findById(3L).get());
      //
//        userService.deleteTask(2L);
//        var user=userService.getUserById(1L);
//        user.get().setPassword("new Password");
        //System.out.println(userService.getUserById(2L).get());
//        userService.createComment("creant new content", userService.getTaskById(4L),userService.getUserById(2L).get());
       // userService.updateComment(userService.getCommentById(46L),"update new content");
        // userService.updateTask(userService.getTaskById(3L),"Update title 2 time","Updating 2");
        //System.out.println(userService.getActivityById(1L));

//        AdministratorService administratorService=new AdministratorService();
//        System.out.println(administratorService.isAdmin("anton", "anton"));
       // System.out.println(administratorService.isAdmin("anton", "aasdnton"));

        //userService.createComment("Frist commetn",userService.getTaskById(1L),userService.getUserById(1L).get());
//        var user = userService.getUserById(1L);
//        userService.updateTask(2l,"uupdate","descripy",user.get());
        //userService.updateActivity(2L,"change 23",user.get(),task.get());

//        CommentRepository commentRepository=new CommentRepository(sessionFactory);
//        CommentService commentService=new CommentService(commentRepository);
//        commentService.createComment("3 comment");
//        commentService.createComment("4 comment");
//        commentService.updateComment(1L,"change first comment");
//        ActivityRepository activityRepository=new ActivityRepository(sessionFactory);
//        ActivityService activityService=new ActivityService(activityRepository);
//
//        activityService.updateActivity(6L,"NEW smth");
//        TaskRepository taskRepository=new TaskRepository(sessionFactory);
//        TaskService taskService=new TaskService(taskRepository);
//        taskService.createTask("Home", "clean me room");

//        UserRepository userRepository = new UserRepository(sessionFactory);
//        UserService userService = new UserService(userRepository);
//        System.out.println(userService.getIdByEmail("arse@mail.ru"));

        //System.out.println(TasksList.DONE.getNameOfField());
//        UserSignInDto userSignInDto=UserSignInDto.builder()
//                .name("SAdfasdf")
//                .lastName("lastName")
//                .email("email")
//                .password("password")
//                .build();
//        User user = UserMapper.INSTANCE.registerUser(userSignInDto);
//        System.out.println(user);
//        System.out.println(userSignInDto);


//        LogInServer logInServer=new LogInServer(userService);
//        Optional<UserLogInDto> userSignInDto=Optional.empty();
//        if (logInServer.getUsetByPasswordAndEmail("arse@mail.ru", "fdre&432-9").isPresent()) {
//            userSignInDto=logInServer.getUsetByPasswordAndEmail("arse@mail.u", "fdre&432-9");
//            System.out.println(userSignInDto.get().toString());
//        }
//        else {
//            log.warn(USER_NOT_FOUND);
//            System.out.println();
//        }


//        User user=userService.getUserById(1l).get();
//        UserSignInDto userSignInDto= UserMapper.INSTANCE.userToUserCommand(user);
//        System.out.println(userSignInDto);
//        System.out.println(user.toString());
        //UserService userService = new UserService(userRepository);
        //userService.getAll().forEach(x-> System.out.println(x.toString()));
//        userService.updateById(2L, ChangeFieldOfUser.EMAIL,"arse@mail.ru");
        //System.out.println(userService.getIdByEmail("assdfsdfdas@mail.ru"));
        //userService.save("Sam","Rigin","Vladimirovich"       ,"arsenit@mail.ru","qsiiwqw234");
        //userService.deleteById(4L);
        //userService.deleteById(5L);
//        Optional<User> user=userService.getById(6l);
//        user= Optional.ofNullable(user.get().toBuilder().email("ars@mailcom").build());
        //System.out.println(userService.getById(3l).toString());
        //userService.updateById(6L,user.get());
//        userService.deleteById(6L);
//        System.out.println(userService.updateById(6L, EMAIL, "arseniy.rigin@mail"));
//        userService.updateById(6L,user.get());
        //System.out.println();//TODO optional
//        System.out.println(user.get().toString());

    }
}
