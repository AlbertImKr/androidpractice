package com.albert.ch09

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.albert.ch09.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    /**
     * Initializes the activity by inflating the layout using view binding and setting the content view.
     *
     * @param savedInstanceState If non-null, contains the data most recently supplied by the activity's previous state.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    /**
     * Inflates the options menu for the activity.
     *
     * This method populates the action bar by inflating the menu defined in R.menu.menu_main
     * into the provided menu.
     *
     * @param menu the options menu to which items will be added.
     * @return true to display the menu.
     */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    /**
     * Handles selection events from the options menu.
     *
     * When the settings option (R.id.action_settings) is selected, this method returns true,
     * indicating the event has been handled. For all other menu items, it delegates to
     * the superclass implementation.
     *
     * @param item the selected menu item.
     * @return true if the selected menu action is handled; otherwise, the result of the superclass method.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    /**
     * Handles the Up navigation action.
     *
     * Retrieves the NavController for the associated navigation host fragment and attempts to navigate up
     * using the AppBarConfiguration. If the navigation is not handled by the NavController, the default
     * behavior from the superclass is executed.
     *
     * @return `true` if the navigation action was successfully handled, `false` otherwise.
     */
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}