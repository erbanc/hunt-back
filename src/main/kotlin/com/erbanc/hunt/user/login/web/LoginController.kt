package com.erbanc.hunt.user.login.web

import com.erbanc.hunt.user.login.bean.LoginBean
import com.erbanc.hunt.user.login.bean.LoginResultBean
import com.erbanc.hunt.user.login.service.LoginService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/login")
class LoginController(private val loginService: LoginService) {

    @PostMapping
    fun login(@RequestBody loginBean: LoginBean): LoginResultBean = loginService.validateLogin(loginBean)
}