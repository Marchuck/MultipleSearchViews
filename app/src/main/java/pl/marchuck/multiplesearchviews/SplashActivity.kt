package pl.marchuck.multiplesearchviews

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val currentIntent = intent
        val newIntent = Intent(this, MainActivity::class.java).apply {
            if (currentIntent.data != null) {
                data = currentIntent.data
            }
        }
        startActivity(newIntent)
        finish()
    }
}