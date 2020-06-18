package components

import data.Category
import data.Question
import hoc.withDisplayName
import kotlinx.html.InputType
import kotlinx.html.defaultArea
import kotlinx.html.hidden
import kotlinx.html.id
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLSelectElement
import org.w3c.dom.events.Event
import react.*
import react.dom.*
import kotlin.browser.document

interface RedactProps : RProps {
    var questions: Map<Int, Question>
    var category: Array<Category>
    var add: (Question) -> Unit
    var delete: (Int) -> Unit
}

val fRedact =
        functionalComponent<RedactProps> { props ->
            val (currentCategory, setCategory) = useState("География")
            h2 {
                +"Выберете категорию вопросов"
            }
            select("select-css") {
                for (element in props.category) {
                    attrs.id = "category"
                    option {
                        +element.category
                    }
                    attrs.onChangeFunction = {
                        val categoryHtml = document.getElementById("category") as HTMLSelectElement
                        setCategory(categoryHtml.value)
                    }
                }
            }
            button(classes = "big") {
                +"Добавить вопрос"
                attrs.id = "myBtn"
                attrs.onClickFunction = {
                    val modal = document.getElementById("myModal") as HTMLDivElement
                    modal.style.display = "block"
                }
            }
            div("delete"){
                props.questions.filter { it.value.category == currentCategory }.map {
                        button {
                            +"Удалить вопрос ${it.key+1}"
                            attrs.onClickFunction = {_: Event ->
                                props.delete(it.key)
                            }
                        }
                }
            }
            props.questions.values.mapIndexed { _, question ->
                if (question.category == currentCategory) {
                    div("edit") {
                        h4 { +"${question.name}" }
                        input(InputType.text) {
                            attrs.placeholder = "Новое имя вопроса"
                        }
                        button {
                            +"Сохранить"
                        }

                        ul {
                            question.text.map { text ->
                                li {
                                    +"Подвопрос:${text}"
                                    input(InputType.text) {
                                        attrs.placeholder = "Новый подвопрос"
                                    }
                                    button {
                                        +"Сохранить"
                                    }
                                }
                            }
                            question.asnwers.map { answer ->
                                li {
                                    +"Ответ: ${answer}"
                                    input(InputType.text) {
                                        attrs.placeholder = "Новый ответ"
                                    }
                                    button {
                                        +"Сохранить"
                                    }
                                }
                            }

                        }
                    }
                }

            }
            div("modal") {
                attrs.id = "myModal"
                div("modal-content") {
                    h4 { +"Введите имя вопроса" }
                    input(InputType.text) {
                        attrs.id = "name"
                    }
                    h4 { +"Выберете категорию вопроса" }
                    select("select-css") {
                        for (element in props.category) {
                            attrs.id = "qcat"
                            option {
                                +element.category
                            }
                        }
                    }
                    h4 { +"Введите текст вопроса" }
                    input(InputType.text) {
                        attrs.id = "t1"
                    }
                    input(InputType.text) {
                        attrs.id = "t2"
                    }
                    input(InputType.text) {
                        attrs.id = "t3"
                    }
                    h4 { +"Введите ответы на  вопросы" }
                    input(InputType.text) {
                        attrs.id = "a1"
                    }
                    input(InputType.text) {
                        attrs.id = "a2"
                    }
                    input(InputType.text) {
                        attrs.id = "a3"
                    }
                    button {
                        +"Добавить"
                        attrs.onClickFunction = {
                            val modal = document.getElementById("myModal") as HTMLElement
                            val name = document.getElementById("name") as HTMLInputElement
                            val cat = document.getElementById("qcat") as HTMLSelectElement
                            val t1 = document.getElementById("t1") as HTMLInputElement
                            val t2 = document.getElementById("t2") as HTMLInputElement
                            val t3 = document.getElementById("t3") as HTMLInputElement
                            val a1 = document.getElementById("a1") as HTMLInputElement
                            val a2 = document.getElementById("a2") as HTMLInputElement
                            val a3 = document.getElementById("a3") as HTMLInputElement
                            val newQuestion = Question(
                                    name.value,
                                    cat.value,
                                    arrayOf(t1.value, t2.value, t3.value),
                                    arrayOf(a1.value, a2.value, a3.value)
                            )
                            props.add(newQuestion)
                            modal.style.display = "none"
                        }

                    }
                    button {
                        +"Закрыть"
                        attrs.onClickFunction = {
                            val modal = document.getElementById("myModal") as HTMLElement
                            val name = document.getElementById("name") as HTMLInputElement
                            val cat = document.getElementById("qcat") as HTMLSelectElement
                            val t1 = document.getElementById("t1") as HTMLInputElement
                            val t2 = document.getElementById("t2") as HTMLInputElement
                            val t3 = document.getElementById("t3") as HTMLInputElement
                            val a1 = document.getElementById("a1") as HTMLInputElement
                            val a2 = document.getElementById("a2") as HTMLInputElement
                            val a3 = document.getElementById("a3") as HTMLInputElement
                            modal.style.display = "none"
                            name.value = ""
                            cat.value = ""
                            t1.value = ""
                            t2.value = ""
                            t3.value = ""
                            a1.value = ""
                            a2.value = ""
                            a3.value = ""
                        }
                    }
                }
            }

        }

fun RBuilder.redact(
        questions: Map<Int, Question>,
        category: Array<Category>,
        add: (Question) -> (Unit),
        delete: (Int) -> (Unit)

) = child(
        withDisplayName("Redact", fRedact)
) {
    attrs.questions = questions
    attrs.category = category
    attrs.add = add
    attrs.delete = delete
}