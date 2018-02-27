package xyz.tobebetter.database;

import java.util.Arrays;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import xyz.tobebetter.entity.UserTask;
import xyz.tobebetter.util.LQHandler;

/**
 * Created by zhuleqi on 2018/2/12.
 */
public class UserTaskDataManager {



    private static UserTaskDataManager userTaskDataManager;

    private UserTaskDataManager() {

    }

    public static UserTaskDataManager getInstance() {
        if(userTaskDataManager == null){
            userTaskDataManager = new UserTaskDataManager();
        }
        return userTaskDataManager;
    }


    public void insert(final List<UserTask> userTaskList){
        if(DBManager.getInstance() == null){
            return;
        }
       DBManager.getInstance().getUserTaskDao().insertInTx(userTaskList);

    }

    public void query(String id){

    }

    public void update(UserTask userTask){
        if(DBManager.getInstance() == null){
            return;
        }

        DBManager.getInstance().getUserTaskDao().update(userTask);
    }

    public void query(int status, final LQHandler.Consumer consumer){
        if(DBManager.getInstance() == null){
            return;
        }

        List<UserTask> userTaskList = DBManager.getInstance().getUserTaskDao().queryRaw(" where status = ?", status + "");
        consumer.applay(userTaskList);
    }

}
