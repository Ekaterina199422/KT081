import java.time.LocalDateTime
import java.time.ZoneOffset

data class Note(
        var title: String? = null,

        override val id: Int = 1,
        override val ownerId: Int = 1,
        override var text: String,
        override var isDeleted: Boolean = false,
        override val date: Long = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC),
        override val comments: MutableList<Comment> = mutableListOf<Comment>(),
) : Notable<MutableList<Note>>, Commentable {

    override fun addTo(dest: MutableList<Note>) {
        if (dest.isEmpty()) dest.add(this.copy(id = 1))
        else dest.add(this.copy(id = dest.last().id + 1))
    }

    fun edit(title: String, text: String) {
        this.title = title
        this.text = text
    }


}
