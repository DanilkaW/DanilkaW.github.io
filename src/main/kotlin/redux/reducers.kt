package redux

import data.*
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLSelectElement
import kotlin.browser.document
import kotlin.browser.window
import kotlin.js.Date
import kotlin.math.absoluteValue


fun rootReducer(state: State, action: RAction) =
        when (action) {
            is AddQuestion -> {
                val id = state.questions.newId()
                val newQuestions = state.questions.plus(id to action.question)
                val newCategories = state.category.map {
                    if(action.question.category == it.category){
                        it.questions = it.questions.plus(id)
                        console.log(id)
                        console.log(it.questions)
                    }
                    it
                }.toTypedArray()
                State(
                        newQuestions,
                        newCategories
                )
            }
            is DeleteQuestion -> {
                val newQuestions = state.questions.toMutableMap().apply {
                    remove(action.index)
                }
                val newCategories = state.category.map {
                    if(it.questions.contains(action.index)){
                        it.questions = it.questions.toMutableList().apply { remove(action.index)}.toTypedArray()
                    }
                    it
                }.toTypedArray()
                console.log(newCategories)
                State(
                        newQuestions,
                        newCategories
                )
            }
            else -> state
        }