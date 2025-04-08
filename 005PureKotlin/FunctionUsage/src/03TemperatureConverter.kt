

//learning applying trailing lambda just to the current exercise
//not been general to check other conversion
fun main() {

    var initialMeasurement: Double = 27.0
    var initialUnit: String = "Celsius"
    var finalUnit: String = "Fahrenheit"
    printFinalTemperature(initialMeasurement, initialUnit, finalUnit) { param ->
        9 * param / 5 + 32
        //F = 9/5(degree Celsius) + 32
    }

    initialMeasurement = 350.0
    initialUnit = "Kelvin"
    finalUnit = "Celsius"
    printFinalTemperature(initialMeasurement, initialUnit, finalUnit) { param ->
        param - 273.15
        //C = degree Kelvin - 273.15
    }

    initialMeasurement = 10.0
    initialUnit = "Fahrenheit"
    finalUnit = "Kelvin"
    printFinalTemperature(initialMeasurement, initialUnit, finalUnit) { param ->
        5.0 / 9.0 * (param - 32) + 273.15
        //K = 5 / 9 * (degree Fahrenheit - 32) + 273.15
    }
}

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) //two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit")
}


/*
//learning apply just to the current exercise
//not been general to check other conversion
fun main() {

    var initialMeasurement: Double = 27.0
    var initialUnit: String = "Celsius"
    var finalUnit: String = "Fahrenheit"
    val formulaCelsius2Fahrenheit: (Double) -> Double = { param ->
        9 * param / 5 + 32
        //F = 9/5(degree Celsius) + 32
    }
    printFinalTemperature(initialMeasurement, initialUnit, finalUnit, formulaCelsius2Fahrenheit)

    initialMeasurement = 350.0
    initialUnit = "Kelvin"
    finalUnit = "Celsius"
    val formulaKelvin2Celsius: (Double) -> Double = { param ->
        param - 273.15
        //C = degree Kelvin - 273.15
    }
    printFinalTemperature(initialMeasurement, initialUnit, finalUnit, formulaKelvin2Celsius)

    initialMeasurement = 10.0
    initialUnit = "Fahrenheit"
    finalUnit = "Kelvin"
    val formulaFahrenheit2Kelvin: (Double) -> Double = { param ->
        5.0 / 9.0 * (param - 32) + 273.15
        //K = 5 / 9 * (degree Fahrenheit - 32) + 273.15
    }
    printFinalTemperature(initialMeasurement, initialUnit, finalUnit, formulaFahrenheit2Kelvin)
}

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) //two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit")
}
*/

/*
//learning applying trailing lambda to the current exercise
fun convertCelsius2Fahrenheit(
    initialMeasurement: Double,
    finalUnit: String
) {
    val initialUnit = "Celsius"

    printFinalTemperature(initialMeasurement, initialUnit, finalUnit) { param ->
        9 * param / 5 + 32
        //F = 9/5(degree Celsius) + 32
    }
}

fun convertKelvin2Celsius(
    initialMeasurement: Double,
    finalUnit: String
) {
    val initialUnit = "Kelvin"

    printFinalTemperature(initialMeasurement, initialUnit, finalUnit) { param ->
        param - 273.15
        //C = degree Kelvin - 273.15
    }
}

fun convertFahrenheit2Kelvin(
    initialMeasurement: Double,
    finalUnit: String
) {
    val initialUnit = "Fahrenheit"

    printFinalTemperature(initialMeasurement, initialUnit, finalUnit) { param ->
        5.0 / 9.0 * (param - 32) + 273.15
        //K = 5 / 9 * (degree Fahrenheit - 32) + 273.15
    }
}

fun printTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String
) {
    if (initialUnit.equals("Celsius")) {
        convertCelsius2Fahrenheit(
            initialMeasurement = initialMeasurement,
            finalUnit = finalUnit)
    } else if (initialUnit.equals("Kelvin")) {
        convertKelvin2Celsius(
            initialMeasurement = initialMeasurement,
            finalUnit = finalUnit)
    } else if (initialUnit.equals("Fahrenheit")) {
        convertFahrenheit2Kelvin(
            initialMeasurement = initialMeasurement,
            finalUnit = finalUnit)
    }
}

fun main() {

    printTemperature(27.0, "Celsius", "Fahrenheit")
    printTemperature(350.0, "Kelvin", "Celsius")
    printTemperature(10.0, "Fahrenheit", "Kelvin")
}

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) //two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit")
}
*/


