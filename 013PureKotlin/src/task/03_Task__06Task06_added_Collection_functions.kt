package task

enum class DaypartTsk06 {MORNING, AFTERNOON, EVENING}

data class EventTsk06(
    val title: String,
    val description: String? = null,
    val dayPart: DaypartTsk06,
    val duration: Int
)

val eventsTsk06 = mutableListOf<EventTsk06>(
    EventTsk06(
        title = "Wake up",
        description = "Time to get up",
        dayPart = DaypartTsk06.MORNING,
        duration = 0
    ),
    EventTsk06(
        title = "Eat breakfast",
        dayPart = DaypartTsk06.MORNING,
        duration = 15
    ),
    EventTsk06(
        title = "Learn about Kotlin",
        dayPart = DaypartTsk06.AFTERNOON,
        duration = 30
    ),
    EventTsk06(
        title = "Practice Compose",
        dayPart = DaypartTsk06.AFTERNOON,
        duration = 60
    ),
    EventTsk06(
        title = "Watch latest DevBytes video",
        dayPart = DaypartTsk06.AFTERNOON,
        duration = 10
    ),
    EventTsk06(
        title = "Check out latest Android Jetpack library",
        dayPart = DaypartTsk06.EVENING,
        duration = 45
    )
)


fun main () {
    val event: EventTsk06 = EventTsk06(
        title = "Study Kotlin",
        description = "Commit to studying Kotlin at least 15 minutes per day",
        dayPart = DaypartTsk06.EVENING,
        duration = 15
    )

    println(event)
    println()
    println("Last even of the day: ${eventsTsk06.last().title}")
}