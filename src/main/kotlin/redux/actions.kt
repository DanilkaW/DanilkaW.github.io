package redux

import data.Question

class AddQuestion(val question:Question):RAction
class DeleteQuestion(val index: Int):RAction