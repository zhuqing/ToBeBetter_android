package xyz.tobebetter.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


import xyz.tobebetter.greendao.gen.DaoMaster;
import xyz.tobebetter.greendao.gen.DaoSession;
import xyz.tobebetter.greendao.gen.UserTaskDao;
import xyz.tobebetter.greendao.gen.UserTaskRecodDao;

/**
 * Created by zhuleqi on 2018/2/26.
 */
public class DBManager {
    private DaoMaster daoMaster;
    private SQLiteDatabase db;

    private DaoSession daoSession;

    private UserTaskDao userTaskDao;

    private UserTaskRecodDao userTaskRecodDao;

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
        this.userTaskRecodDao = getDaoSession().getUserTaskRecodDao();

    }


    public UserTaskRecodDao getUserTaskRecodDao() {
        return userTaskRecodDao;
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
