package com.wasim.entrans

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.wasim.entrans.data.DataDisplayType
import com.wasim.entrans.viewmodels.MainViewModel


class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val verticalFragment = MainFragment.newInstance(viewModel, DataDisplayType.VERTICAL)
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerVertical, verticalFragment)
            .commit()

        val horizontalFragment =
            MainFragment.newInstance(viewModel, DataDisplayType.HORIZONTAL)
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerHorizontal, horizontalFragment)
            .commit()

        val listFragment = MainFragment.newInstance(viewModel, DataDisplayType.LIST)
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerList, listFragment)
            .commit()

        viewModel.fetchData()

    }
}
