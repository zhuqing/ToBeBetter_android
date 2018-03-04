package xyz.tobebetter.database;


import java.util.List;

import xyz.tobebetter.entity.UserTaskRecord;
import xyz.tobebetter.sf.LQService;
import xyz.tobebetter.util.LQHandler;
import xyz.tobebetter.util.UrlConfigUtil;

/**
 * Created by zhuleqi on 2018/2/12.
 */
public class UserTaskRecordDataManager {

    private static UserTaskRecordDataManager userTaskRecodeDataManager;

    private String createUrl;

    private UserTaskRecordDataManager() {

    }

    public static UserTaskRecordDataManager getInstance() {
        if (userTaskRecodeDataManager == null) {
            userTaskRecodeDataManager = new UserTaskRecordDataManager();
        }
        return userTaskRecodeDataManager;
    }

    public void insert(final UserTaskRecord userTaskRecod) {

        if (DBManager.getInstance() == null) {
            return;
        }
        DBManager.getInstance().getDaoSession().runInTx(new Runnable() {
            @Override
            public void run() {
                if (LQService.isNetworkConnected(DBManager.context)) {
                    LQService.post(getCreateUrl(), UserTaskRecord.class, userTaskRecod, null, new LQHandler.Consumer<UserTaskRecord>() {
                        @Override
                        public void applay(UserTaskRecord userTaskRecod1) {
                            if (userTaskRecod1 != null) {
                                DBManager.getInstance().getUserTaskRecordDao().insert(userTaskRecod1);
                            }else{
                                DBManager.getInstance().getUserTaskRecordDao().insert(userTaskRecod);
                            }

                        }
                    });
                } else {
                    DBManager.getInstance().getUserTaskRecordDao().insert(userTaskRecod);
                }

            }
        });


    }



    public String getCreateUrl() {
        if (this.createUrl == null) {
            StringBuilder stringBuilder = new StringBuilder();
            UrlConfigUtil urlConfigUtil = UrlConfigUtil.getInstance();
            stringBuilder.append(urlConfigUtil.get("HOST")).append(urlConfigUtil.get("USER_TASK_RECORD_CREATE"));
            createUrl = stringBuilder.toString();
        }

        return this.createUrl;
    }

    public void query(String userId, final LQHandler.Consumer consumer) {
        if (DBManager.getInstance() == null) {
            return;
        }

        List<UserTaskRecord> userTaskList = DBManager.getInstance().getUserTaskRecordDao().queryRaw("where user_Id = ?", userId + "");
        consumer.applay(userTaskList);
    }
}
