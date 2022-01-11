package com.example.betway2demo.ui.main

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.betway2demo.R
import com.example.betway2demo.di.ViewModelFactory
import com.example.betway2demo.ui.BaseActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory<MainViewModel>
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = viewModelFactory.get()
        viewModel.getWebUrl()
        viewModel.webViewUrl.observe(this, Observer {
            tv_url.text = it
        })
    }
}