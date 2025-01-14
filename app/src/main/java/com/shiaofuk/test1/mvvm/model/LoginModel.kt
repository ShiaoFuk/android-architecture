package com.shiaofuk.test1.mvvm.model

class LoginModel {

    fun login(username: String, password: String): Boolean {
        // 发起网络请求
        return username == "admin" && password == "123456"
    }
}