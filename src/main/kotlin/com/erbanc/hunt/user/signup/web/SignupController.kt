package com.erbanc.hunt.user.signup.web

import com.erbanc.hunt.user.signup.bean.SignupRequestBean
import com.erbanc.hunt.user.signup.bean.SignupResultBean
import com.erbanc.hunt.user.signup.service.SignupService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/api/signup")
class SignupController(private val signupService: SignupService) {

    @PostMapping
    fun signup(@RequestBody signupRequestBean : SignupRequestBean): SignupResultBean = signupService.signup(signupRequestBean)
}