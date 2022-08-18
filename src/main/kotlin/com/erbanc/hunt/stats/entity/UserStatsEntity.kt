package com.erbanc.hunt.stats.entity

import javax.persistence.*

@Entity
@Table(name = "user_stats")
class UserStatsEntity (

    @Id @Column(name="username") var username: String,

    @Column(name = "total_bad_guesses", nullable = false) var totalBadGuesses: Long = 0,

    @Column(name = "total_guesses", nullable = false) var totalGuesses: Long = 0
)