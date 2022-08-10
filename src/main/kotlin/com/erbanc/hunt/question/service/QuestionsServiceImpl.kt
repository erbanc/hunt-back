package com.erbanc.hunt.question.service

import com.erbanc.hunt.question.bean.AccessTestBean
import com.erbanc.hunt.question.bean.AnswerBean
import com.erbanc.hunt.question.bean.QuestionBean
import com.erbanc.hunt.question.repository.QuestionsRepository
import com.erbanc.hunt.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class QuestionsServiceImpl(
    private val questionsRepository: QuestionsRepository,
    private val userRepository: UserRepository
) : QuestionsService {

    override fun getQuestions(): List<QuestionBean> = questionsRepository.findAll().map { entity ->
        entity.toBean()
    }

    override fun deleteQuestion(id: Long) = questionsRepository.deleteById(id)
    override fun isAccessible(accessTestBean: AccessTestBean): Boolean =
        userRepository.isAccessible(accessTestBean.username, accessTestBean.idQuestion)

    override fun getQuestion(id: Long): QuestionBean = questionsRepository.getReferenceById(id).toBean()

    override fun tryAnswer(answerBean: AnswerBean): Boolean {
        val correct = questionsRepository.tryAnswer(answerBean.id, answerBean.answer)

        if (correct) {
            userRepository.setQuestionReached(answerBean.id + 1, answerBean.username)
        }

        return correct
    }

    override fun saveQuestion(question: QuestionBean) {
        questionsRepository.save(question.toEntity())
    }
}