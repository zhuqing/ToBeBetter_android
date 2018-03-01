package xyz.tobebetter.entity;



/**
 * Created by zhuleqi on 2018/2/23.
 */
public class Message {
    public final static int ERROR = -1;
    public final static int SUCCESS = 0;
    private String message;
    private int status;
    private String data;



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    /**
     * 状态　
     */
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
