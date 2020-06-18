package data

typealias QuestionState = Map<Int, Question>

class State(
        val questions: QuestionState,
        val category: Array<Category>
)

fun <T> Map<Int, T>.newId() =
        (this.maxBy { it.key }?.key ?: 0) + 1


fun initialState() = (
        State(
                questionList,
                categoryList
        )
        )


