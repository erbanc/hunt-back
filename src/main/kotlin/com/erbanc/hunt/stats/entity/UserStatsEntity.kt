package com.erbanc.hunt.stats.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user_stats")
class UserStatsEntity (

    @Id var id: Long,

    @Column(name="id_user") var idUser: Long,

    @Column(name = "total_bad_guesses") var totalBadGuesses: Long,

    @Column(name = "total_guesses") var totalGuesses: Long
)