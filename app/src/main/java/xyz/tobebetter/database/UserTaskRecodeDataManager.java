package xyz.tobebetter.database;

import java.util.Arrays;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import xyz.tobebetter.entity.UserTask;
import xyz.tobebetter.entity.UserTaskRecod;
import xyz.tobebetter.util.LQHandler;

/**
 * Created by zhuleqi on 2018/2/12.
 */
public class UserTaskRecodeDataManager {

    private static UserTaskRecodeDataManager userTaskRecodeDataManager;

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
        DBManager.getInstance().getUserTaskRecodDao().insert(userTaskRecod);

    }

    public void query(Long userId, final LQHandler.Consumer consumer){
        if(DBManager.getInstance() == null){
            return;
        }

        List<UserTaskRecod> userTaskList = DBManager.getInstance().getUserTaskRecodDao().queryRaw("where user_Id = ?", userId + "");
        consumer.applay(userTaskList);
    }
}
