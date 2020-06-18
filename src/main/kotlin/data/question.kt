package data

data class Question (
        val name: String,
        val category: String,
        var text: Array<String>,
        val asnwers: Array<String>
)

val questionList =
        arrayOf(
            Question(
                    "Какая столица у данной страны?",
                    "География",
                    arrayOf("Россия","Япония", "Италия"),
                    arrayOf("Токио", "Москва", "Рим")
            ),
            Question(
                    "Какая река лежит на территории страны?",
            "География",
                    arrayOf("Россия","Египет","США"),
                    arrayOf("Волга","Нил","Огайо")
            ),
            Question(
                    "Какая гора находится на территории страны?",
                    "География",
                    arrayOf("Россия","США","Бразилия"),
                    arrayOf("Корковаду","Эльбрус","Шаста")
            ),
            Question(
                "Соотнесите название горы и место, которое она занимает в мировом топе по высоте",
                "География",
                arrayOf("Эверест","Чогори","Канченджанга"),
                arrayOf("1","2","3")
            ),
            Question(
                    "Соотнесите понятия",
                    "Программирование",
                    arrayOf("Используется для передачи информации из компонента верхнего уровня в компонент нижнего уровня",
                    "Используется для передачи информации из компонента нижнего уровня в компонент верхнего уровня",
                    "Не используется при передачи информации между компонентами"),
                    arrayOf("State","Props","OnClick")
            ),
            Question(
                    "Поставьте в соответствие функции react router и их описание",
                    "Программирование",
                    arrayOf("hashRouter","navLink","switch","route"),
                    arrayOf("переключает страницы приложения","задает ссылки для переключения страниц приложения","самый верхний компонент, работает с URL","задает вариант страницы приложения")
            ),
            Question(
                    "Соотнесите понятия",
                    "Программирование",
                    arrayOf("KClass","RClass","RComponent"),
                    arrayOf("Класс для создания элементов React","Класс, описывающий компонент React","Класс Kotlin")
            ),
            Question(
                "Сопоставьте значения из двух списков",
                "Программирование",
                arrayOf("React","Redux","React Route"),
                arrayOf("Интерфейс приложение и взаимодействие с пользователем","Состояние приложение","Навигация по страницам приложения")
            ),
            Question(
                "Сопоставьте перевод (Английский язык)",
                "Иностранные языки",
                arrayOf("Автомобиль","Молоток","Стройка"),
                arrayOf("Car","Hammer","Building")
            ),
            Question(
                "Сопоставьте перевод (Немецкий язык)",
                "Иностранные языки",
                arrayOf("Суп","Горчица","Лист"),
                arrayOf("Suppe","Senf","Blatt")
            ),
            Question(
                "Сопоставьте перевод (Французский язык)",
                "Иностранные языки",
                arrayOf("Лошадь","Вентиляция","Яблоко"),
                arrayOf("Cheval","Ventilation","Une pomme")
            ),
            Question(
                "Сопоставьте перевод (Латынь)",
                "Иностранные языки",
                arrayOf("Борода","Дождь","Мир"),
                arrayOf("Barba","Pluvia","Pax")
            ),
            Question(
                "EXAMPLE_QUESTION1",
                "EXAMPLE",
                arrayOf("Question1_1","Question1_2","Question1_3"),
                arrayOf("Answer1_1","Answer1_2","Answer1_3")
            ),
            Question(
                "EXAMPLE_QUESTION2",
                "EXAMPLE",
                arrayOf("Question2_1","Question2_2","Question2_3"),
                arrayOf("Answer2_1","Answer2_2","Answer2_3")
            ),
            Question(
                "EXAMPLE_QUESTION3",
                "EXAMPLE",
                arrayOf("Question3_1","Question3_2","Question3_3"),
                arrayOf("Answer3_1","Answer3_2","Answer3_3")
            ),
            Question(
                "EXAMPLE_QUESTION4",
                "EXAMPLE",
                arrayOf("Question4_1","Question4_2","Question4_3"),
                arrayOf("Answer4_1","Answer4_2","Answer4_3")
            )
    ).mapIndexed { index, drug -> index to drug }.toMap()
