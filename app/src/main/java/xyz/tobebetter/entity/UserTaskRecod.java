package xyz.tobebetter.entity;

import java.io.Serializable;

import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * 用户任务的执行记录
 * Created by zhuleqi on 2018/2/11.
 */
public class UserTaskRecod   extends RealmObject implements Serializable {

    @PrimaryKey
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
    private long userTaskId;
    private Long userId;
    private String title;
    private String content;


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
