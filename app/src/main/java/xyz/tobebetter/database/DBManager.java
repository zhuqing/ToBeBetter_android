package xyz.tobebetter.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


import xyz.tobebetter.greendao.gen.DaoMaster;
import xyz.tobebetter.greendao.gen.DaoSession;
import xyz.tobebetter.greendao.gen.UserTaskDao;

import xyz.tobebetter.greendao.gen.UserTaskRecordDao;

/**
 * Created by zhuleqi on 2018/2/26.
 */
public class DBManager {
    private DaoMaster daoMaster;
    private SQLiteDatabase db;

    private DaoSession daoSession;

    private UserTaskDao userTaskDao;

    private UserTaskRecordDao userTaskRecordDao;

    private  static DBManager dbManager;

    public static DBManager create(Context context){
        dbManager = new DBManager(context);
        return dbManager;
    }

    public static DBManager getInstance(){
        return  dbManager;
    }

    private DBManager(Context context){
        init(context);
    }

    private   void init(Context context){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "tobebetter-db", null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        setDaoSession(daoMaster.newSession());
        userTaskDao = getDaoSession().getUserTaskDao();
        this.userTaskRecordDao = getDaoSession().getUserTaskRecordDao();

    }


    public UserTaskRecordDao getUserTaskRecordDao() {
        return userTaskRecordDao;
    }


    public UserTaskDao getUserTaskDao() {
        return userTaskDao;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public void setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
    }
}
