package com.erbanc.hunt.question.bean

import com.erbanc.hunt.question.entity.QuestionEntity
import java.util.*

class QuestionBean(
    var id: Long,
    var name: String,
    var text: String,
    var answer: String,
    var html: String
) {
    fun toEntity(): QuestionEntity = QuestionEntity(name = name, text = text, answer = answer, html = html)
}
