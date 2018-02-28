package xyz.tobebetter.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import xyz.tobebetter.entity.User;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER".
*/
public class UserDao extends AbstractDao<User, String> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, String.class, "id", true, "ID");
        public final static Property CreateDate = new Property(1, Long.class, "createDate", false, "CREATE_DATE");
        public final static Property UpdateDate = new Property(2, Long.class, "updateDate", false, "UPDATE_DATE");
        public final static Property Status = new Property(3, Integer.class, "status", false, "STATUS");
        public final static Property Name = new Property(4, String.class, "name", false, "NAME");
        public final static Property Password = new Property(5, String.class, "password", false, "PASSWORD");
        public final static Property Email = new Property(6, String.class, "email", false, "EMAIL");
        public final static Property Phonenumber = new Property(7, String.class, "phonenumber", false, "PHONENUMBER");
        public final static Property OthersysId = new Property(8, String.class, "othersysId", false, "OTHERSYS_ID");
    };


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER\" (" + //
                "\"ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: id
                "\"CREATE_DATE\" INTEGER," + // 1: createDate
                "\"UPDATE_DATE\" INTEGER," + // 2: updateDate
                "\"STATUS\" INTEGER," + // 3: status
                "\"NAME\" TEXT," + // 4: name
                "\"PASSWORD\" TEXT," + // 5: password
                "\"EMAIL\" TEXT," + // 6: email
                "\"PHONENUMBER\" TEXT," + // 7: phonenumber
                "\"OTHERSYS_ID\" TEXT);"); // 8: othersysId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, User entity) {
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
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(5, name);
        }
 
        String password = entity.getPassword();
        if (password != null) {
            stmt.bindString(6, password);
        }
 
        String email = entity.getEmail();
        if (email != null) {
            stmt.bindString(7, email);
        }
 
        String phonenumber = entity.getPhonenumber();
        if (phonenumber != null) {
            stmt.bindString(8, phonenumber);
        }
 
        String othersysId = entity.getOthersysId();
        if (othersysId != null) {
            stmt.bindString(9, othersysId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, User entity) {
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
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(5, name);
        }
 
        String password = entity.getPassword();
        if (password != null) {
            stmt.bindString(6, password);
        }
 
        String email = entity.getEmail();
        if (email != null) {
            stmt.bindString(7, email);
        }
 
        String phonenumber = entity.getPhonenumber();
        if (phonenumber != null) {
            stmt.bindString(8, phonenumber);
        }
 
        String othersysId = entity.getOthersysId();
        if (othersysId != null) {
            stmt.bindString(9, othersysId);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // createDate
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // updateDate
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // status
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // name
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // password
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // email
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // phonenumber
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8) // othersysId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setCreateDate(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setUpdateDate(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setStatus(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setName(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setPassword(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setEmail(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setPhonenumber(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setOthersysId(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
     }
    
    @Override
    protected final String updateKeyAfterInsert(User entity, long rowId) {
        return entity.getId();
    }
    
    @Override
    public String getKey(User entity) {
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
