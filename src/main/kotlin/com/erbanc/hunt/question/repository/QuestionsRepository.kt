package com.erbanc.hunt.question.repository

import com.erbanc.hunt.question.entity.QuestionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface QuestionsRepository : JpaRepository<QuestionEntity, Long> {

    @Query("select (count(u) > 0) from QuestionEntity u where u.id = ?1 and u.answer = ?2")
    fun tryAnswer(id: Long, answer: String): Boolean
}