package com.erbanc.hunt.user.repository

import com.erbanc.hunt.user.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface UserRepository : JpaRepository<UserEntity, String> {

    @Transactional
    @Modifying
    @Query("update UserEntity u set u.questionReached = ?1 where u.username = ?2")
    fun setQuestionReached(questionReached: Long, username: String)

    @Query("select (count(u) > 0) from UserEntity u where u.username = ?1 and u.questionReached >= ?2")
    fun isQuestionAccessibleByUser(username: String, questionReached: Long): Boolean

    @Query("SELECT entity FROM UserEntity entity WHERE entity.username = :username AND entity.password = :password")
    fun getByLogin(@Param("username") username: String, @Param("password") password: String): List<UserEntity>
}
