package com.hsy.pinunlock.loginActivity

class LoginPresenter(val view: ILoginView, val model: UserModel) {
    // 因为 model的 pwd是可选类型，则可以根据 pwd是否为 null来判断用户是不是第一次登录，如果是，则改变提示信息，并设置密码
    // 设置密码时，确认按钮默认时不可见，当设置密码长度达到 6位时，确认按键设置为可见，并给确认按键添加监听事件
    fun setPwd() {
        // 判断是否是第一次登录的逻辑应该写在这里，而不是在 activity里
        TODO()
    }

    // 根据用户输入的密码(inputPwd)和 model的密码比对
    fun checkPwd(inputPwd: String) {
        TODO()
    }

    // 密码正确则跳转到 LoginSuccessActivity
    fun loginSuccess() {
        TODO()
    }

    // 密码错误则用ILoginView接口中的 setTipText方法显示提示信息，并清空 numberText输入框
    fun loginFailed() {
        TODO()
    }
}