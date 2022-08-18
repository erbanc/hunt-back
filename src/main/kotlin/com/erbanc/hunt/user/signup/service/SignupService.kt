package com.erbanc.hunt.user.signup.service

import com.erbanc.hunt.user.signup.bean.SignupRequestBean
import com.erbanc.hunt.user.signup.bean.SignupResultBean

interface SignupService {

    /**
     * Request a sign-up with details provided in [signupRequestBean]
     */
    fun signup(signupRequestBean: SignupRequestBean): SignupResultBean
}