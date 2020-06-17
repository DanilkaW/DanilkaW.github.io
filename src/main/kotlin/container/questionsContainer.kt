package container

import components.QuestionsProps
import components.fQuestions
import data.*
import hoc.withDisplayName
import org.w3c.dom.events.Event
import react.*
import react.redux.rConnect
import redux.*

interface QuestionsDispatchProps : RProps {
    var onClick: (String) ->Unit
}

interface QuestionsStateProps : RProps {
    var questions: Map<Int, Question>
    var category: Array<Category>
    var currentCategory: String
}

val questionsHoc =
        rConnect<
                State,
                RAction,
                WrapperAction,
                RProps,                         // Own Props
                QuestionsStateProps,
                QuestionsDispatchProps,
                QuestionsProps
                >(
                mapStateToProps = { state, _ ->
                    questions = state.questions
                    category = state.category
                    currentCategory = state.currentCategory
                },
                mapDispatchToProps = { dispatch, _ ->
                    onClick = {dispatch(ChangeCategory(it))}

                }
        )

val questionsRClass =
        withDisplayName(
                "Questions",
                fQuestions
        )
                .unsafeCast<RClass<QuestionsProps>>()

val questionsContainer =
        questionsHoc(questionsRClass)