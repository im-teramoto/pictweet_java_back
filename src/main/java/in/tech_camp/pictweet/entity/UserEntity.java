package in.tech_camp.pictweet.entity;

import java.util.List;

import lombok.Data;

@Data
public class UserEntity {
  private Integer userid;
  private String username;
  private String email;
  private String password;
}
