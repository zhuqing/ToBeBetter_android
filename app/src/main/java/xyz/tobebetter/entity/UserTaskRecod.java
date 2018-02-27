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


    private long userTaskId;
    private Long userId;
    private String title;
    private String content;

    @Id
    private String id;
    private Long createDate;
    private Long updateDate;
    private Integer status;



    @Generated(hash = 1927381430)
    public UserTaskRecod(long userTaskId, Long userId, String title,
            String content, String id, Long createDate, Long updateDate,
            Integer status) {
        this.userTaskId = userTaskId;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.id = id;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.status = status;
    }

    @Generated(hash = 273789623)
    public UserTaskRecod() {
    }



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





    /**
     * 用户任务的id
     */
    public long getUserTaskId() {
        return userTaskId;
    }

    public void setUserTaskId(long userTaskId) {
        this.userTaskId = userTaskId;
    }

    /**
     * 用户Id
     */
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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
