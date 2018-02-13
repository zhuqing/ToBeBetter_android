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
        Realm.getDefaultInstance().executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.insert(userTaskList);
            }
        });

    }

    public void query(String id){

    }

    public void update(UserTask userTask){
        Realm.getDefaultInstance().insert(Arrays.asList(userTask));
    }

    public void query(int status, final LQHandler.Consumer consumer){
        RealmResults<UserTask> realmResults = Realm.getDefaultInstance().where(UserTask.class).equalTo("status",status).findAllAsync();
        realmResults.addChangeListener(new RealmChangeListener<RealmResults<UserTask>>() {
            @Override
            public void onChange(RealmResults<UserTask> userTasks) {
                consumer.applay(userTasks.subList(0, userTasks.size()));
            }
        });
    }

}
