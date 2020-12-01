package tech.appsafety.safesdk

import androidx.annotation.Keep
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf
import tech.appsafety.shared.DetectionObserver

@Keep
object SafeSdkManager : SafeSdkInterface {

    override var observer: Flow<DetectionObserver> = emptyFlow()
    override var packageInfo: Flow<Pair<String, List<String>>> = emptyFlow()
    override var detectTrigger: Flow<Boolean> = emptyFlow()
    override var detectTriggerWithCallback: Flow<ResultsCallback> = emptyFlow()
    override var logging: Flow<Boolean> = emptyFlow()

    override fun setObserver(value: DetectionObserver) {
        observer = flowOf(value)
    }

    override fun setPackageInfo(originalSignature: String, stores: List<String>) {
        packageInfo = flowOf(Pair(originalSignature, stores))
    }

    override fun detectAll(results: ResultsCallback) {
        if (results != null) {
            detectTriggerWithCallback = flowOf(results)
        } else {
            detectTrigger = flowOf(true)
        }
    }

    override fun logging(enable: Boolean) {
        logging = flowOf(enable)
    }
}

