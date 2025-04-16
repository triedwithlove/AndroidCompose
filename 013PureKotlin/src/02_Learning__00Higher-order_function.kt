
class Cookie(
    val name: String,
    val softBacked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie(
        name = "Chocolate Chip",
        softBacked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBacked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBacked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBacked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBacked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBacked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBacked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun usingFunction_forEach() {

    println("cookies: ")
    cookies.forEach { c ->
        println("Menu item: $c")
    }
    println()

    println("cookies with it: ")
    cookies.forEach {
        println("Menu item: $it")
    }
    println()


    println("cookies: ")
    cookies.forEach { c ->
        println("Menu item: ${c.name}")
    }
    println()

    println("cookies with it: ")
    cookies.forEach {
        println("Menu item: ${it.name}")
    }
    println()
}

fun usingFunction_map() {
    val fullMenu = cookies.map { c ->
        "${c.name} - $${c.price}"
    }
    println("Full menu: ")
    fullMenu.forEach { c ->
        println("Menu item: $c")
    }
    println()

    val fullMenu_it = cookies.map {
        "${it.name} - $${it.price}"
    }
    println("Full menu with it: ")
    fullMenu.forEach { c ->
        println("Menu item: $c")
    }
    println()
}

fun usingFunction_filter() {

    var softBackedMenu = cookies.filter {
            cookie: Cookie -> cookie.softBacked
    }

    println("Soft Cookies: ")
    softBackedMenu.forEach {
        println("${it.name} - ${it.price}")
    }
}

fun usingFunction_groupBy() {

    val groupMenu = cookies.groupBy {
            param -> param.softBacked
    }

    println("Group Menu: ")
    groupMenu.forEach {
        println("Group Menu item: $it")
    }
    println()

    val softBakedMenu = groupMenu[true] ?: listOf()
    val crunchyMenu = groupMenu[false] ?: listOf()

    println("Soft cookies: ")
    softBakedMenu.forEach {
            param -> println("${param.name} - ${param.price}")
    }
    println()

    println("Crunchy cookies with it: ")
    crunchyMenu.forEach {
        println("${it.name} - ${it.price}")
    }
    println()
}

fun usingFunction_fold() {

    val totalPrice = cookies.fold(initial = 0.0, operation = {total, cookie -> total + cookie.price})

    println("Fold: ")
    println("Total Price = " + totalPrice)

    //trailing lambda
    val newTotalPrice = cookies.fold(initial = 0.0) { total, cookie ->
        total + cookie.price
    }

    println()
    println("Fold (trailing lambda): ")
    println("Total Price = $newTotalPrice")
}

fun usingFunction_sortedBy() {
    val alphabeticalMenu = cookies.sortedBy { param ->
        param.name
    }

    //using it
    //val alphabeticalMenu = cookies.sortedBy {
    //    it.name
    //}

    println("Alphabetical Ascen Menu: ")
    alphabeticalMenu.forEach {
        println("${it.name}")
    }
    println("\n")

    val alphabeticalDescMenu = cookies.sortedByDescending { param ->
        param.name
    }

    println("Alphabetical Desc Menu: ")
    alphabeticalDescMenu.forEach {
        println("${it.name}")
    }
    println("\n")
}

fun main() {

    usingFunction_forEach()
    usingFunction_map()
    usingFunction_filter()
    usingFunction_groupBy()
    usingFunction_fold()
    usingFunction_sortedBy()
}
