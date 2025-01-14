package com.shiaofuk.test1.mvvm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.shiaofuk.test1.R
import com.shiaofuk.test1.databinding.ActivityMvvmactivityBinding

class MVVMActivity : AppCompatActivity() {

    lateinit var b: ActivityMvvmactivityBinding
    val mViewModel = MyViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        b = DataBindingUtil.inflate<ActivityMvvmactivityBinding>(layoutInflater, R.layout.activity_mvvmactivity, null, false).apply {
            setContentView(root)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        b.viewModel = mViewModel
    }
}