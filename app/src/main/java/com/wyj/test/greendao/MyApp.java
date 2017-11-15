package com.wyj.test.greendao;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

/**
 * Created by wangyajie on 2017/11/15.
 */

public class MyApp extends Application {
    public static final boolean ENCRYPTED = true;

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
