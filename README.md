# Android Safe SDK 
[ ![Download](https://api.bintray.com/packages/appsafety/safesdk/safesdk/images/download.svg?version=0.4.4) ](https://bintray.com/appsafety/safesdk/safesdk/0.4.4/link)[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)

An easy to use Android library for keeping away the suspicious fraud oriented activities. The SDK uses vital device sensors and information with minimal permission requirements in order to report any threat detection so the app developer can immediately determine the best next move!

# Installation
Safe SDK is available on `jcenter()`.

Add the following dependency to your `build.gradle` file:

```gradle
dependencies {
    implementation 'tech.appsafety:safesdk:{latest_version}'
}
```
# Usage
#### Manually request for detections
```kotlin
 SafeSdkManger.detectAll { detections -> {
                // Collection of detections
            }
        }
})
```
#### Subscribe for detection changes
```kotlin
 SafeSdkManger.setObserver(object : DetectionObserver {
            override fun onDetectionChanged(detections: Collection<Detection>) {
                 // Collection of detections
            }
})
```
Both ways are returning a collection of [Detections](https://github.com/AppSafetyTech/safesdk-android/blob/main/safesdk/src/main/java/tech/appsafety/shared/Detection.kt) that includes:
1. `detected`: A `Boolean` value that represences the detection status.
2. `type`: The detection [Type](https://github.com/AppSafetyTech/safesdk-android/blob/main/safesdk/src/main/java/tech/appsafety/shared/Type.kt)
3. `confidence`: The level of confidence about the detection's status. If `0` then the detection has failed.



