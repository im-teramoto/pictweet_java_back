package in.tech_camp.pictweet.entity;

import lombok.Data;

@Data
public class TaskEntity{
  private UserEntity user;
  private String taskid;
  private String title;
  private String description;
  private String status;
  private String priority;
}
