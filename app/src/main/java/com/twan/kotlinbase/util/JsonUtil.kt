package com.twan.kotlinbase.util

import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

object JsonUtil {
    private var gson: Gson = GsonBuilder().create()

    /**
     * 将对象转换成json格式
     *
     * @param ts
     * @return
     */
    fun objectToJson(ts: Any?): String? {
        return gson.toJson(ts)
    }

    /**
     * 将json格式转换成list对象
     *
     * @param jsonStr
     * @return
     */
    fun jsonToList(jsonStr: String?): List<*>? {
        var objList: List<*>? = null
        try {
            val type = object : TypeToken<List<*>>(){}.type
            objList = gson.fromJson(jsonStr, type)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return objList
    }

    /**
     * @param json
     * @param type
     * @return
     */
    fun json2List(json: String?, type: Type?): Any? {
        return gson.fromJson(json, type)
    }

    /**
     * 将json格式转换成map对象
     *
     * @param jsonStr
     * @return
     */
    fun jsonToMap(jsonStr: String?): Map<*, *>? {
        var objMap: Map<*, *>? = null
        try {
            try {
                val type = object : TypeToken<Map<*, *>>() {}.type
                objMap = gson.fromJson(jsonStr, type)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return objMap
    }

    /**
     * 将json转换成bean对象
     *
     * @param jsonStr
     * @return
     */
    fun <T> jsonToBean(jsonStr: String?, cl: Class<T>): T? {
        return gson.fromJson(jsonStr, cl)
    }

    /**
     * 根据
     *
     * @param jsonStr
     * @param key
     * @return
     */
    fun getJsonValue(jsonStr: String?, key: String?): Any? {
        var rulsObj: Any? = null
        val rulsMap = jsonToMap(jsonStr)
        if (rulsMap != null && rulsMap.size > 0) {
            rulsObj = rulsMap[key]
        }
        return rulsObj
    }

    /**
     * 将json字符串转为list
     *
     * @param s
     * @param clazz
     * @param <T>
     * @return
    </T> */
    fun <T> stringToArray(s: String, clazz: Class<Array<T>>): List<T>? {
        val arr: Array<T> = gson.fromJson(s, clazz)
        return listOf(*arr)  // * 表示先解包arr数组
    }


}