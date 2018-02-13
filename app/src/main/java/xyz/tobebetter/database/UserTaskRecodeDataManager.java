package xyz.tobebetter.database;

import java.util.Arrays;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
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

        Realm.getDefaultInstance().executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.insert(Arrays.asList(userTaskRecod));
            }
        });

    }

    public void query(Long userId, final LQHandler.Consumer consumer){
        RealmResults<UserTaskRecod> userTaskRecods = Realm.getDefaultInstance().where(UserTaskRecod.class).equalTo("userId",userId).findAllAsync();
        userTaskRecods.addChangeListener(new RealmChangeListener<RealmResults<UserTaskRecod>>() {
            @Override
            public void onChange(RealmResults<UserTaskRecod> userTaskRecods) {
                List<UserTaskRecod> userTaskRecodList = userTaskRecods.subList(0, userTaskRecods.size());
                consumer.applay(userTaskRecodList);
            }
        });
    }
}
