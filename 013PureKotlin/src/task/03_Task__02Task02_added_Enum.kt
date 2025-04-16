package task

enum class DaypartTsk02 {MORNING, AFTERNOON, EVENING}

data class EventTsk02(
    val title: String,
    val description: String? = null,
    val daypart: DaypartTsk02,
    val duration: Int
)

fun main () {
    val event: EventTsk02 = EventTsk02(
        title = "Study Kotlin",
        description = "Commit to studying Kotlin at least 15 minutes per day",
        daypart = DaypartTsk02.EVENING,
        duration = 15
    )

    println(event)
}