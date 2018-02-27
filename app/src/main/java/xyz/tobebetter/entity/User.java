package xyz.tobebetter.entity;

import org.greenrobot.greendao.annotation.*;

import java.io.Serializable;


import io.realm.annotations.PrimaryKey;

/**
 * Created by zhuqing on 2017/7/21.
 */
@org.greenrobot.greendao.annotation.Entity
public class User  implements Serializable

    {


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

    private String name;
    private String password;
    private String email;

    @Generated(hash = 2115934450)
    public User(String id, Long createDate, Long updateDate, Integer status,
            String name, String password, String email) {
        this.id = id;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.status = status;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    @Generated(hash = 586692638)
    public User() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
