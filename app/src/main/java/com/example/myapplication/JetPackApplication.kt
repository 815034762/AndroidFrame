package com.example.myapplication;

import android.app.Application
import android.content.Context

class JetPackApplication : Application() {

    // 定义静态变量
    companion object {
        @JvmStatic
        lateinit var mInstance: JetPackApplication

        @JvmStatic
        fun test(context: Context) {
            print(" this is static method ")
//            if (context == null) {
//                // throw 会导致程序异常
//                throw NullPointerException("the context is null")
//            } else {
//                // 直接导致程序崩溃
//                throw IllegalArgumentException("不合法的参数")
//            }
        }

        @JvmStatic
        fun getmInstance(): JetPackApplication {
            return mInstance
        }
    }


    override fun onCreate() {
        super.onCreate()
        JetPackApplication.mInstance = this@JetPackApplication
        JetPackApplication.test(this@JetPackApplication);
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }

}
