package com.hsy.pinunlock.resetPwdActivity

import android.app.Activity
import android.content.Intent
import com.hsy.pinunlock.loginActivity.LoginActivity
import java.util.Timer
import kotlin.concurrent.schedule
import kotlin.random.Random

class ResetPresenter(
    val view: IResetView,
    val model: QuestionModel,
) {
    var randomIndex = -1
    var keyList = model.resetMap.keys.toList()

    fun setQuestion() {
        randomIndex = Random(System.nanoTime()).nextInt(keyList.size)
        view.setQuestionText(keyList[randomIndex])
    }

    fun checkAnswer(answer: String) {
        if (answer == model.resetMap[keyList[randomIndex]]) {
            view.setQuestionText("回答正确")
            (view as Activity).startActivity(Intent(view, LoginActivity::class.java))
        } else {
            view.setQuestionText("回答错误\n程序即将退出")
            Timer().schedule(1000) {
                android.os.Process.killProcess(android.os.Process.myPid())
            }
        }
    }
}