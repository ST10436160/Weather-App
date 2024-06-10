package za.ac.iie.weatherapppracticum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainScreen : AppCompatActivity() {
    private lateinit var weatherData: Array<Double>
    private lateinit var weatherConditions: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the arrays
        weatherData = arrayOf(20.0, 22.0, 25.0, 28.0, 30.0, 28.0, 25.0)
        weatherConditions = arrayOf("Sunny", "Cloudy", "Rainy", "Sunny", "Cloudy", "Rainy", "Sunny")

        // Calculate the average temperature
        val averageTemperature = calculateAverageTemperature(weatherData)
        // Display the average temperature
        findViewById<TextView>(R.id.averageTemperature).text = "Average Temperature: $averageTemperature"

        // Set up the button to navigate to the detailed view screen
        findViewById<Button>(R.id.detailedViewButton).setOnClickListener {
            val intent = Intent(this, DetailedView::class.java)
            intent.putExtra("weatherData", weatherData)
            intent.putExtra("weatherConditions", weatherConditions)
            startActivity(intent)
        }

        // Set up the button to exit the app
        findViewById<Button>(R.id.exitButton).setOnClickListener {
            finish()
        }

        // Set up the button to clear data
        findViewById<Button>(R.id.clearDataButton).setOnClickListener {
            clearData()
        }
    }

    // Function to calculate the average temperature
    private fun calculateAverageTemperature(temperatures: Array<Double>): Double {
        var sum = 0.0
        for (temperature in temperatures) {
            sum += temperature
        }
        return sum / temperatures.size
    }

    // Function to clear the data
    private fun clearData() {
        // Clear the arrays
        weatherData = arrayOf()
        weatherConditions = arrayOf()
        // Reset the UI
        findViewById<TextView>(R.id.averageTemperature).text = ""
    }
}