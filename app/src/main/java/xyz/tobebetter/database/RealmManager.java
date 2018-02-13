package xyz.tobebetter.database;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by zhuleqi on 2018/2/12.
 */
public class RealmManager {
    private  static  final  String REALM_NAME = "tebebetter.m";
    private static final long version  = 1L;

    private static RealmManager realmManager;

    private RealmManager() {

    }

    public static RealmManager getInstance() {
        if(realmManager == null){
            realmManager = new RealmManager();
        }
        return realmManager;
    }

    public void initRealm(Context context) {
        Realm.init(context);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().name(REALM_NAME).schemaVersion(version).build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

}
