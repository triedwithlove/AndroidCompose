


//Pass a function to another function as argument

val evenNumParamThenReturn: (Int) -> String = { param ->
    "Number $param is Even"
}

val oddNumParamThenReturn: (Int) -> String = { param ->
    "Number $param is Odd"
}

fun computeEvenOrOdd(param: Int): Boolean {
    return (0 == param % 2)
}

fun evenOrOdd(num: Int, computeFunc: (Int) -> Boolean): (Int) -> String {
    if (computeFunc(num)) {
        return evenNumParamThenReturn
    }
    return oddNumParamThenReturn
}

fun main() {

    val computeNumFunc = ::computeEvenOrOdd
    val evenFunction = evenOrOdd(12, computeNumFunc)
    val oddFunction = evenOrOdd(9, computeNumFunc)

    println(evenFunction(12))
    println(oddFunction(9))
}


/*
val evenNumNoParamThenReturn = {
    "Even number"
}

val oddNumNoParamThenReturn = {
    "Odd number"
}

fun computeEvenOrOdd(param: Int): Boolean {
    return (0 == param % 2)
}

fun evenOrOdd(num: Int, computeFunc: (Int) -> Boolean): () -> String {
    if (computeFunc(num)) {
        return evenNumNoParamThenReturn
    }
    return oddNumNoParamThenReturn
}

fun main() {

    val computeNumFunc = ::computeEvenOrOdd
    val evenFunction = evenOrOdd(12, computeNumFunc)
    val oddFunction = evenOrOdd(9, computeNumFunc)

    println(evenFunction())
    println(oddFunction())
}
*/


/*
val evenNumNoParamNoReturn = {
    println("Even")
}

val oddNumNoParamNoReturn = {
    println("Odd")
}

val computeEvenOrOdd: (Int) -> Boolean = { param ->
    (0 == param % 2)
}

fun evenOrOdd(num: Int, compute: (Int) -> Boolean): () -> Unit {
    if (compute(num)) {
        return evenNumNoParamNoReturn
    }
    return oddNumNoParamNoReturn
}

fun main() {

    val evenFunction = evenOrOdd(12, computeEvenOrOdd)
    val oddFunction = evenOrOdd(9, computeEvenOrOdd)

    evenFunction()
    oddFunction()

}
*/

