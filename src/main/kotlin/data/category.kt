package data

data class Category(
        val id: Int,
        val category: String,
        var questions: Array<Int>
)

val categoryList =
        arrayOf(
                Category(1, "География", arrayOf(0,1,2,3)),
                Category(2, "Программирование", arrayOf(4,5,6,7)),
                Category(3, "Иностранные языки", arrayOf(8,9,10,11)),
                Category(4,"EXAMPLE", arrayOf(12,13,14,15))
        )
