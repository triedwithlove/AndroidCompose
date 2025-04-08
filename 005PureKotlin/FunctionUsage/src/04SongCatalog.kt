

class Song(
    val title: String,
    val artist: String,
    val year_published: Int,
    val play_count: Int
) {

    val is_popular: Boolean
        get() = play_count >= 1000

    fun printSongInfo() {
        println("[$title], performed by [$artist], was released in [$year_published]")
    }
}

fun main() {
    val song: Song = Song("Connect 2022", "Beth. ILYEA", 2022, 100)
    song.printSongInfo()
    println("song is popular ${song.is_popular}")
}