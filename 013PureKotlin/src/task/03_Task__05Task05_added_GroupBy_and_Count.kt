package task

enum class DaypartTsk05 {MORNING, AFTERNOON, EVENING}

data class EventTsk05(
    val title: String,
    val description: String? = null,
    val dayPart: DaypartTsk05,
    val duration: Int
)

val eventsTsk05 = mutableListOf<EventTsk05>(
    EventTsk05(
        title = "Wake up",
        description = "Time to get up",
        dayPart = DaypartTsk05.MORNING,
        duration = 0
    ),
    EventTsk05(
        title = "Eat breakfast",
        dayPart = DaypartTsk05.MORNING,
        duration = 15
    ),
    EventTsk05(
        title = "Learn about Kotlin",
        dayPart = DaypartTsk05.AFTERNOON,
        duration = 30
    ),
    EventTsk05(
        title = "Practice Compose",
        dayPart = DaypartTsk05.AFTERNOON,
        duration = 60
    ),
    EventTsk05(
        title = "Watch latest DevBytes video",
        dayPart = DaypartTsk05.AFTERNOON,
        duration = 10
    ),
    EventTsk05(
        title = "Check out latest Android Jetpack library",
        dayPart = DaypartTsk05.EVENING,
        duration = 45
    )
)

fun groupEvenTsk05(shortE: Int): Map<DaypartTsk05, List<EventTsk05>> {
    val groupedEvent = eventsTsk05
        .groupBy { param ->
            param.dayPart
        }
    return groupedEvent
}


fun main () {
    val event: EventTsk05 = EventTsk05(
        title = "Study Kotlin",
        description = "Commit to studying Kotlin at least 15 minutes per day",
        dayPart = DaypartTsk05.EVENING,
        duration = 15
    )

    println(event)
    println()
    val groupedEvt = groupEvenTsk05(60)

    println("Morning ${(groupedEvt[DaypartTsk05.MORNING])?.size ?: 0} events")
    println("Afternoon ${groupedEvt[DaypartTsk05.AFTERNOON]?.size ?: 0} events")
    println("Evening ${groupedEvt[DaypartTsk05.EVENING]?.size ?: 0} events")

    println()
    println("For each")
    groupedEvt.forEach { entry ->
        println("${entry.key}: ${entry.value.size} events ")
    }
}