
interface IProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

enum class DiffLvl {
    EASY, MEDIUM, HARD
}

class QuestionGenEnum<T>(
    val questionText: String,
    val answer: T,
    val difficulty: DiffLvl
)

class QuizzX: IProgressPrintable {

    val questionGenericEnumStr: QuestionGenEnum<String> = QuestionGenEnum(
        questionText = "[Generic] - Quoth the raven ___",
        answer = "[Generic] - nevermore",
        difficulty = DiffLvl.MEDIUM
    )

    val questionGenericEnumBool = QuestionGenEnum<Boolean>(
        questionText = "[Generic] - The sky is green. True or false",
        answer = false,
        difficulty = DiffLvl.EASY
    )

    val questionGenericEnumNum: QuestionGenEnum<Int> = QuestionGenEnum<Int>(
        questionText = "[Generic] - How many days are there between full moons?",
        answer = 28,
        difficulty = DiffLvl.HARD
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

    fun printQuiz() {
        println("QuestionGenEnum<String>")
        println(questionGenericEnumStr.questionText)
        println(questionGenericEnumStr.answer)
        println(questionGenericEnumStr.difficulty)
        println()

        println("QuestionGenEnum<Boolean>")
        println(questionGenericEnumBool.questionText)
        println(questionGenericEnumBool.answer)
        println(questionGenericEnumBool.difficulty)
        println()

        println("QuestionGenEnum<Int>")
        println(questionGenericEnumNum.questionText)
        println(questionGenericEnumNum.answer)
        println(questionGenericEnumNum.difficulty)
        println()
    }


    fun printQuiz_scopeFunc() {
        println("QuestionGenEnum<String>")
        questionGenericEnumStr.let {
            param ->
                println(param.questionText)
                println(param.answer)
                println(param.difficulty)
        }
        println()

        println("QuestionGenEnum<Boolean>")
        questionGenericEnumBool.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()

        println("QuestionGenEnum<Int>")
        questionGenericEnumNum.let {
            p ->
                println(p.questionText)
                println(p.answer)
                println(p.difficulty)
        }
        println()
    }
}


fun main() {

////1--------------------------------------------------------

    val strQuestionGenericEnum: QuestionGenEnum<String> = QuestionGenEnum(
        questionText = "[Generic] - Quoth the raven ___",
        answer = "[Generic] - nevermore",
        difficulty = DiffLvl.MEDIUM
    )

    val boolQuestionGenericEnum = QuestionGenEnum<Boolean>(
        questionText = "[Generic] - The sky is green. True or false",
        answer = false,
        difficulty = DiffLvl.EASY
    )

    val numQuestionGenericEnum: QuestionGenEnum<Int> = QuestionGenEnum<Int>(
        questionText = "[Generic] - How many days are there between full moons?",
        answer = 28,
        difficulty = DiffLvl.HARD
    )

    println("QuestionGenEnum<String>:")
    println("${strQuestionGenericEnum.toString()}")
    println()

    println("QuestionGenEnum<Boolean>:")
    println("${boolQuestionGenericEnum.toString()}")
    println()

    println("QuestionGenEnum<Int>:")
    println("${numQuestionGenericEnum.toString()}")
    println()

    QuizzX().printProgressBar()

    //--------------------------------------------------
    QuizzX().printQuiz()
    QuizzX().printQuiz_scopeFunc()

    //-------------------------------------------------------
    val quizzX = QuizzX().apply {
        printQuiz_scopeFunc()
    }

}
