package com.shiaofuk.test1.mvp.model

class LoginModel {


    fun login(username: String ,password: String): Boolean {
        // 发起网络请求
        return username == "admin" && password == "123456"
    }
}