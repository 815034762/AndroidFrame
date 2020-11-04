package com.example.myapplication.ui.home.db;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.myapplication.JetPackApplication;
import com.example.myapplication.viewmodel.model.JokeModel;

@Database(entities = JokeModel.ResultBean.DataBean.class,version = 1,exportSchema = false)
public abstract class JokeDb extends RoomDatabase {
    private static final String DATA_DB_NAME ="JetPackDb";
    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();
    private static JokeDb mJokeDb;
    public abstract JokeDao getJokeDao();

    public static JokeDb getInstance() {
        if (mJokeDb==null){
            synchronized (JokeDb.class){
                if (mJokeDb==null){
                    JokeDb dataBasesTemp=buildDatabase(JetPackApplication.getmInstance());
                    dataBasesTemp.updateDatabaseCreated(JetPackApplication.getmInstance());
                    mJokeDb = dataBasesTemp;
                }
            }
        }
        return mJokeDb;
    }

    /**
     * Build the database. {@link Builder#build()} only sets up the database configuration and
     * creates a new instance of the database.
     * The SQLite database is only created when it's accessed for the first time.
     */
    private static JokeDb buildDatabase(final Context appContext) {
        return Room.databaseBuilder(appContext, JokeDb.class, DATA_DB_NAME)
                .fallbackToDestructiveMigration() // 升级异常时，重新创建数据库表, 数据丢失
//                .addMigrations(MIGRATION_1_2)
                .build();
    }

    /**
     * Check whether the database already exists and expose it via {@link #getDatabaseCreated()}
     */
    private void updateDatabaseCreated(final Context context) {
        if (context.getDatabasePath(DATA_DB_NAME).exists()) {
            setDatabaseCreated();
        }
    }

    public LiveData<Boolean> getDatabaseCreated() {
        return mIsDatabaseCreated;
    }

    private void setDatabaseCreated(){
        mIsDatabaseCreated.postValue(true);
    }

}
