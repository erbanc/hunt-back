package com.erbanc.hunt.user.signup.service

import com.erbanc.hunt.user.bean.UserBean
import com.erbanc.hunt.user.repository.UserRepository
import com.erbanc.hunt.user.service.UserService
import com.erbanc.hunt.user.signup.bean.SignupRequestBean
import com.erbanc.hunt.user.signup.bean.SignupResultBean
import org.springframework.stereotype.Service

@Service
class SignupServiceImpl(private val userRepository: UserRepository, private val userService: UserService) :
    SignupService {

    override fun signup(signupRequestBean: SignupRequestBean): SignupResultBean {

        return if (userRepository.existsById(signupRequestBean.username)) {
            SignupResultBean(signedUp = false, errorDescription = "Le nom d'utilisateur est déjà pris")
        } else {
            userService.addUser(
                UserBean(username = signupRequestBean.username, email = signupRequestBean.email),
                signupRequestBean.password
            )

            SignupResultBean(signedUp = true, errorDescription = null)
        }
    }
}