package ru.zharinov.gng

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import ru.zharinov.gng.databinding.ActivitySpalshBinding


class SplashActivity : AppCompatActivity() {
    lateinit var bindingLayout: ActivitySpalshBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingLayout = ActivitySpalshBinding.inflate(layoutInflater)
        setContentView(bindingLayout.root)

        val mHandler = Handler()
        mHandler.postDelayed(goToMainActivity, 1000)


    }

    private val goToMainActivity = Runnable {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}