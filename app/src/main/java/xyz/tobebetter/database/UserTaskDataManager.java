package xyz.tobebetter.database;

import android.app.Application;
import android.os.AsyncTask;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;


import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.UserTask;

import xyz.tobebetter.entity.UserTaskRecord;
import xyz.tobebetter.sf.LQService;
import xyz.tobebetter.util.LQHandler;
import xyz.tobebetter.util.UrlConfigUtil;

/**
 * Created by zhuleqi on 2018/2/12.
 */
public class UserTaskDataManager {


    private String createUrl;

    private static UserTaskDataManager userTaskDataManager;

    private UserTaskDataManager() {

    }

    public static UserTaskDataManager getInstance() {
        if (userTaskDataManager == null) {
            userTaskDataManager = new UserTaskDataManager();
        }
        return userTaskDataManager;
    }


    public void insert(final UserTask userTask, final UserTaskRecord userTaskRecord) {
        if (DBManager.getInstance() == null) {
            return;
        }
        userTask.setIsSave(false);

        DBManager.getInstance().getDaoSession().runInTx(new Runnable() {
            @Override
            public void run() {
                if (LQService.isNetworkConnected(DBManager.context)) {
                    LQService.post(getCreateUrl(), UserTask.class, userTask, null, new LQHandler.Consumer<UserTask>() {
                        @Override
                        public void applay(UserTask userTask1) {
                            if (userTask1 != null) {
                                insertI(userTask1, userTaskRecord);
                            } else {
                                insertI(userTask, userTaskRecord);
                            }

                        }
                    });
                } else {
                    insertI(userTask, userTaskRecord);
                }

            }
        });


    }




    public void insertI(UserTask userTask,UserTaskRecord userTaskRecord){
        DBManager.getInstance().getUserTaskDao().insert(userTask);
        userTaskRecord.setUserTaskId(userTask.getId());
        UserTaskRecordDataManager.getInstance().insert(userTaskRecord);
    }

    public String getCreateUrl() {
        if (this.createUrl == null) {
            StringBuilder stringBuilder = new StringBuilder();
            UrlConfigUtil urlConfigUtil = UrlConfigUtil.getInstance();
            stringBuilder.append(urlConfigUtil.get("HOST")).append(urlConfigUtil.get("USER_TASK_CREATE"));
            createUrl = stringBuilder.toString();
        }

        return this.createUrl;
    }

    public void query(String id) {

    }

    public void update(UserTask userTask) {
        if (DBManager.getInstance() == null) {
            return;
        }

        DBManager.getInstance().getUserTaskDao().update(userTask);
    }

    public void queryAll(final LQHandler.Consumer consumer){
       AsyncTask asyncTask =  new AsyncTask<Object,Object,List<UserTask>>(){

            @Override
            protected List<UserTask> doInBackground(Object[] params) {
                return DBManager.getInstance().getUserTaskDao().queryRaw("");
            }

            @Override
            protected void onPostExecute(List<UserTask> t) {
                consumer.applay(t);
            }
        };
        asyncTask.execute();

    }

    public void query(int status, final LQHandler.Consumer consumer) {
        if (DBManager.getInstance() == null) {
            return;
        }

        List<UserTask> userTaskList = DBManager.getInstance().getUserTaskDao().queryRaw(" where status = ?", status + "");
        consumer.applay(userTaskList);
    }

}
