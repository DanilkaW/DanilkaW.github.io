package container

import components.RedactProps
import components.fRedact
import data.*
import hoc.withDisplayName
import org.w3c.dom.events.Event
import react.*
import react.redux.rConnect
import redux.*

interface RedactDispatchProps : RProps {
    var add: (Question) -> Unit
    var delete: (Int) -> Unit
}

interface RedactStateProps: RProps {
    var questions: Map<Int, Question>
    var category: Array<Category>
}

val redactHoc =
        rConnect<
                State,
                RAction,
                WrapperAction,
                RProps,                         // Own Props
                RedactStateProps,
                RedactDispatchProps,
                RedactProps
                >(
                mapStateToProps = { state, _ ->
                    questions = state.questions
                    category = state.category
                },
                mapDispatchToProps = { dispatch, _ ->
                    add = { dispatch(AddQuestion(it)) }
                    delete = { dispatch(DeleteQuestion(it)) }
                }
        )

val redactRClass =
        withDisplayName(
                "redact",
                fRedact
        )
                .unsafeCast<RClass<RedactProps>>()

val redactContainer =
        redactHoc(redactRClass)