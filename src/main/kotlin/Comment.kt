import java.time.LocalDateTime
import java.time.ZoneOffset

data class Comment(

        override val id: Int = 1,
        override val ownerId: Int = 1,
        override var text: String,
        override var isDeleted: Boolean = false,
        override val date: Long = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC),
        override val comments: MutableList<Comment> = mutableListOf<Comment>(),
) : Notable<MutableList<Comment>>, Commentable {

    override fun addTo(dest: MutableList<Comment>) {
        if (dest.isEmpty()) dest.add(this.copy(id = 1))
        else dest.add(this.copy(id = dest.last().id + 1))
    }

    fun edit(text: String) {
        this.text = text
    }


}

