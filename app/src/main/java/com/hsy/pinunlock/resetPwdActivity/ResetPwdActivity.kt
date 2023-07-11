package com.hsy.pinunlock.resetPwdActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hsy.pinunlock.databinding.ActivityResetPwdBinding

class ResetPwdActivity : AppCompatActivity(), IResetView {
    lateinit var resetPresenter: ResetPresenter
    lateinit var binding: ActivityResetPwdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 添加视图绑定 todo
        binding = ActivityResetPwdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        resetPresenter = ResetPresenter(this, QuestionModel())
        resetPresenter.setQuestion()
        binding.button.setOnClickListener {
            resetPresenter.checkAnswer(binding.answerText.text.toString())
        }
    }

    override fun setQuestionText(text: String) {
        binding.questionText.text = text
    }

}