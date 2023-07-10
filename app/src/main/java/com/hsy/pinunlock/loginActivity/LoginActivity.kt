package com.hsy.pinunlock.loginActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hsy.pinunlock.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), ILoginView {
    lateinit var binding: ActivityLoginBinding
    // loginPresenter todo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // 给 forgetPwdText添加点击事件，使得点击之后跳转到 resetPwdActivity todo

    }

    override fun setTipText(text: String) {
        TODO("Not yet implemented")
    }

    // 给 numberText添加 TextWatcher接口来监听 text值的改变 todo 去网上学这个接口怎么用

}