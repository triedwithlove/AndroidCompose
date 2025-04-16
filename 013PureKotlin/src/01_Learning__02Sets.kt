
fun main() {


    val solarSystem = setOf<String>("Mercury", "Venus", "Earth", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println("solarSystem: ${solarSystem}")
    println("solarSystem: ${solarSystem.toString()}")

    println("solarSystem: ")
    solarSystem.forEach {
        println(it)
    }

    println()
    println("solarSystem.size = ${solarSystem.size}")

    println()
    println("solarSystem.elementAt(2): ${solarSystem.elementAt(2)}")
    println("solarSystem.toList().get(3): ${solarSystem.toList().get(3)}")
    println("solarSystem.indexOf(\"Saturn\"): ${solarSystem.indexOf("Saturn")}")

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

    val newSolarSystem = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Saturn", "Uranus", "Nepturne")
    println()
    println(newSolarSystem)

    newSolarSystem.add("Pluto")
    println(newSolarSystem)

    println("newSolarSystem.contains(\"Future Moon\") = " + newSolarSystem.contains("Future Moon"))

    //Remove
    newSolarSystem.remove("Saturn")
    println()
    println(newSolarSystem)

}
