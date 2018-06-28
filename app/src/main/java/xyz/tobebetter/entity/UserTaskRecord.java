package xyz.tobebetter.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.greenrobot.greendao.annotation.Id;

import java.io.IOException;
import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;


/**
 * 用户任务的执行记录
 * Created by zhuleqi on 2018/2/11.
 */
@org.greenrobot.greendao.annotation.Entity
public class UserTaskRecord   implements Serializable {



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

    private Boolean isSave;





    @Generated(hash = 1805180489)
    public UserTaskRecord(String id, Long createDate, Long updateDate, Integer status, String userTaskId, String userId,
            String title, String content, Boolean isSave) {
        this.id = id;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.status = status;
        this.userTaskId = userTaskId;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.isSave = isSave;
    }

    @Generated(hash = 1580538758)
    public UserTaskRecord() {
    }







    @JsonCreator
    public static UserTaskRecord create(String jsonString) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        UserTaskRecord module = null;
        module = mapper.readValue(jsonString, UserTaskRecord.class);
        return module;
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

    public Boolean getIsSave() {
        if(isSave==null){
            isSave = false;
        }
        return isSave;
    }

    public void setIsSave(Boolean isSave) {
        this.isSave = isSave;
    }
}
