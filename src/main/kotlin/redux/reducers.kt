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
        is ChangeCategory -> {
            State(
                    state.questions,
                    state.category,
                    action.category
            )
        }
        else -> state
    }