package tech.appsafety.safesdk.sample

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tech.appsafety.safesdk.SafeSdkInterface
import tech.appsafety.safesdk.SafeSdkManager
import tech.appsafety.shared.Detection
import tech.appsafety.shared.DetectionObserver

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var emptyText: TextView
    private lateinit var progressBar: ProgressBar
    private val adapter = CustomAdapter()
    private lateinit var safe: SafeSdkInterface

    companion object {
        private const val MY_PERMISSIONS_REQUEST_LOCATION = 100
        private const val mockSign = "b4JTGzI0sY1nCWXEOsDTWN6NrEA="
        private val defaultStore = listOf("com.android.vending")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkForLocationPermission()
        recyclerView = findViewById(R.id.recycler_view)
        emptyText = findViewById(R.id.empty)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        progressBar = findViewById(R.id.progress_bar)
        progressBar.visibility = View.VISIBLE
        initSafeSdk()
    }

    private fun initSafeSdk() {
        safe = SafeSdkManager
        safe.logging(true)

        // Set info for tampered application detection (optional)
        //safe.setPackageInfo(mockSign, defaultStore)

        //trigger once and wait for data
        //safe.detectAll(::data)

        //or set a Global Observer to listen to data change events
        safe.setObserver(object : DetectionObserver {
            override fun onDetectionChanged(detections: Collection<Detection>) {
                data(detections)
            }
        })
    }

    private fun data(detections: Collection<Detection>) {
        progressBar.visibility = View.INVISIBLE
        adapter.dataSet = detections.map { Data.fromDetection(it) }
        emptyText.visibility = if (detections.isEmpty()) View.VISIBLE else View.INVISIBLE
    }

    private fun checkForLocationPermission() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            checkLocationPermission()
        }
    }

    private fun checkLocationPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED
            ) {
                this.requestPermissions(
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    MY_PERMISSIONS_REQUEST_LOCATION
                )
                return
            }
        }
    }
}