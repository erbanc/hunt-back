package com.erbanc.hunt.user.entity

import com.erbanc.hunt.stats.entity.UserStatsEntity
import javax.persistence.*

@Entity
@Table(name = "app_user")
class UserEntity(
    @Id @Column(nullable = false, unique = true) val username: String,
    @Column(nullable = false, unique = true) val email: String,
    @Column(nullable = false, unique = true) val password: String,
    @Column(name = "question_reached") val questionReached: Long = 1
)