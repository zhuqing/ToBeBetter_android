package xyz.tobebetter.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import xyz.tobebetter.entity.UserTask;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER_TASK".
*/
public class UserTaskDao extends AbstractDao<UserTask, String> {

    public static final String TABLENAME = "USER_TASK";

    /**
     * Properties of entity UserTask.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, String.class, "id", true, "ID");
        public final static Property CreateDate = new Property(1, Long.class, "createDate", false, "CREATE_DATE");
        public final static Property UpdateDate = new Property(2, Long.class, "updateDate", false, "UPDATE_DATE");
        public final static Property Status = new Property(3, Integer.class, "status", false, "STATUS");
        public final static Property Title = new Property(4, String.class, "title", false, "TITLE");
        public final static Property Seconds = new Property(5, Integer.class, "seconds", false, "SECONDS");
        public final static Property UserId = new Property(6, Long.class, "userId", false, "USER_ID");
    };


    public UserTaskDao(DaoConfig config) {
        super(config);
    }
    
    public UserTaskDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER_TASK\" (" + //
                "\"ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: id
                "\"CREATE_DATE\" INTEGER," + // 1: createDate
                "\"UPDATE_DATE\" INTEGER," + // 2: updateDate
                "\"STATUS\" INTEGER," + // 3: status
                "\"TITLE\" TEXT," + // 4: title
                "\"SECONDS\" INTEGER," + // 5: seconds
                "\"USER_ID\" INTEGER);"); // 6: userId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER_TASK\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, UserTask entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        Long createDate = entity.getCreateDate();
        if (createDate != null) {
            stmt.bindLong(2, createDate);
        }
 
        Long updateDate = entity.getUpdateDate();
        if (updateDate != null) {
            stmt.bindLong(3, updateDate);
        }
 
        Integer status = entity.getStatus();
        if (status != null) {
            stmt.bindLong(4, status);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(5, title);
        }
 
        Integer seconds = entity.getSeconds();
        if (seconds != null) {
            stmt.bindLong(6, seconds);
        }
 
        Long userId = entity.getUserId();
        if (userId != null) {
            stmt.bindLong(7, userId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, UserTask entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        Long createDate = entity.getCreateDate();
        if (createDate != null) {
            stmt.bindLong(2, createDate);
        }
 
        Long updateDate = entity.getUpdateDate();
        if (updateDate != null) {
            stmt.bindLong(3, updateDate);
        }
 
        Integer status = entity.getStatus();
        if (status != null) {
            stmt.bindLong(4, status);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(5, title);
        }
 
        Integer seconds = entity.getSeconds();
        if (seconds != null) {
            stmt.bindLong(6, seconds);
        }
 
        Long userId = entity.getUserId();
        if (userId != null) {
            stmt.bindLong(7, userId);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public UserTask readEntity(Cursor cursor, int offset) {
        UserTask entity = new UserTask( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // createDate
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // updateDate
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // status
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // title
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // seconds
            cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6) // userId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, UserTask entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setCreateDate(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setUpdateDate(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setStatus(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setTitle(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setSeconds(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setUserId(cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6));
     }
    
    @Override
    protected final String updateKeyAfterInsert(UserTask entity, long rowId) {
        return entity.getId();
    }
    
    @Override
    public String getKey(UserTask entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}