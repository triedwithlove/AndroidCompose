
fun main() {

    val solarSystem = listOf<String>("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Nepturne")
    println("rockPlanet: ${solarSystem}")
    println("rockPlanet: ${solarSystem.toString()}")

    println("solarSystem: ")
    solarSystem.forEach {
        println(it)
    }
    println()
    println("solarSystem[2]: ${solarSystem[2]}")
    println("solarSystem.get(3): ${solarSystem.get(3)}")

    println()
    println("solarSystem.indexOf(\"Earth\"): ${solarSystem.indexOf("Earth")}")
    println("solarSystem.indexOf(\"Pluto\"): ${solarSystem.indexOf("Pluto")}")

    println()
    println("for loop ")
    for (planet in solarSystem) {
        print(planet + ", ")
    }

    println()
    println("forEach loop ")
    solarSystem.forEach {
        print(it + ", ")
    }
    /*
    solarSystem.add("Pluto")
        Kotlin: Unresolved reference 'add'.
    */

    val newSolarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Nepturne")
    println()
    println(newSolarSystem)

    newSolarSystem.add("Pluto")
    println(newSolarSystem)

    println("newSolarSystem[3] = ${newSolarSystem[3]}")
    newSolarSystem.add(3, "Theia")
    println("newSolarSystem[3] = ${newSolarSystem[3]}")
    newSolarSystem[3] = "Future Moon"
    println("newSolarSystem[3] = ${newSolarSystem[3]}")

    println()
    println(newSolarSystem)

    //Remove
    newSolarSystem.removeAt(5)
    println()
    println(newSolarSystem)

    newSolarSystem.remove("Future Moon")
    println()
    println(newSolarSystem)

    //check
    println()
    println("newSolarSystem.contains(\"Pluto\") = " + newSolarSystem.contains("Pluto"))
    println("\"Future Moon\" in newSolarSystem = " + ("Future Moon" in newSolarSystem))
    println("\"Future Moon\" in newSolarSystem = ${("Future Moon" in newSolarSystem)}")

}
