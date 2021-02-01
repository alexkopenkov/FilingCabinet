package com.example.filingcabinet.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.filingcabinet.R
import com.example.filingcabinet.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewBinding: ActivityMainBinding by viewBinding(R.id.ac_container)

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup App Bar with NavigationUI
        val navController = findNavController(R.id.fragment_container)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        attachObservers()
    }

    private fun attachObservers() {

        lifecycleScope.launchWhenStarted {
            viewModel.isLoading.collect {
                viewBinding.progress.progressView.isVisible = it
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.isError.collect {
                Toast.makeText(this@MainActivity, getString(R.string.error), Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.fragment_container).navigateUp()
    }

}