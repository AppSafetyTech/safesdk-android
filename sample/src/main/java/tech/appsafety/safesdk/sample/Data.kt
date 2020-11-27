package tech.appsafety.safesdk.sample

import tech.appsafety.shared.Detection
import tech.appsafety.shared.Type

data class Data(val check: Boolean, val percentage: Int, val type: Type) {

    companion object {
        fun fromDetection(detection: Detection) =
            Data(
                check = detection.detected,
                type = detection.type,
                percentage = detection.confidence
            )
    }

    val title: String
        get() {
            return when (this.type) {
                Type.EMULATOR -> "Emulator"
                Type.MIRRORING -> "Display is mirrored"
                Type.MOCK_LOCATION -> "Fake Location"
                Type.MULTI_USERS -> "Multiple users in device"
                Type.VIRTUAL_CONTAINER -> "Virtual Container"
                Type.VPN -> "VPN enabled"
                Type.MULTIPLE_APP_INSTANCE -> "Multiple apps in device"
                Type.TAMPERED_PACKAGE -> "Tempered app"
                Type.ROOT -> "Rooted Device"
                Type.SAFETYNET -> "Google SafetyNet ($)"
            }
        }

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