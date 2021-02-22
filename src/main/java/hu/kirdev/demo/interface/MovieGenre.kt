package hu.kirdev.demo.`interface`

enum class MovieGenre {
    ACTION,
    ANIMATION,
    COMEDY,
    DRAMA,
    FANTASY,
    ROMANCE;

    override fun toString(): String {
        println(super.toString().toLowerCase().capitalize())
        return super.toString().toLowerCase().capitalize()
    }

}