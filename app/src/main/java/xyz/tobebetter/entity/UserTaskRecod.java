package xyz.tobebetter.entity;

import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;


/**
 * 用户任务的执行记录
 * Created by zhuleqi on 2018/2/11.
 */
@org.greenrobot.greendao.annotation.Entity
public class UserTaskRecod   implements Serializable {



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




    private String userTaskId;
    private String userId;
    private String title;
    private String content;






    @Generated(hash = 1449064280)
    public UserTaskRecod(String id, Long createDate, Long updateDate,
            Integer status, String userTaskId, String userId, String title,
            String content) {
        this.id = id;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.status = status;
        this.userTaskId = userTaskId;
        this.userId = userId;
        this.title = title;
        this.content = content;
    }

    @Generated(hash = 273789623)
    public UserTaskRecod() {
    }


    /**
     * 用户任务的id
     */
    public String getUserTaskId() {
        return userTaskId;
    }

    public void setUserTaskId(String userTaskId) {
        this.userTaskId = userTaskId;
    }

    /**
     * 用户Id
     */
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 记录的标题
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 记录的内容
     */
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
