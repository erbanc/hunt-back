package com.erbanc.hunt.user.service

import com.erbanc.hunt.user.bean.UserBean

interface UserService {

    fun getUser(username: String): UserBean
}