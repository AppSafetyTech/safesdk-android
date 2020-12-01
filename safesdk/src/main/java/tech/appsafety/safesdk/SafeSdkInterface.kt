package tech.appsafety.safesdk

import androidx.annotation.Keep
import kotlinx.coroutines.flow.Flow
import tech.appsafety.shared.Detection
import tech.appsafety.shared.DetectionObserver

@Keep
interface SafeSdkInterface {
    var observer: Flow<DetectionObserver>
    var packageInfo: Flow<Pair<String, List<String>>>
    var detectTrigger: Flow<Boolean>
    var detectTriggerWithCallback: Flow<ResultsCallback>
    var logging: Flow<Boolean>

    fun setObserver(value: DetectionObserver)

    fun setPackageInfo(originalSignature: String, stores: List<String>)

    fun detectAll(results: ResultsCallback = null)

    fun logging(enable: Boolean)
}

typealias ResultsCallback = ((Collection<Detection>) -> Unit)?

