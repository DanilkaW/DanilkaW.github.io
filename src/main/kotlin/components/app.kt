package components

import container.redactContainer
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
}
    interface RouteNumberResult : RProps {
        var number: String
    }

    fun fApp() =
        functionalComponent<AppProps> { props ->
            div("home") {
                h1 {
                    +"Редактирование вопросов"
                }
                navLink(className = "nav", to = "/questions") {
                    +"Перейти к списку вопросов"
                }
                navLink(className = "nav", to = "/edit") {
                    +"Редактирование вопросов"
                }

                switch {
                    route("/questions",
                            exact = true,
                            render = { questions(props.questions, props.category) }
                    )
                    route("/edit",
                            exact = true,
                            render = { redactContainer {}}
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