/*
//learning apply just to the current exercise
fun convertCelsius2Fahrenheit(
    initialMeasurement: Double,
    finalUnit: String
) {
    val initialUnit = "Celsius"
    val formula: (Double) -> Double = { param ->
        9 * param / 5 + 32
        //F = 9/5(degree Celsius) + 32
    }
    printFinalTemperature(initialMeasurement, initialUnit, finalUnit, formula)
}

fun convertKelvin2Celsius(
    initialMeasurement: Double,
    finalUnit: String
) {
    val initialUnit = "Kelvin"
    val formula: (Double) -> Double = { param ->
        param - 273.15
        //C = degree Kelvin - 273.15
    }
    printFinalTemperature(initialMeasurement, initialUnit, finalUnit, formula)
}

fun convertFahrenheit2Kelvin(
    initialMeasurement: Double,
    finalUnit: String
) {
    val initialUnit = "Fahrenheit"
    val formula: (Double) -> Double = { param ->
        5.0 / 9.0 * (param - 32) + 273.15
        //K = 5 / 9 * (degree Fahrenheit - 32) + 273.15
    }
    printFinalTemperature(initialMeasurement, initialUnit, finalUnit, formula)
}

fun printTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String
) {
    if (initialUnit.equals("Celsius")) {
        convertCelsius2Fahrenheit(
            initialMeasurement = initialMeasurement,
            finalUnit = finalUnit)
    } else if (initialUnit.equals("Kelvin")) {
        convertKelvin2Celsius(
            initialMeasurement = initialMeasurement,
            finalUnit = finalUnit)
    } else if (initialUnit.equals("Fahrenheit")) {
        convertFahrenheit2Kelvin(
            initialMeasurement = initialMeasurement,
            finalUnit = finalUnit)
    }
}

fun main() {

    printTemperature(27.0, "Celsius", "Fahrenheit")
    printTemperature(350.0, "Kelvin", "Celsius")
    printTemperature(10.0, "Fahrenheit", "Kelvin")
}

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) //two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit")
}
*/

/*
//learning
fun convertCelsius2FahrenheitKelvin(
    initialMeasurement: Double,
    finalUnit: String
) {
    val initialUnit = "Celsius"
    if (finalUnit.equals("Fahrenheit")) {
        val formula: (Double) -> Double = { param ->
            9 * param / 5 + 32
            //F = 9/5(degree Celsius) + 32
            //C = 5.0 / 9.0 * (degree Fahrenheit - 32)
        }
        printFinalTemperature(initialMeasurement, initialUnit, finalUnit, formula)
    } else if (finalUnit.equals("Kelvin")) {
        val formula: (Double) -> Double = { param ->
            param + 273.15
            //C = degree Kelvin - 273.15
            //K = degree Celsius + 273.15
        }
        printFinalTemperature(initialMeasurement, initialUnit, finalUnit, formula)
    }
}

fun convertKelvin2CelsiusFahrenheit(
    initialMeasurement: Double,
    finalUnit: String
) {
    val initialUnit = "Kelvin"
    if (finalUnit.equals("Fahrenheit")) {
        val formula: (Double) -> Double = { param ->
            32 + 9 / 5 * (param - 273.15)
            //K = 5 / 9 * (degree Fahrenheit - 32) + 273.15
            //F = 32 + 9 / 5 * (degree Kelvin - 273.15)
        }
        printFinalTemperature(initialMeasurement, initialUnit, finalUnit, formula)
    } else if (finalUnit.equals("Celsius")) {
        val formula: (Double) -> Double = { param ->
            param - 273.15
            //C = degree Kelvin - 273.15
            //K = degree Celsius + 273.15
        }
        printFinalTemperature(initialMeasurement, initialUnit, finalUnit, formula)
    }
}

fun convertFahrenheit2KelvinCelsius(
    initialMeasurement: Double,
    finalUnit: String
) {
    val initialUnit = "Fahrenheit"
    if (finalUnit.equals("Kelvin")) {
        val formula: (Double) -> Double = { param ->
            5.0 / 9.0 * (param - 32) + 273.15
            //K = 5 / 9 * (degree Fahrenheit - 32) + 273.15
            //F = 32 + 9 / 5 * (degree Kelvin - 273.15)
        }
        printFinalTemperature(initialMeasurement, initialUnit, finalUnit, formula)
    } else if (finalUnit.equals("Celsius")) {
        val formula: (Double) -> Double = { param ->
            param - 273.15
            //F = 9.0 / 5.0 * (degree Celsius) + 32
            //C = 5.0 / 9.0 * (degree Fahrenheit - 32)
        }
        printFinalTemperature(initialMeasurement, initialUnit, finalUnit, formula)
    }
}

fun printTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String
) {
    if (initialUnit.equals("Celsius")) {
        convertCelsius2FahrenheitKelvin(
            initialMeasurement = initialMeasurement,
            finalUnit = finalUnit)
    } else if (initialUnit.equals("Kelvin")) {
        convertKelvin2CelsiusFahrenheit(
            initialMeasurement = initialMeasurement,
            finalUnit = finalUnit)
    } else if (initialUnit.equals("Fahrenheit")) {
        convertFahrenheit2KelvinCelsius(
            initialMeasurement = initialMeasurement,
            finalUnit = finalUnit)
    }
}

fun main() {

    printTemperature(27.0, "Celsius", "Fahrenheit")
    printTemperature(350.0, "Kelvin", "Celsius")
    printTemperature(10.0, "Fahrenheit", "Kelvin")
}

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) //two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit")
}
*/