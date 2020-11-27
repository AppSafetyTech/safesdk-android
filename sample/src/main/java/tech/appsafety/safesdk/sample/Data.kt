package tech.appsafety.safesdk.sample


data class Data(val check: Boolean, val percentage: Int, val type: String) {

    companion object {

    }

    val title: String = "Unknown"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Data

        if (check != other.check) return false
        if (percentage != other.percentage) return false
        if (type != other.type) return false

        return true
    }

    override fun hashCode(): Int {
        var result = check.hashCode()
        result = 31 * result + percentage
        result = 31 * result + type.hashCode()
        return result
    }

}