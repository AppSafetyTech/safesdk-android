package tech.appsafety.shared

import androidx.annotation.Keep

@Keep
interface DetectionObserver {

    fun onDetectionChanged(detections: Collection<Detection>)
}