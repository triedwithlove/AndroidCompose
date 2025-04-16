package task

enum class DaypartTsk03 {MORNING, AFTERNOON, EVENING}

data class EventTsk03(
    val title: String,
    val description: String? = null,
    val dayPart: DaypartTsk03,
    val duration: Int
)

val eventsTsk03 = mutableListOf<EventTsk03>(
    EventTsk03(
        title = "Wake up",
        description = "Time to get up",
        dayPart = DaypartTsk03.MORNING,
        duration = 0
    ),
    EventTsk03(
        title = "Eat breakfast",
        dayPart = DaypartTsk03.MORNING,
        duration = 15
    ),
    EventTsk03(
        title = "Learn about Kotlin",
        dayPart = DaypartTsk03.AFTERNOON,
        duration = 30
    ),
    EventTsk03(
        title = "Practice Compose",
        dayPart = DaypartTsk03.AFTERNOON,
        duration = 60
    ),
    EventTsk03(
        title = "Watch latest DevBytes video",
        dayPart = DaypartTsk03.AFTERNOON,
        duration = 10
    ),
    EventTsk03(
        title = "Check out latest Android Jetpack library",
        dayPart = DaypartTsk03.EVENING,
        duration = 45
    ),
)

fun main () {
    val event: EventTsk03 = EventTsk03(
        title = "Study Kotlin",
        description = "Commit to studying Kotlin at least 15 minutes per day",
        dayPart = DaypartTsk03.EVENING,
        duration = 15
    )

    println(event)
    println()
    eventsTsk03.forEach {
        println("${it}")
    }
}