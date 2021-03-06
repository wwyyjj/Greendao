package com.wyj.test.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "BALL".
*/
public class ballDao extends AbstractDao<ball, Long> {

    public static final String TABLENAME = "BALL";

    /**
     * Properties of entity ball.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property Balltype = new Property(1, String.class, "balltype", false, "BALLTYPE");
    }


    public ballDao(DaoConfig config) {
        super(config);
    }
    
    public ballDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"BALL\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "\"BALLTYPE\" TEXT);"); // 1: balltype
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"BALL\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ball entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String balltype = entity.getBalltype();
        if (balltype != null) {
            stmt.bindString(2, balltype);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ball entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String balltype = entity.getBalltype();
        if (balltype != null) {
            stmt.bindString(2, balltype);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public ball readEntity(Cursor cursor, int offset) {
        ball entity = new ball( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // balltype
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ball entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setBalltype(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(ball entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(ball entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(ball entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
