
enum class DifficultyLevel {
    EASY, MEDIUM, HARD
}

class QuestionGeneric_enum<T>(
    val questionText: String,
    val answer: T,
    val difficulty: DifficultyLevel
)

////1------------------------------------------------------

data class DataQuestionGenericEnum<T>(
    val questionText: String,
    val answer: T,
    val difficulty: DifficultyLevel
)

////2--------------------------------------------------------

object StudentProgress {
    var total: Int = 10
    var answered: Int = 3
}

////3--------------------------------------------------------

class Quizz {

    val dataQuestionGenericEnumStr: DataQuestionGenericEnum<String> = DataQuestionGenericEnum(
        questionText = "[Generic] - Quoth the raven ___",
        answer = "[Generic] - nevermore",
        difficulty = DifficultyLevel.MEDIUM
    )

    val dataQuestionGenericEnumBool = DataQuestionGenericEnum<Boolean>(
        questionText = "[Generic] - The sky is green. True or false",
        answer = false,
        difficulty = DifficultyLevel.EASY
    )

    val dataQuestionGenericEnumNum: DataQuestionGenericEnum<Int> = DataQuestionGenericEnum<Int>(
        questionText = "[Generic] - How many days are there between full moons?",
        answer = 28,
        difficulty = DifficultyLevel.HARD
    )

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
}

////4--------------------------------------------------------

val Quizz.StudentProgress.progressText: String
    get() = "${answered} of ${total} answered"

////5--------------------------------------------------------

fun Quizz.StudentProgress.printProgressBar() {
    repeat(Quizz.answered) {
        print("*")
    }
    repeat(Quizz.total - Quizz.answered) {
        print("/")
    }
    println()
    println(Quizz.progressText)
}


fun main() {

    val strQuestionGeneric_enum: QuestionGeneric_enum<String> = QuestionGeneric_enum(
        questionText = "[Generic_enum] - Quoth the raven ___",
        answer = "[Generic_enum] - nevermore",
        difficulty = DifficultyLevel.MEDIUM
    )

    val boolQuestionGeneric_enum = QuestionGeneric_enum<Boolean>(
        questionText = "[Generic_enum] - The sky is green. True or false",
        answer = false,
        difficulty = DifficultyLevel.EASY
    )

    val numQuestionGeneric_enum: QuestionGeneric_enum<Int> = QuestionGeneric_enum<Int>(
        questionText = "[Generic_enum] - How many days are there between full moons?",
        answer = 28,
        difficulty = DifficultyLevel.HARD
    )

    println("QuestionGeneric_enum<String>:")
    println("${strQuestionGeneric_enum.questionText}")
    println("${strQuestionGeneric_enum.answer}")
    println("${strQuestionGeneric_enum.difficulty}")
    println()
    println("QuestionGeneric_enum<Boolean>:")
    println("${boolQuestionGeneric_enum.questionText}")
    println("${boolQuestionGeneric_enum.answer}")
    println("${boolQuestionGeneric_enum.difficulty}")
    println()

    println("QuestionGeneric_enum<Int>:")
    println("${numQuestionGeneric_enum.questionText}")
    println("${numQuestionGeneric_enum.answer}")
    println("${numQuestionGeneric_enum.difficulty}")
    println()

////1--------------------------------------------------------

    val strDataQuestionGenericEnum: DataQuestionGenericEnum<String> = DataQuestionGenericEnum(
        questionText = "[Generic] - Quoth the raven ___",
        answer = "[Generic] - nevermore",
        difficulty = DifficultyLevel.MEDIUM
    )

    val boolDataQuestionGenericEnum = DataQuestionGenericEnum<Boolean>(
        questionText = "[Generic] - The sky is green. True or false",
        answer = false,
        difficulty = DifficultyLevel.EASY
    )

    val numDataQuestionGenericEnum: DataQuestionGenericEnum<Int> = DataQuestionGenericEnum<Int>(
        questionText = "[Generic] - How many days are there between full moons?",
        answer = 28,
        difficulty = DifficultyLevel.HARD
    )

    println("DataQuestionGenericEnum<String>:")
    println("${strDataQuestionGenericEnum.toString()}")
    println()

    println("DataQuestionGenericEnum<Boolean>:")
    println("${boolDataQuestionGenericEnum.toString()}")
    println()

    println("DataQuestionGenericEnum<Int>:")
    println("${numDataQuestionGenericEnum.toString()}")
    println()

////2--------------------------------------------------------

    println("${StudentProgress.answered} of ${StudentProgress.total} answered.")

////3--------------------------------------------------------

    println("${Quizz.answered} of ${Quizz.StudentProgress.total} answered.")

////4--------------------------------------------------------

    println("${Quizz.progressText}")

////5--------------------------------------------------------

    Quizz.printProgressBar()

}
