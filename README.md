# Android Safe SDK 
[ ![Download](https://api.bintray.com/packages/appsafety/safesdk/safesdk/images/download.svg?version=0.4.4) ](https://bintray.com/appsafety/safesdk/safesdk/0.4.4/link)[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)

An easy to use Android library for keeping away suspicious, fraud-oriented activities. The SDK uses vital device sensor and information with minimal permission requirements in order to detect and report potential threats, so the app developer can immediately determine the next best move!

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
        }}
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
- `detected`: A `Boolean` value that represents the detection status.
- `type`: The detection [Type](https://github.com/AppSafetyTech/safesdk-android/blob/main/safesdk/src/main/java/tech/appsafety/shared/Type.kt)
- `confidence`: The level of confidence about the detection's status. If `0` then the detection has failed.
# Features
#### Detection supported
|     Detection     	|  Supported  	|                    Description                    	|
|:-----------------:	|:----------:	|:-------------------------------------------------:	|
|        Root       	|     yes    	|      Administrator permissions (root access)      	|
|      Emulator     	|    todo    	|                 Not a real device                 	|
|        VPN        	|     yes    	|              Virtual Private Network              	|
| Virtual Container 	|    todo    	|        Application is running in a sandbox        	|
| Display Mirroring 	|    todo    	|        Display mirroring by another source        	|
|   Mock Location   	|     yes    	| Another app is manipulating the device's location 	|
|  Multiple  Users  	|     yes    	|   More than one users are registered in the device	|
|    Cloned  App    	|     yes    	|  The app has multiple instances in current device 	|
|  Tampered Package 	|     yes    	|        Verify the integrity of the package        	|
|   Bot Patterns      	|     todo    	|        Determine non-human display interactions      	|

# Issues
We use [Github issues](https://github.com/AppSafetyTech/safesdk-android/issues) to track bugs and enhancements.
- If you find a bug please fill out an issue report. Provide as much information as possible.
- If you think of a great idea please fill out an issue as a proposal for your idea.
