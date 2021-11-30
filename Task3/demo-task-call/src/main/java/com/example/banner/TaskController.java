package com.example.banner;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TaskController {
    @Autowired
    TaskResponsitory taskResponsitory;

    @PutMapping("/tasks/{id}")
    public  ResponseEntity<String> getTaskById(@PathVariable Long id, @RequestBody TaskForm taskForm){
        JSONObject rs = new JSONObject();
        if(taskResponsitory.getOne(id)==null){
            ErrorBean errorBean = new ErrorBean();
            errorBean.setMessage("Cannot find task with given id");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorBean.toString());

        }
        if(taskForm.getDescription()==null || taskForm.getDescription().equals("") ){
            ErrorBean errorBean = new ErrorBean();
            errorBean.setMessage("Task Description is Require");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBean.toString());
        }
        if(taskResponsitory.getOne(id)==null){
            Task task = taskResponsitory.getOne(id);
            task.setDescription(taskForm.getDescription());
            taskResponsitory.save(task);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(rs.toString());
    }

}




class ErrorBean {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

class TaskForm{
    private String description;
    private Long priotity;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPriotity() {
        return priotity;
    }

    public void setPriotity(Long priotity) {
        this.priotity = priotity;
    }
}
interface TaskResponsitory extends JpaRepository<Task,Long> {

}
class Task{
    private Long id;
    private String description;
    private Long priotity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPriotity() {
        return priotity;
    }

    public void setPriotity(Long priotity) {
        this.priotity = priotity;
    }
}
