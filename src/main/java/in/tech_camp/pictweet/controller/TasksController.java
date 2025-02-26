package in.tech_camp.pictweet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.tech_camp.pictweet.custom_user.CustomUserDetail;
import in.tech_camp.pictweet.entity.TaskEntity;
import in.tech_camp.pictweet.entity.UserEntity;
import in.tech_camp.pictweet.form.TasksForm;
import in.tech_camp.pictweet.repository.TaskRepository;
import in.tech_camp.pictweet.repository.UserRepository;
import in.tech_camp.pictweet.service.TaskService;
import in.tech_camp.pictweet.validation.ValidationOrder;
import lombok.AllArgsConstructor;

import org.springframework.security.core.Authentication;


@RestController
@RequestMapping("/api/tasks")
@AllArgsConstructor
public class TasksController {

  private final TaskRepository taskRepository;

  private final UserRepository userRepository;

 @GetMapping("/")
  public List<TaskEntity> showIndex(Model model) {
    List<TaskEntity> tasks = taskRepository.findAll();
    return tasks;
  }
/* 
  @GetMapping("/tasks/new")
  public String showTweetNew(Model model){
    model.addAttribute("tasksForm", new TasksForm());
    return "task/new";
  } */


 @PostMapping("/")
  public ResponseEntity<?> createTask(@RequestBody @Validated(ValidationOrder.class) TasksForm taskForm,
                            BindingResult result, 
                            @AuthenticationPrincipal CustomUserDetail currentUser) {
    if (result.hasErrors()) {
      List<String> errorMessages = result.getAllErrors().stream()
              .map(DefaultMessageSourceResolvable::getDefaultMessage)
              .collect(Collectors.toList());
      return ResponseEntity.badRequest().body(Map.of("messages", errorMessages));
    }

    TaskEntity taskEntity = new TaskEntity();
    taskEntity.setUser(userRepository.findById(currentUser.getId()));
    taskEntity.setTitle(taskForm.getTitle());
    taskEntity.setStatus(taskForm.getStatus());
    taskEntity.setDescription(taskForm.getDescription());
    taskEntity.setPriority(taskForm.getPriority());

    try {
      taskRepository.insert(taskEntity);
      return ResponseEntity.ok().body(taskEntity);
    } catch (Exception e) {
      System.out.println("エラー：" + e);
      return ResponseEntity.internalServerError().body(Map.of("messages", List.of("Internal Server Error")));
    }
  }
}
