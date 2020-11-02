interface Notable<D> {
    val id: Int
    val ownerId: Int
    val date: Long
    var text: String
    var isDeleted: Boolean

    fun addTo(dest: D)

    fun delete() {
        isDeleted = true
    }

    fun restore() {
        isDeleted = false
    }


}


