package com.hsy.pinunlock.resetPwdActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.hsy.pinunlock.R
import com.hsy.pinunlock.databinding.ActivityLoginBinding
import com.hsy.pinunlock.databinding.ActivityResetPwdBinding

class ResetPwdActivity : AppCompatActivity() ,IResetView{
    lateinit var resetPresenter: ResetPresenter
    lateinit var binding :ActivityResetPwdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 添加视图绑定 todo
        binding = ActivityResetPwdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var answerText = binding.answerText
        resetPresenter.setQuestion()
        binding.button.setOnClickListener(){
            resetPresenter.checkAnswer((it as EditText).text.toString())
        }

    }

    override fun setQuestionText(text: String) {
        binding.questionText.text = text
    }

}