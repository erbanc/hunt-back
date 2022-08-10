package com.erbanc.hunt.question.service

import com.erbanc.hunt.question.bean.AccessTestBean
import com.erbanc.hunt.question.bean.AnswerBean
import com.erbanc.hunt.question.bean.QuestionBean

interface QuestionsService {

    fun getQuestions(): List<QuestionBean>
    fun saveQuestion(question: QuestionBean)
    fun deleteQuestion(id: Long)
    fun isAccessible(accessTestBean: AccessTestBean): Boolean
    fun getQuestion(id: Long): QuestionBean
    fun tryAnswer(answerBean: AnswerBean): Boolean
}