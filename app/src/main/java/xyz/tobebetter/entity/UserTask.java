package xyz.tobebetter.entity;

import org.greenrobot.greendao.annotation.*;

import java.io.Serializable;


/**
 * Created by zhuleqi on 2018/2/10.
 */
@org.greenrobot.greendao.annotation.Entity

public class UserTask  implements Serializable ,Cloneable {

    @Id
    private String id;
    private Long createDate;
    private Long updateDate;
    private Integer status;


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Long updateDate) {
        this.updateDate = updateDate;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    private String title;
    /**
     *任务时长的秒数
     */
    private Integer seconds;
    /**
     * 任务开始时间
     */
    private Long startDate;
    private String userId;


    @Generated(hash = 954917785)
    public UserTask(String id, Long createDate, Long updateDate, Integer status,
            String title, Integer seconds, Long startDate, String userId) {
        this.id = id;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.status = status;
        this.title = title;
        this.seconds = seconds;
        this.startDate = startDate;
        this.userId = userId;
    }

    @Generated(hash = 841106868)
    public UserTask() {
    }


    /**
     * 任务名称
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }





    @Override
    public UserTask clone(){
        UserTask userTask = new UserTask();
        userTask.setId(this.getId());
        userTask.setTitle(this.getTitle());
        userTask.setSeconds(seconds);
        userTask.setStartDate(startDate);
        userTask.setUserId(userId);

        userTask.setStatus(this.getStatus());
        userTask.setCreateDate(this.getCreateDate());
        userTask.setUpdateDate(this.getUpdateDate());
        return userTask;
    }

    /**
     * 任务时长的秒数
     * @return the seconds
     */
    public Integer getSeconds() {
        return seconds;
    }

    /**
     * 任务时长的秒数
     * @param seconds the seconds to set
     */
    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }

    /**
     * 任务开始时间
     * @return the startDate
     */
    public Long getStartDate() {
        return startDate;
    }

    /**
     * 任务开始时间
     * @param startDate the startDate to set
     */
    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }



}
