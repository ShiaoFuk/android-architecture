package com.shiaofuk.test1.mvvm

import android.view.View
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.shiaofuk.test1.mvvm.model.LoginModel

class MyViewModel {
    val username = ObservableField<String>("")
    val password = ObservableField<String>("")
    val result = ObservableField<String>("")
    private val model = LoginModel()

    fun login(v: View) {
        // 不需要持有view，由databinding框架自动处理viewmodel和view的交互，开发者只需要关注model的业务处理来修改
        // viewmodel的字段，而不需要手动对view进行操作
        if (model.login(username.get()!!, password.get()!!)) {
            // 登录成功
            Toast.makeText(v.context, "登录成功", Toast.LENGTH_SHORT).show()
            result.set("登录成功")
        } else {
            // 登录失败
            Toast.makeText(v.context, "登录失败", Toast.LENGTH_SHORT).show()
            result.set("登录失败")
        }
    }
}



class MyNewViewModel {

}