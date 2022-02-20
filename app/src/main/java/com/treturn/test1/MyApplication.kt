package com.treturn.test1

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

/**
 * @CreateDate : 2021/8/25 21:42
 * @Author : 青柠
 * @Description :
 */
class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        //日志打印初始化
        Logger.addLogAdapter(AndroidLogAdapter())
    }
}