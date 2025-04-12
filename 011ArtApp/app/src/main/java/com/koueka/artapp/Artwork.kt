package com.koueka.artapp

class Artwork (
    val imageID: Int,
    val title: String,
    val description: String,
    val author: String,
    val year: String
)

fun buildArtworkList(): List<Artwork> {

    return listOf(
        Artwork(
            imageID = R.drawable.loom_01,
            title = "Navy B.",
            description = "Training material and result obtained with navy army colors red, blue, white",
            author = "Willie L.",
            year = " (2023)"),
        Artwork(
            imageID = R.drawable.loom_02,
            title = "Wilder B.",
            description = "Inspired by the night and reflect great on the other colors, blue, yellow, orange",
            author = "Tried W.",
            year = " (2015)"),
        Artwork(
            imageID = R.drawable.loom_03,
            title = "Triple Layer B.",
            description = "Mirrored light on a base of light blue with yellow and orange grasp, and materials",
            author = "Withlove T.",
            year = " (2012)"),
        Artwork(
            imageID = R.drawable.loom_04,
            title = "Blue Blue B.",
            description = "The blue for the sky and the violet for the cheer. It uses less material",
            author = "Beth IL",
            year = " (2013)"),
        Artwork(
            imageID = R.drawable.loom_05,
            title = "Wisey B.",
            description = "The light from the White and the diversity of the other tie everything together",
            author = "Elyjah T.",
            year = " (2017)")
    );
}
