package com.erbanc.hunt.question.web

import com.erbanc.hunt.question.bean.AccessTestBean
import com.erbanc.hunt.question.bean.AnswerBean
import com.erbanc.hunt.question.bean.QuestionBean
import com.erbanc.hunt.question.service.QuestionsService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/questions")
class QuestionsController(private val questionsService: QuestionsService) {

    @GetMapping
    fun getQuestions(): List<QuestionBean> = questionsService.getQuestions()

    @GetMapping("/{id}")
    fun getQuestion(@PathVariable id: Long): QuestionBean = questionsService.getQuestion(id)

    @PostMapping("/is-accessible")
    fun isQuestionAccessible(@RequestBody accessTestBean: AccessTestBean): Boolean = questionsService.isAccessible(accessTestBean)

    @PostMapping("/answer")
    fun tryAnswer(@RequestBody answerBean: AnswerBean): Boolean = questionsService.tryAnswer(answerBean)

    @PostMapping
    fun postQuestion(@RequestBody question: QuestionBean) = questionsService.saveQuestion(question)

    @DeleteMapping("/{id}")
    fun deleteQuestion(@PathVariable id: Long) = questionsService.deleteQuestion(id)
}