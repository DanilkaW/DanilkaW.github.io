package components

import container.questionsContainer
import data.Category
import data.Question
import kotlinx.html.id
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLSelectElement
import org.w3c.dom.events.Event
import react.*
import react.dom.*
import react.router.dom.*
import kotlin.browser.document

interface AppProps : RProps {
    var questions: Map<Int, Question>
    var category: Array<Category>
    var currentCategory: String
}
    interface RouteNumberResult : RProps {
        var number: String
    }

    fun fApp() =
        functionalComponent<AppProps> { _ ->
            div("home") {
                h1 {
                    +"Редактирование вопросов"
                }
                navLink(className = "nav", to = "/questions") {
                    +"Перейти к списку вопросов"
                }

                switch {
                    route("/questions",
                            exact = true,
                            render = { questionsContainer{} }
                    )
                }
            }
        }

    fun <O> RBuilder.renderObject(
        selector: (Int) -> O?,
        rElement: (Int, O) -> ReactElement
    ) =
        { route_props: RouteResultProps<RouteNumberResult> ->
            val num = route_props.match.params.number.toIntOrNull() ?: -1
            val obj = selector(num)
            if (obj != null) {
                rElement(num, obj)
            } else
                p { +"Object not found" }
        }

    fun RBuilder.app(
    ) =
        child(
            fApp()
        ) {
        }

