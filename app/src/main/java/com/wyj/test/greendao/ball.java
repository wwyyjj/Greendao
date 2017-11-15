package com.wyj.test.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by wangyajie on 2017/11/15.
 */
@Entity
public class ball {
    @Id
    long id;
    private String balltype;
    @Generated(hash = 1540063218)
    public ball(long id, String balltype) {
        this.id = id;
        this.balltype = balltype;
    }
    @Generated(hash = 1554844747)
    public ball() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getBalltype() {
        return this.balltype;
    }
    public void setBalltype(String balltype) {
        this.balltype = balltype;
    }
}
