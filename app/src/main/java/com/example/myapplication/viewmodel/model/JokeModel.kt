package com.example.myapplication.viewmodel.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

/**
 * @author ly-zhangty
 * 笑话大全的实体类
 */
class JokeModel : Serializable {
    var reason: String? = null
    var result: ResultBean? = null
    var error_code = 0
    class ResultBean {
        var data: List<DataBean>? = null
        @Entity(tableName = "JokeModel")
        class DataBean {
            @PrimaryKey(autoGenerate = true)
            var id = 0
            var content: String? = null
            var hashId: String? = null
            var unixtime = 0
            var updatetime: String? = null
        }
    }
}