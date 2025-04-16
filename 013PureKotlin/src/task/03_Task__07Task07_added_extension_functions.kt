package task

enum class DayPartTsk07 {MORNING, AFTERNOON, EVENING}

data class EventTsk07(
    val title: String,
    val description: String? = null,
    val dayPart: DayPartTsk07,
    val duration: Int
)

val eventsTsk07 = mutableListOf<EventTsk07>(
    EventTsk07(
        title = "Wake up",
        description = "Time to get up",
        dayPart = DayPartTsk07.MORNING,
        duration = 0
    ),
    EventTsk07(
        title = "Eat breakfast",
        dayPart = DayPartTsk07.MORNING,
        duration = 15
    ),
    EventTsk07(
        title = "Learn about Kotlin",
        dayPart = DayPartTsk07.AFTERNOON,
        duration = 30
    ),
    EventTsk07(
        title = "Practice Compose",
        dayPart = DayPartTsk07.AFTERNOON,
        duration = 60
    ),
    EventTsk07(
        title = "Watch latest DevBytes video",
        dayPart = DayPartTsk07.AFTERNOON,
        duration = 10
    ),
    EventTsk07(
        title = "Check out latest Android Jetpack library",
        dayPart = DayPartTsk07.EVENING,
        duration = 45
    )
)

val EventTsk07.durationOfEvent: String
    get() = if (duration < 60) {
        "short"
    } else {
        "long"
    }

fun main () {
    val event: EventTsk07 = EventTsk07(
        title = "Study Kotlin",
        description = "Commit to studying Kotlin at least 15 minutes per day",
        dayPart = DayPartTsk07.EVENING,
        duration = 15
    )

    println(event)
    println()
    println("Duration of the event of the day: ${event.durationOfEvent}")


    println()
    println("Duration of the first event of the day: ${eventsTsk07.first().durationOfEvent}")

}