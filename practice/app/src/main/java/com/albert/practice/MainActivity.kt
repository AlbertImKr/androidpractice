package com.albert.practice

import android.os.Bundle
import android.os.SystemClock
import android.view.KeyEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.albert.practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var initTime = 0L
    private var pauseTime = 0L

    /**
     * Initializes the activity's layout and sets up the chronometer controls.
     *
     * This method inflates the UI using view binding and assigns click listeners to the start, stop, and reset buttons:
     * - **Start Button**: Sets the chronometer's base to the current elapsed time plus any pause offset, starts the chronometer, and updates the button states.
     * - **Stop Button**: Calculates the pause duration from the chronometer's base, stops the chronometer, and updates the button states.
     * - **Reset Button**: Resets the chronometer's base to the current elapsed time, clears the pause duration, stops the chronometer, and restores the button states.
     *
     * @param savedInstanceState The saved state of the activity, if any.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.startButton.setOnClickListener {
            binding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
            binding.chronometer.start()

            binding.stopButton.isEnabled = true
            binding.resetButton.isEnabled = true
            binding.startButton.isEnabled = false
        }

        binding.stopButton.setOnClickListener {
            pauseTime = binding.chronometer.base - SystemClock.elapsedRealtime()
            binding.chronometer.stop()

            binding.stopButton.isEnabled = false
            binding.resetButton.isEnabled = true
            binding.startButton.isEnabled = true
        }

        binding.resetButton.setOnClickListener {
            binding.chronometer.base = SystemClock.elapsedRealtime()
            pauseTime = 0L
            binding.chronometer.stop()

            binding.stopButton.isEnabled = false
            binding.resetButton.isEnabled = false
            binding.startButton.isEnabled = true
        }

    }

    /**
     * Intercepts back key press events to require a double-tap confirmation before exiting.
     *
     * When the back button is pressed, if the elapsed time since the last recorded press is less than 3 seconds,
     * a toast message is displayed to prompt the user to press again to exit, and the event is consumed.
     * If not, the default key handling is executed.
     *
     * @param keyCode the code of the key that was pressed.
     * @param event the key event, which may be null.
     * @return true if the back press event is handled by displaying the toast; otherwise, the result of the superclass implementation.
     */
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && SystemClock.elapsedRealtime() - initTime < 3000) {
            Toast.makeText(this, "종료하려면 한 번 더 누르세요", Toast.LENGTH_SHORT).show()
            initTime = System.currentTimeMillis()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}