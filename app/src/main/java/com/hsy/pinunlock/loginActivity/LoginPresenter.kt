package com.hsy.pinunlock.loginActivity

import android.app.Activity
import android.content.Intent
import com.hsy.pinunlock.loginSuccessActivity.LoginSuccessActivity

class LoginPresenter(val view: ILoginView, val model: UserModel) {
    // 因为 model的 pwd是可选类型，则可以根据 pwd是否为 null来判断用户是不是第一次登录，如果是，则改变提示信息，并设置密码
    // 设置密码时，确认按钮默认时不可见，当设置密码长度达到 6位时，确认按键设置为可见，并给确认按键添加监听事件

    // 进入主界面
    fun start() {
        if (model.pwd == null) {
            view.setTipText("请设置 6 位密码")
        } else {
            view.setTipText("请输入密码")
        }
    }

    fun setPwd(inputPwd: String) {
        if (inputPwd.length == 6) {
            view.setBtnVisible()
        }
    }

    fun confirmPwd(inputPwd: String) {
        model.pwd = inputPwd
        view.clearNumberText()
    }

    // 根据用户输入的密码(inputPwd)和 model的密码比对
    fun checkPwd(inputPwd: String) {
        if (inputPwd == model.pwd)
            loginSuccess()
        else
            loginFailed()
    }

    // 密码正确则跳转到 LoginSuccessActivity
    fun loginSuccess() {
        (view as Activity).startActivity(Intent(view, LoginSuccessActivity::class.java))
    }

    // 密码错误则用ILoginView接口中的 setTipText方法显示提示信息，并清空 numberText输入框
    fun loginFailed() {
        view.setTipText("密码错误,请重新输入")
    }
}