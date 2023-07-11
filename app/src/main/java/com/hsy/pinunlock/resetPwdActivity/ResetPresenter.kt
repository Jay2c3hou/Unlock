package com.hsy.pinunlock.resetPwdActivity

import java.util.Timer
import kotlin.concurrent.schedule
import kotlin.random.Random

class ResetPresenter(
    val view: IResetView,
    val model: QuestionModel,
) {
    var randomIndex = -1
    var keyList = model.resetMap.toList()

    fun setQuestion() {
        randomIndex = Random(System.nanoTime()).nextInt(keyList.size)
        view.setQuestionText(keyList[randomIndex].toString())
    }

    fun checkAnswer(answer: String) {
        if (answer == model.resetMap[keyList[randomIndex].toString()]) {
            view.setQuestionText("回答正确")
            TODO("密码的值")
        }else{
            view.setQuestionText("回答错误")
            Timer().schedule(3000) {
                android.os.Process.killProcess(android.os.Process.myPid())
            }
        }
    }
}