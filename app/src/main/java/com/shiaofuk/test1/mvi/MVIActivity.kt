package com.shiaofuk.test1.mvi

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.shiaofuk.test1.R
import com.shiaofuk.test1.databinding.ActivityMvcactivityBinding
import com.shiaofuk.test1.mvi.MyViewModel

class MVIActivity : AppCompatActivity() {

    private lateinit var b: ActivityMvcactivityBinding

    private val _myViewModel = MyViewModel()


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

        _myViewModel.loginState.observe(this) {
            render(it)
        }
        b.username.addTextChangedListener { text -> _myViewModel.processIntent(MyIntent.UsernameChanged(text.toString())) }
        b.password.addTextChangedListener { text -> _myViewModel.processIntent(MyIntent.PasswordChanged(text.toString())) }
        b.loginBtn.setOnClickListener { _myViewModel.processIntent(MyIntent.Login) }
    }


    fun render(state: LoginState) {
        if (b.loginBtn.isEnabled == state.loading) {
            b.loginBtn.isEnabled = !state.loading
        }
        b.username.setText(state.username)
        b.password.setText(state.password)
        state.error?.let { Toast.makeText(this, state.error, Toast.LENGTH_SHORT).show() }
    }


}

