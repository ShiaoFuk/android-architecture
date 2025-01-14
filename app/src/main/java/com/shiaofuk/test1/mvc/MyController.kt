package com.shiaofuk.test1.mvc

import com.shiaofuk.test1.mvc.model.LoginModel

class MyController() {

    private val loginModel = LoginModel()


    fun login(username: String, password: String, view: MVCActivity) {
        // view变化，通知model，由model处理业务逻辑，处理完毕后由model通知view，controller只用于把view和model连
        // 接起来
        loginModel.login(username, password, view)
    }

}