package com.shiaofuk.test1.mvc.model

import com.shiaofuk.test1.mvc.MVCActivity

class LoginModel() {
    fun login(username: String, password: String, view: MVCActivity) {
        // 发起网络请求
        if (username == "admin" && password == "123456") {
            view.loginSuccess()
        } else {
            view.loginFail()
        }
    }
}