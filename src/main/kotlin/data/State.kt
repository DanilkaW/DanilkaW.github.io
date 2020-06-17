package data

typealias QuestionState = Map<Int, Question>

class State(
        val questions: QuestionState,
        val category: Array<Category>,
        var currentCategory: String = "География"
)


fun initialState() = (
        State(
                questionList,
                categoryList
        )
        )


