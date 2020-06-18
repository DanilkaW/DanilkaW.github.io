package components

import data.Category
import data.Question
import hoc.withDisplayName
import kotlinx.html.hidden
import kotlinx.html.id
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLOptionElement
import org.w3c.dom.HTMLSelectElement
import org.w3c.dom.events.Event
import react.*
import react.dom.*
import react.router.dom.navLink
import kotlin.browser.document
import kotlin.dom.clear

interface QuestionsProps : RProps {
    var questions: Map<Int, Question>
    var category: Array<Category>
}

val fQuestions =
        functionalComponent<QuestionsProps> {props->
            val (currentCategory, setCategory) = useState("География")
           div{
               h2 {
                   +"Выберете категорию вопросов"
               }
               select ("select-css"){
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
                   props.questions.values.map { question ->
                       if(question.category==currentCategory){
                           h3 { +question.name }
                           table {
                              question.text.map { text->
                                  tr {
                                      td {
                                          +text
                                      }
                                      td {
                                          select ("select-css"){
                                              option {
                                                  attrs {
                                                      selected = true
                                                      disabled = true
                                                      hidden = true
                                                  }
                                              }
                                              for (element in question.asnwers) {
                                                  option {
                                                      +element
                                                  }
                                              }
                                          }
                                      }
                                  }
                              }
                           }
                       }
               }

           }}
fun RBuilder.questions(
        questions: Map<Int, Question>,
        category: Array<Category>
) = child(
        withDisplayName("Questions", fQuestions)
) {
    attrs.questions = questions
    attrs.category = category
}