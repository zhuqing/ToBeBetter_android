package xyz.tobebetter.database;

import java.util.Arrays;
import java.util.List;


import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.UserTask;
import xyz.tobebetter.entity.UserTaskRecod;
import xyz.tobebetter.sf.LQService;
import xyz.tobebetter.util.LQHandler;
import xyz.tobebetter.util.UrlConfigUtil;

/**
 * Created by zhuleqi on 2018/2/12.
 */
public class UserTaskRecodeDataManager {

    private static UserTaskRecodeDataManager userTaskRecodeDataManager;

    private String createUrl;

    private UserTaskRecodeDataManager() {

    }

    public static UserTaskRecodeDataManager getInstance() {
        if(userTaskRecodeDataManager == null){
            userTaskRecodeDataManager = new UserTaskRecodeDataManager();
        }
        return userTaskRecodeDataManager;
    }

    public void insert(final UserTaskRecod userTaskRecod){

        if(DBManager.getInstance() == null){
            return;
        }
        DBManager.getInstance().getDaoSession().runInTx(new Runnable() {
            @Override
            public void run() {
                LQService.post(getCreateUrl(), Message.class, userTaskRecod, null, new LQHandler.Consumer<Message>() {
                    @Override
                    public void applay(Message message) {
                        if (message.getStatus() != Message.ERROR){
                            DBManager.getInstance().getUserTaskRecodDao().insert((UserTaskRecod) message.getData());
                        }

                    }
                });
            }
        });


    }

    public String getCreateUrl(){
        if(this.createUrl == null){
            StringBuilder stringBuilder = new StringBuilder();
            UrlConfigUtil urlConfigUtil = UrlConfigUtil.getInstance();
            stringBuilder.append(urlConfigUtil.get("HOST")).append(urlConfigUtil.get("USER_TASK_RECORD_CREATE"));
            createUrl = stringBuilder.toString();
        }

        return this.createUrl;
    }

    public void query(String userId, final LQHandler.Consumer consumer){
        if(DBManager.getInstance() == null){
            return;
        }

        List<UserTaskRecod> userTaskList = DBManager.getInstance().getUserTaskRecodDao().queryRaw("where user_Id = ?", userId + "");
        consumer.applay(userTaskList);
    }
}
