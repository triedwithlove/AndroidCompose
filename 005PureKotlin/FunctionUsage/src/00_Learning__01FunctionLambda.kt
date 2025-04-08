

//Store a function in a variable
fun sayHello() {
    println("Hello World")
}

fun getHelloMessage(): String {
    println("Hello World Message")
    return "Hello World Message"
}

fun sayHelloWithParam(name: String) {
    println("Hello $name")
}

fun getHelloWithParamThenReturn(name: String): String {
    println("Hello $name param then return")
    return "Hello $name param then return"
}

//function with a lambda expression
var funLambdaExpr = {
    println("Hello World from Lambda")
}

var funLambdaExprThenReturn = {
    println("Hello World from Lambda")
    "<< Hello World from Lambda" //the string is returned. Here return keyword is not needed
}

var funLambdaExprWithParam = { name: String ->
    println("Hello $name from Lambda with parameter")
    val nameUpper = name.uppercase()
    println("Hello $name from Lambda with parameter ($name) ==> ($nameUpper)")
}

var funLambdaExprWithParamThenReturn = { name: String ->
    println("Hello $name from Lambda with parameter")
    val nameUpper = name.uppercase()
    println("Hello $name from Lambda with parameter ($name) ==> ($nameUpper)")
    "<< Hello $name from Lambda with parameter ($name) ==> ($nameUpper)"
}


fun main() {
    println("Store a function in a variable")
    sayHello()
    val greetingMsg = getHelloMessage()
    println("Printed from Main-- $greetingMsg")
    sayHelloWithParam("Karly")
    val greetingMsgReturn = getHelloWithParamThenReturn("Karly")
    println("Printed from Main-- $greetingMsgReturn")

    val greetingFun = ::sayHello
    greetingFun()

    val greetingFunThenReturn = ::getHelloMessage
    val greetingMessage = greetingFunThenReturn()
    println("Printed from Main-- $greetingMessage")

    val greetingFunWithParam = ::sayHelloWithParam
    greetingFunWithParam("Karly")

    val greetingFunWithParamThenReturn = ::getHelloWithParamThenReturn
    val greetingMessageReturned = greetingFunWithParamThenReturn("Karly")
    println("Printed from Main-- $greetingMessageReturned")



    println("\nfunction with a lambda expression")
    val greetingFunViaLambda = funLambdaExpr
    greetingFunViaLambda()

    val greetingFunViaLambdaThenReturn = funLambdaExprThenReturn
    val greetingValueFromLambdaThenReturn = greetingFunViaLambdaThenReturn()
    println("Lambda - Printed from Main-- $greetingValueFromLambdaThenReturn")

    val greetingViaLambdaWithParam = funLambdaExprWithParam
    greetingViaLambdaWithParam("Karly")

    val greetingFunViaLambdaWithParamThenReturn = funLambdaExprWithParamThenReturn
    val greetingValueFromLambdaWithParamThenReturn = greetingFunViaLambdaWithParamThenReturn("Karly")
    println("Lambda - Printed from Main-- $greetingValueFromLambdaWithParamThenReturn")


}



/*
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val name = "Kotlin"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello, " + name + "!")

    for (i in 1..5) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        println("i = $i")
    }
}
*/