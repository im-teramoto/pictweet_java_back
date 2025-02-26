package in.tech_camp.pictweet.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import in.tech_camp.pictweet.entity.TaskEntity;

@Mapper
public interface TaskRepository {
  @Select("SELECT * FROM tasks")
  List<TaskEntity> findAll();


  @Insert("INSERT INTO tasks (userid,title,description,status,priority,due_date) VALUES (#{user.userid}, #{title}, #{description}, #{status}, #{priority},CURRENT_DATE)")
  @Options(useGeneratedKeys = true, keyProperty = "taskid")
  void insert(TaskEntity task);
}
