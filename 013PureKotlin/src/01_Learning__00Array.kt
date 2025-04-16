
fun main() {

    val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
    println("rockPlanet: ${rockPlanets}")
    println("rockPlanet: ${rockPlanets.toString()}")

    val gazePlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
    println("gazePlanet: ")
    gazePlanets.forEach {
        println(it)
    }
    println()

    val solarSystem = rockPlanets + gazePlanets
    println("solarSystem: ")
    println("solarSystem[0]: ${solarSystem[0]}")
    println("solarSystem[1]: ${solarSystem[1]}")
    println("solarSystem[2]: ${solarSystem[2]}")
    println("solarSystem[3]: ${solarSystem[3]}")
    println("solarSystem[4]: ${solarSystem[4]}")
    println("solarSystem[5]: ${solarSystem[5]}")
    println("solarSystem[6]: ${solarSystem[6]}")
    println("solarSystem[7]: ${solarSystem[7]}")
    /*
    solarSystem[8] = "Pluto"
    Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 8 out of bounds for length 8
    at _01_Learning__00ArrayKt.main(01_Learning__00Array.kt:25)
    at _01_Learning__00ArrayKt.main(01_Learning__00Array.kt)
    */

    val newSolarSystem = arrayOf<String>("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Nepturne", "Pluto")
    println("newSolarSystem[8]: ${newSolarSystem[8]}")

}
