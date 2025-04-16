
fun main() {

    val solarSystem = mapOf<String, Int>(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14)
    println("rockPlanet: $solarSystem")
    println("rockPlanet: ${solarSystem.toString()}")

    println()
    println("solarSystem: ")
    solarSystem.forEach {
        println(it)
    }

    println()
    println("solarSystem.size: ${solarSystem.size}")
    println()
    println("solarSystem.get(\"Jupiter\"): ${solarSystem.get("Jupiter")}")
    println("solarSystem.get(\"Pluton\"): ${solarSystem.get("Pluton")}")

    println()
    println("for loop ")
    for (planet in solarSystem) {
        print(planet)
        print(", ")
    }

    println()
    println("forEach loop ")
    solarSystem.forEach {
        print(it)
        print(", ")
    }

/*
    solarSystem.remove("Nepturne")
        Kotlin: Unresolved reference 'remove'.
*/

    val newSolarSystem = mutableMapOf<String, Int>(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Nepturne" to 14)
    println()
    println(newSolarSystem)

    newSolarSystem["Pluton"] = 5
    println()
    println(newSolarSystem)
    println(newSolarSystem["pluto"])
    println()
    println("solarSystem.size: ${newSolarSystem.size}")

    println()
    println("solarSystem.size: ${newSolarSystem.size}")
    newSolarSystem.remove("Jupiter")
    println()
    println("solarSystem.size: ${newSolarSystem.size}")
    
}
