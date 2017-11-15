package com.wyj.test.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private UserDao userDao;
    int i = 0;
    private TextView id;
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        // do this once, for example in your Application class
        DaoSession daoSession = ((MyApp) getApplication()).getDaoSession();
        // do this in your activities/fragments to get hold of a DAO
        userDao = daoSession.getUserDao();
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                //增
                User user = new User(null, "123" + i);
                userDao.insert(user);
            }
        });
        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //删
                userDao.deleteByKey((long) i);
            }
        });
        findViewById(R.id.updata).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //改
                User mUser = new User((long) 2, "anye0803");
                userDao.update(mUser);
            }
        });
        findViewById(R.id.select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //查
                List<User> users = userDao.loadAll();
                String userName = "";
                for (int i = 0; i < users.size(); i++) {
                    userName += users.get(i).getName() + ",";
                }
                tv.setText("全部数据"+userName);
            }
        });

    }
}
