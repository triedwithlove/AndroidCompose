package task

data class EventTsk01(
    val title: String,
    val description: String? = null,
    val daypart: String,
    val duration: Int
)

fun main () {
    val event: EventTsk01 = EventTsk01(
        title = "Study Kotlin",
        description = "Commit to studying Kotlin at least 15 minutes per day",
        daypart = "Evening",
        duration = 15
    )

    println(event)
}