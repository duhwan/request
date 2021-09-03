package taskmanager;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="RequestTask_table")
public class RequestTask {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long requesterId;
    private String requesterName;
    private String taskContents;
    private Date dueDate;
    private Long taskManagerId;
    private String taskManagerName;
    private String taskStatus;  

    @PostPersist
    public void onPostPersist(){

        System.out.println("*****Task 등록이 요청됨*****");

        TaskRequested taskRequested = new TaskRequested();
        BeanUtils.copyProperties(this, taskRequested);
        taskRequested.publishAfterCommit();

    }

    @PreRemove
    public void onPreRemove(){

        System.out.println("*****Task 삭제가 요청됨*****");


        TaskCancelled taskCancelled = new TaskCancelled();
        BeanUtils.copyProperties(this, taskCancelled);
        taskCancelled.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        taskmanager.external.ProcessTask processTask = new taskmanager.external.ProcessTask();
        // mappings goes here
        RequestTaskApplication.applicationContext.getBean(taskmanager.external.ProcessTaskService.class)
            .deleteProcessTask(processTask);

    }
    
        @PreUpdate
        public void onPreUpdate(){
            TaskCancelled taskCancelled = new TaskCancelled();
            BeanUtils.copyProperties(this, taskCancelled);
            taskCancelled.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        taskmanager.external.ProcessTask processTask = new taskmanager.external.ProcessTask();
        // mappings goes here
        RequestTaskApplication.applicationContext.getBean(taskmanager.external.ProcessTaskService.class)
            .deleteProcessTask(processTask);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(Long requesterId) {
        this.requesterId = requesterId;
    }
    public String getRequesterName() {
        return requesterName;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }
    public String getTaskContents() {
        return taskContents;
    }

    public void setTaskContents(String taskContents) {
        this.taskContents = taskContents;
    }
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    public Long getTaskManagerId() {
        return taskManagerId;
    }

    public void setTaskManagerId(Long taskManagerId) {
        this.taskManagerId = taskManagerId;
    }
    public String getTaskManagerName() {
        return taskManagerName;
    }

    public void setTaskManagerName(String taskManagerName) {
        this.taskManagerName = taskManagerName;
    }
    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }




}