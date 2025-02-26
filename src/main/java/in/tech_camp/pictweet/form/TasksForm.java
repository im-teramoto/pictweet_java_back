package in.tech_camp.pictweet.form;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.BindingResult;

import in.tech_camp.pictweet.validation.ValidationPriority1;
import in.tech_camp.pictweet.validation.ValidationPriority2;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TasksForm {

  private String taskid;

  private String userid;
  @NotBlank(message = "Title can't be blank", groups = ValidationPriority1.class)
  @Length(max = 20, message = "Title is too long (maximum is 20 characters)", groups = ValidationPriority2.class)
  private String title;

  private String status;

  private String description;

  private String priority;

}
