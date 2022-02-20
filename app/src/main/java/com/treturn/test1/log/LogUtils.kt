package com.treturn.test1.log

import com.orhanobut.logger.Logger
import com.treturn.test1.BuildConfig

/**
 * @CreateDate : 2021/8/25 21:29
 * @Author : 青柠
 * @Description : Logger日志打印
 */
object LogUtils {
    fun d(log: Any) {
        if (BuildConfig.DEBUG) {
            Logger.d(log)
        }
    }
}