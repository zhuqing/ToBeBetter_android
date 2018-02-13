package xyz.tobebetter.entity;

/**
 * Created by zhuqing on 2017/8/19.
 */

public class Aritcal {
    private Long id;
    private Long createTime;
    private String title;
    private Long readCoung;
    private Long updateTime;
    private String imagePath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getReadCoung() {
        return readCoung;
    }

    public void setReadCoung(Long readCoung) {
        this.readCoung = readCoung;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
