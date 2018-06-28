package xyz.tobebetter.entity;

import org.greenrobot.greendao.annotation.*;
import java.io.Serializable;

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

        private Boolean isSave;

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
        /**
         * 手机号码
         */
        private String phonenumber;


        /**
         * 其他系统的Id
         */
        private String othersysId;

        @Generated(hash = 720491143)
        public User(String id, Long createDate, Long updateDate, Integer status,
                Boolean isSave, String name, String password, String email,
                String phonenumber, String othersysId) {
            this.id = id;
            this.createDate = createDate;
            this.updateDate = updateDate;
            this.status = status;
            this.isSave = isSave;
            this.name = name;
            this.password = password;
            this.email = email;
            this.phonenumber = phonenumber;
            this.othersysId = othersysId;
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

        public String getOthersysId() {
            return othersysId;
        }

        public void setOthersysId(String othersysId) {
            this.othersysId = othersysId;
        }

        /**
         * 手机号
         */
        public String getPhonenumber() {
            return phonenumber;
        }

        public void setPhonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
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
