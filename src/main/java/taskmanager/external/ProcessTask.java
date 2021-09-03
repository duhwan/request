package taskmanager.external;

import java.util.Date;

public class ProcessTask {

    private Long id;
    private Long requestTaskId;
    private String taskContents;
    private Date duDate;
    private Date startDate;
    private Date completeDate;
    private Long requesterId;
    private String requesterName;
    private Long processTaskManagerId;
    private String processTaskManagerName;
    private String taskStatus;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getRequestTaskId() {
        return requestTaskId;
    }
    public void setRequestTaskId(Long requestTaskId) {
        this.requestTaskId = requestTaskId;
    }
    public String getTaskContents() {
        return taskContents;
    }
    public void setTaskContents(String taskContents) {
        this.taskContents = taskContents;
    }
    public Date getDuDate() {
        return duDate;
    }
    public void setDuDate(Date duDate) {
        this.duDate = duDate;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getCompleteDate() {
        return completeDate;
    }
    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
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
    public Long getProcessTaskManagerId() {
        return processTaskManagerId;
    }
    public void setProcessTaskManagerId(Long processTaskManagerId) {
        this.processTaskManagerId = processTaskManagerId;
    }
    public String getProcessTaskManagerName() {
        return processTaskManagerName;
    }
    public void setProcessTaskManagerName(String processTaskManagerName) {
        this.processTaskManagerName = processTaskManagerName;
    }
    public String getTaskStatus() {
        return taskStatus;
    }
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

}
