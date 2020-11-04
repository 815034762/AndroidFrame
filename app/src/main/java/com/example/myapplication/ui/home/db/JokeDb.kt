package com.example.myapplication.ui.home.db

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.JetPackApplication.Companion.getmInstance
import com.example.myapplication.viewmodel.model.JokeModel

@Database(entities = [JokeModel.ResultBean.DataBean::class], version = 1, exportSchema = false)
abstract class JokeDb : RoomDatabase() {
    private val mIsDatabaseCreated = MutableLiveData<Boolean>()
    abstract val jokeDao: JokeDao?

    /**
     * Check whether the database already exists and expose it via [.getDatabaseCreated]
     */
    private fun updateDatabaseCreated(context: Context) {
        if (context.getDatabasePath(DATA_DB_NAME).exists()) {
            setDatabaseCreated()
        }
    }

    val databaseCreated: LiveData<Boolean>
        get() = mIsDatabaseCreated

    private fun setDatabaseCreated() {
        mIsDatabaseCreated.postValue(true)
    }

    companion object {
        private const val DATA_DB_NAME = "JetPackDb"
        private lateinit var mJokeDb: JokeDb
        val instance: JokeDb
            get() {
                if (mJokeDb == null) {
                    synchronized(JokeDb::class.java) {
                        if (mJokeDb == null) {
                            val dataBasesTemp = buildDatabase(getmInstance())
                            dataBasesTemp.updateDatabaseCreated(getmInstance())
                            mJokeDb = dataBasesTemp
                        }
                    }
                }
                return mJokeDb
            }

        /**
         * Build the database. [Builder.build] only sets up the database configuration and
         * creates a new instance of the database.
         * The SQLite database is only created when it's accessed for the first time.
         */
        private fun buildDatabase(appContext: Context): JokeDb {
            return Room.databaseBuilder(appContext, JokeDb::class.java, DATA_DB_NAME)
                    .fallbackToDestructiveMigration() // 升级异常时，重新创建数据库表, 数据丢失
                    //                .addMigrations(MIGRATION_1_2)
                    .build()
        }
    }
}