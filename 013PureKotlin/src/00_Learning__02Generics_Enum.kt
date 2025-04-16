
class QuestionGeneric<T>(
    val questionText: String,
    val answer: T,
    val difficulty: String
)

enum class Difficulty {
    EASY, MEDIUM, HARD
}

class QuestionGenericEnum<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)


fun main() {

    val strQuestionGeneric: QuestionGeneric<String> = QuestionGeneric(
        questionText = "[Generic] - Quoth the raven ___",
        answer = "[Generic] - nevermore",
        difficulty = "[Generic] - medium"
    )

    val boolQuestionGeneric = QuestionGeneric<Boolean>(
        questionText = "[Generic] - The sky is green. True or false",
        answer = false,
        difficulty = "[Generic] - easy"
    )

    val numQuestionGeneric: QuestionGeneric<Int> = QuestionGeneric<Int>(
        questionText = "[Generic] - How many days are there between full moons?",
        answer = 28,
        difficulty = "[Generic] - hard"
    )

    println("QuestionGeneric<String>:")
    println("${strQuestionGeneric.questionText}")
    println("${strQuestionGeneric.answer}")
    println("${strQuestionGeneric.difficulty}")
    println()

    println("QuestionGeneric<Boolean>:")
    println("${boolQuestionGeneric.questionText}")
    println("${boolQuestionGeneric.answer}")
    println("${boolQuestionGeneric.difficulty}")
    println()

    println("QuestionGeneric<Int>:")
    println("${numQuestionGeneric.questionText}")
    println("${numQuestionGeneric.answer}")
    println("${numQuestionGeneric.difficulty}")
    println()


    val strQuestionGenericEnum: QuestionGenericEnum<String> = QuestionGenericEnum(
        questionText = "[GenericEnum] - Quoth the raven ___",
        answer = "[GenericEnum] - nevermore",
        difficulty = Difficulty.MEDIUM
    )

    val boolQuestionGenericEnum = QuestionGenericEnum<Boolean>(
        questionText = "[GenericEnum] - The sky is green. True or false",
        answer = false,
        difficulty = Difficulty.EASY
    )

    val numQuestionGenericEnum: QuestionGenericEnum<Int> = QuestionGenericEnum<Int>(
        questionText = "[GenericEnum] - How many days are there between full moons?",
        answer = 28,
        difficulty = Difficulty.HARD
    )

    println("QuestionGenericEnum<String>:")
    println("${strQuestionGenericEnum.questionText}")
    println("${strQuestionGenericEnum.answer}")
    println("${strQuestionGenericEnum.difficulty}")
    println()

    println("QuestionGenericEnum<Boolean>:")
    println("${boolQuestionGenericEnum.questionText}")
    println("${boolQuestionGenericEnum.answer}")
    println("${boolQuestionGenericEnum.difficulty}")
    println()

    println("QuestionGenericEnum<Int>:")
    println("${numQuestionGenericEnum.questionText}")
    println("${numQuestionGenericEnum.answer}")
    println("${numQuestionGenericEnum.difficulty}")
    println()
}