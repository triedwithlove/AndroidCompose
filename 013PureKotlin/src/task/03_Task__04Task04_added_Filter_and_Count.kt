package task

enum class DaypartTsk04 {MORNING, AFTERNOON, EVENING}

data class EventTsk04(
    val title: String,
    val description: String? = null,
    val dayPart: DaypartTsk04,
    val duration: Int
)

val eventsTsk04 = mutableListOf<EventTsk04>(
    EventTsk04(
        title = "Wake up",
        description = "Time to get up",
        dayPart = DaypartTsk04.MORNING,
        duration = 0
    ),
    EventTsk04(
        title = "Eat breakfast",
        dayPart = DaypartTsk04.MORNING,
        duration = 15
    ),
    EventTsk04(
        title = "Learn about Kotlin",
        dayPart = DaypartTsk04.AFTERNOON,
        duration = 30
    ),
    EventTsk04(
        title = "Practice Compose",
        dayPart = DaypartTsk04.AFTERNOON,
        duration = 60
    ),
    EventTsk04(
        title = "Watch latest DevBytes video",
        dayPart = DaypartTsk04.AFTERNOON,
        duration = 10
    ),
    EventTsk04(
        title = "Check out latest Android Jetpack library",
        dayPart = DaypartTsk04.EVENING,
        duration = 45
    ),
)

fun shortEvenTsk04(shortE: Int): Int {
    val numberOfShortEvent = eventsTsk04
        .filter { it.duration < shortE }
        .size
    return numberOfShortEvent
}

fun main () {
    val event: EventTsk04 = EventTsk04(
        title = "Study Kotlin",
        description = "Commit to studying Kotlin at least 15 minutes per day",
        dayPart = DaypartTsk04.EVENING,
        duration = 15
    )

    println(event)
    println()
    val shortEventNumber = shortEvenTsk04(60)
    println("You have $shortEventNumber short events")
}