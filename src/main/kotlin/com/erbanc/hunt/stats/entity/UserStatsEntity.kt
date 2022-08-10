package com.erbanc.hunt.stats.entity

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user_stats")
class UserStatsEntity (

    @Id var id: String
)