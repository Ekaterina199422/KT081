import java.lang.RuntimeException

interface Commentable {
    val comments: MutableList<Comment>

    fun getCommentById(id: Int): Comment {
        for (comment in comments) {
            if (comment.id == id && !comment.isDeleted) return comment
        }
        throw CommentIdNotFoundException("Comment Id not found!")
    }
    fun getCommentByIdForced(id: Int): Comment {
        for (comment in comments) {
            if (comment.id == id) return comment
        }
        throw CommentIdNotFoundException("Comment Id not found!")
    }

}

class CommentIdNotFoundException(message: String) : RuntimeException(message)