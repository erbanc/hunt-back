package com.erbanc.hunt.stats.repository

import com.erbanc.hunt.stats.entity.UserStatsEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserStatsRepository : JpaRepository<UserStatsEntity, String>
