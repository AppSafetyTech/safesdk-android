package tech.appsafety.shared

import androidx.annotation.Keep

@Keep
data class Detection(
    val detected: Boolean,
    val type: Type,
    val confidence: Int
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Detection

        if (detected != other.detected) return false
        if (type != other.type) return false
        if (confidence != other.confidence) return false

        return true
    }

    override fun hashCode(): Int {
        var result = detected.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + confidence
        return result
    }

}