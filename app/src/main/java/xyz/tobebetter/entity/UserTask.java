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
    private Integer seconds;
    private Long userId;


    @Generated(hash = 1202343090)
    public UserTask(String id, Long createDate, Long updateDate, Integer status,
            String title, Integer seconds, Long userId) {
        this.id = id;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.status = status;
        this.title = title;
        this.seconds = seconds;
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





    /**
     * 任务创建的用户Id
     */
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserTask clone(){
        UserTask userTask = new UserTask();
        userTask.setId(this.getId());
        userTask.setTitle(this.getTitle());
        userTask.setUserId(this.getUserId());
        userTask.setSeconds(this.getSeconds());
        userTask.setStatus(this.getStatus());
        userTask.setCreateDate(this.getCreateDate());
        userTask.setUpdateDate(this.getUpdateDate());
        return userTask;
    }


    /**
     * 秒数
     */
    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }




}
