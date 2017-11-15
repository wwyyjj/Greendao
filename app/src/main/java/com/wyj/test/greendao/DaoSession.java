package com.wyj.test.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.wyj.test.greendao.User;
import com.wyj.test.greendao.ball;

import com.wyj.test.greendao.UserDao;
import com.wyj.test.greendao.ballDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig ballDaoConfig;

    private final UserDao userDao;
    private final ballDao ballDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        ballDaoConfig = daoConfigMap.get(ballDao.class).clone();
        ballDaoConfig.initIdentityScope(type);

        userDao = new UserDao(userDaoConfig, this);
        ballDao = new ballDao(ballDaoConfig, this);

        registerDao(User.class, userDao);
        registerDao(ball.class, ballDao);
    }
    
    public void clear() {
        userDaoConfig.clearIdentityScope();
        ballDaoConfig.clearIdentityScope();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public ballDao getBallDao() {
        return ballDao;
    }

}