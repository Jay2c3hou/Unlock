package com.hsy.pinunlock.loginActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.hsy.pinunlock.databinding.ActivityLoginBinding
import com.hsy.pinunlock.resetPwdActivity.ResetPwdActivity

class LoginActivity : AppCompatActivity(), ILoginView {
    lateinit var binding: ActivityLoginBinding

    // loginPresenter todo
    private lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // 给 forgetPwdText添加点击事件，使得点击之后跳转到 resetPwdActivity todo
        binding.forgetPwdText.setOnClickListener {
            startActivity(Intent(this, ResetPwdActivity::class.java))
        }
        loginPresenter = LoginPresenter(this, UserModel())
        // 给 numberText添加 TextListener接口来监听 text值的改变 todo 去网上学这个接口怎么用
        binding.numberText.addTextChangedListener {
            loginPresenter.checkPwd((it as EditText).text.toString())
        }
    }

    //设置提示文本 todo
    override fun setTipText(text: String) {
        binding.tipText.text = text
    }
}