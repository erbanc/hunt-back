package com.erbanc.hunt.user.login.service

import com.erbanc.hunt.user.login.bean.LoginBean
import com.erbanc.hunt.user.login.bean.LoginResultBean

interface LoginService {

    fun validateLogin(loginBean: LoginBean): LoginResultBean
}