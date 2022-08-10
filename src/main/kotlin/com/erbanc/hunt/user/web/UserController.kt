package com.erbanc.hunt.user.web

import com.erbanc.hunt.user.bean.UserBean
import com.erbanc.hunt.user.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @GetMapping("/{username}")
    fun getUser(@PathVariable username: String): UserBean = userService.getUser(username)
}