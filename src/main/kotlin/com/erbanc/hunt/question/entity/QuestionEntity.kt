package com.erbanc.hunt.question.entity

import com.erbanc.hunt.question.bean.QuestionBean
import javax.persistence.*

@Entity
@Table(name = "question")
class QuestionEntity(
    @Column(nullable = false, unique = true) val name: String,
    @Column(nullable = false) val answer: String,
    @Column(nullable = true) val html: String = "",
    @Column(nullable = true) val text: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    fun toBean(): QuestionBean = QuestionBean(id = id, text = text, html = html, name = name, answer = "bien tenté")
}

