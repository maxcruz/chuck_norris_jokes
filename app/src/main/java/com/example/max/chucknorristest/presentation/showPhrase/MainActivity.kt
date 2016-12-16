package com.example.max.chucknorristest.presentation.showPhrase

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.max.chucknorristest.ChuckNorrisApplication
import com.example.max.chucknorristest.R
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    @BindView(R.id.textViewPhrase)
    lateinit var textViewPhrase: TextView
    @BindView(R.id.button)
    lateinit var button: Button
    @BindView(R.id.progressBar)
    lateinit var progressBar: ProgressBar

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        setupInjection()
        presenter.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    private fun setupInjection() {
        (application as ChuckNorrisApplication).getMainComponent(this).inject(this)
    }

    @OnClick(R.id.button)
    fun onClickButton() {
        presenter.getPhrase()
    }

    override fun disableButton(enabled: Boolean) {
        button.isEnabled = enabled
    }

    override fun showProgress(show: Boolean) {
        progressBar.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun putPhrase(message: String) {
        textViewPhrase.text = message
    }

    override fun showError() {
        Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show()
    }

}
