


//use a function as a return type
//fun FUNCTION_NAME(): FUNCTION_TYPE {
//    return NAME_OF_ANOTHER_FUNCTION
// }

val evenNum = {
    println("Even")
}

val evenNumReturnsStr: () -> String = {
    "Even str"
}

val evenNumParamThenReturnsStr: (Int) -> String = { param ->
    "$param is Even"
}


val oddNum = {
    println("Odd")
}

val oddNumReturnsStr: () -> String = {
    "Odd str"
}

val oddNumParamThenReturnsStr: (Int) -> String = { param ->
    "$param is Odd"
}

fun evenOrOdd(nbre: Int): () -> Unit {
    if (0 == nbre % 2) {
        return evenNum
    }
    return oddNum
}

fun evenOrOddReturnsString(nbre: Int): () -> String {
    if (0 == nbre % 2) {
        return evenNumReturnsStr
    }
    return oddNumReturnsStr
}

fun evenOrOddParamThenReturnsString(nbre: Int): (Int) -> String {
    if (0 == nbre % 2) {
        return evenNumParamThenReturnsStr
    }
    return oddNumParamThenReturnsStr
}

fun main() {
    val evenFunct = evenOrOdd(10)
    val oddFunct = evenOrOdd(15)

    evenFunct()
    oddFunct()

    val evenFunctStr = evenOrOddReturnsString(8)
    val oddFunctStr = evenOrOddReturnsString(9)
    var evenOddStr = evenFunctStr()
    println("returned: $evenOddStr")

    evenOddStr = oddFunctStr()
    println("returned: $evenOddStr")

    val evenFunctParamStr = evenOrOddParamThenReturnsString(2)
    val oddFunctParamStr = evenOrOddParamThenReturnsString(1)
    var evenOddParamStr = evenFunctParamStr(2)
    println("return: $evenOddParamStr")

    evenOddParamStr = oddFunctParamStr(1)
    println("return: $evenOddParamStr")

}

/*
//Function as data type
val sayHello: () -> Unit = {
    println("Hello World")
}

val sayHelloNoParamWithStrReturnTYpe: () -> String = {
    "Hello World str returned type"
}

val sayHelloParamWithStrReturnTYpe: (Boolean) -> String = { param1 ->
    "Hello World param = \"$param1\" str returned type"
}

val sayHelloParamWithNoReturn: (Boolean) -> Unit = { param1 ->
    println("Hello World param = \"$param1\" No return")
}

val sayHello2ParamsWithStrReturnTYpe: (Int, Int) -> String = { param1, param2 ->
    "Hello World params ($param1, $param2) str returned type"
}

val sayHello2ParamsWithNoReturn: (Int, Int) -> Unit = { param1, param2 ->
    println("Hello World params ($param1, $param2) No return")
}

fun main() {
    val greeting = sayHello
    greeting()

    val greetingWithStrReturnTYpe = sayHelloNoParamWithStrReturnTYpe
    println(greetingWithStrReturnTYpe())

    val greetingParamWithStrReturnTYpe = sayHelloParamWithStrReturnTYpe
    println(greetingParamWithStrReturnTYpe(false))

    val greetingParamWithNoReturn = sayHelloParamWithNoReturn
    greetingParamWithNoReturn(true)

    val greeting2ParamsWithStrReturnTYpe = sayHello2ParamsWithStrReturnTYpe
    println(greeting2ParamsWithStrReturnTYpe(20, 8))

    val greeting2ParamsWithNoReturn = sayHello2ParamsWithNoReturn
    greeting2ParamsWithNoReturn(120, 85)
}
*/
