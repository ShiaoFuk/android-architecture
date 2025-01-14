package com.shiaofuk.test1.mvc

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.shiaofuk.test1.R
import com.shiaofuk.test1.databinding.ActivityMvcactivityBinding

class MVCActivity : AppCompatActivity() {

    private lateinit var b: ActivityMvcactivityBinding
    private lateinit var controller: MyController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        b = ActivityMvcactivityBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        controller = MyController()
        b.loginBtn.setOnClickListener {
            val username = b.username.text.toString()
            val password = b.password.text.toString()
            controller.login(username, password, this@MVCActivity)
        }
    }

    fun loginSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show()
    }

    fun loginFail() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show()
    }


}

