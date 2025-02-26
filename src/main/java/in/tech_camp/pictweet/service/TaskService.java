package in.tech_camp.pictweet.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.tech_camp.pictweet.entity.TaskEntity;
import in.tech_camp.pictweet.repository.TaskRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskService {
  private final TaskRepository taskRepository;

  private final PasswordEncoder passwordEncoder;

  public void createUserWithEncryptedPassword(TaskEntity taskEntity) {

  }

}