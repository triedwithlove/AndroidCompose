/*
enum class DifficultyLvl {
    EASY, MEDIUM, HARD
}

////1------------------------------------------------------

data class Data_QuestionGenericEnum<T>(
    val questionText: String,
    val answer: T,
    val difficulty: DifficultyLvl
)

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

////2--------------------------------------------------------

class QuizzExt: ProgressPrintable {

    val dataQuestionGenericEnumString: Data_QuestionGenericEnum<String> = Data_QuestionGenericEnum(
        questionText = "[Generic] - Quoth the raven ___",
        answer = "[Generic] - nevermore",
        difficulty = DifficultyLvl.MEDIUM
    )

    val dataQuestionGenericEnumBoolean = Data_QuestionGenericEnum<Boolean>(
        questionText = "[Generic] - The sky is green. True or false",
        answer = false,
        difficulty = DifficultyLvl.EASY
    )

    val dataQuestionGenericEnumNumeric: Data_QuestionGenericEnum<Int> = Data_QuestionGenericEnum<Int>(
        questionText = "[Generic] - How many days are there between full moons?",
        answer = 28,
        difficulty = DifficultyLvl.HARD
    )

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }

    override val progressText: String
        get() = "${answered} of ${total} answered"

    override fun printProgressBar() {
        repeat(answered) {
            print("*")
        }
        repeat(total - answered) {
            print("/")
        }
        println()
        println(progressText)
    }
}


fun main() {

////1--------------------------------------------------------

    val strDataQuestionGenericEnum: Data_QuestionGenericEnum<String> = Data_QuestionGenericEnum(
        questionText = "[Generic] - Quoth the raven ___",
        answer = "[Generic] - nevermore",
        difficulty = DifficultyLvl.MEDIUM
    )

    val boolDataQuestionGenericEnum = Data_QuestionGenericEnum<Boolean>(
        questionText = "[Generic] - The sky is green. True or false",
        answer = false,
        difficulty = DifficultyLvl.EASY
    )

    val numDataQuestionGenericEnum: Data_QuestionGenericEnum<Int> = Data_QuestionGenericEnum<Int>(
        questionText = "[Generic] - How many days are there between full moons?",
        answer = 28,
        difficulty = DifficultyLvl.HARD
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

    QuizzExt().printProgressBar()

}
*/