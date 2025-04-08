

fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("ATiqah", 33, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
}

class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")

        var message: String = "Likes to "
        if (null != hobby) {
            message += hobby + ". "
        }
        if (null == referrer) {
            message += "Doesn't have a referrer.\n"
        } else {
            if (null != referrer.hobby) {
                message += "Has a referrer named ${referrer.name}, who likes to ${referrer.hobby}\n"
            }
        }
        println(message)
    }
}