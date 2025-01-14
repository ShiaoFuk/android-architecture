package com.shiaofuk.test1.mvp

import com.shiaofuk.test1.mvp.model.LoginModel


class MyPresenter(activity: MVPActivity) {

    val LoginModel = LoginModel()
    val view = activity
    fun login(username: String, password: String) {
        // presenter作为model和view的桥梁，转发两者的交互，逻辑都在把view和LoginModel解耦了
        if (LoginModel.login(username, password)) {
            // 登录成功
            view.loginSuccess()
        } else {
            // 登录失败
            view.loginFail()
        }
    }
}