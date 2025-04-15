
class FillInTheBlankQuestion(
    val questionText: String,
    val answer: String,
    val difficulty: String
)

class TrueOrFalseQuestion(
    val questionText: String,
    val answer: Boolean,
    val difficulty: String
)

class NumericQuestion(
    val questionText: String,
    val answer: Int,
    val difficulty: String
)

class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: String
)


fun main() {
    val fillInTheBlankQuestion: FillInTheBlankQuestion = FillInTheBlankQuestion(
        questionText = "Quoth the raven ___",
        answer = "nevermore",
        difficulty = "medium"
    )

    val trueOrFalseQuestion: TrueOrFalseQuestion = TrueOrFalseQuestion(
        questionText = "The sky is green. True or false",
        answer = false,
        difficulty = "easy"
    )

    val numericQuestion: NumericQuestion = NumericQuestion(
        questionText = "How many days are there between full moons?",
        answer = 28,
        difficulty = "hard"
    )

    println("FillInTheBlankQuestion:")
    println("${fillInTheBlankQuestion.questionText}")
    println("${fillInTheBlankQuestion.answer}")
    println("${fillInTheBlankQuestion.difficulty}")
    println()

    println("TrueOrFalseQuestion:")
    println("${trueOrFalseQuestion.questionText}")
    println("${trueOrFalseQuestion.answer}")
    println("${trueOrFalseQuestion.difficulty}")
    println()

    println("NumericQuestion:")
    println("${numericQuestion.questionText}")
    println("${numericQuestion.answer}")
    println("${numericQuestion.difficulty}")
    println()

    val strQuestion: Question<String> = Question(
        questionText = "Quoth the raven ___",
        answer = "nevermore",
        difficulty = "medium"
    )

    val boolQuestion = Question<Boolean>(
        questionText = "The sky is green. True or false",
        answer = false,
        difficulty = "easy"
    )

    val numQuestion: Question<Int> = Question<Int>(
        questionText = "How many days are there between full moons?",
        answer = 28,
        difficulty = "hard"
    )

    println("Question<String>:")
    println("${strQuestion.questionText}")
    println("${strQuestion.answer}")
    println("${strQuestion.difficulty}")
    println()

    println("Question<Boolean>:")
    println("${boolQuestion.questionText}")
    println("${boolQuestion.answer}")
    println("${boolQuestion.difficulty}")
    println()

    println("Question<Int>:")
    println("${numQuestion.questionText}")
    println("${numQuestion.answer}")
    println("${numQuestion.difficulty}")
    println()

}