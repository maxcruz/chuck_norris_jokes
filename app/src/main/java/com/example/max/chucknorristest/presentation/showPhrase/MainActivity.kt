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
import com.example.max.chucknorristest.R
import com.example.max.chucknorristest.data.ChuckNorrisService
import com.example.max.chucknorristest.data.client.ServiceFactory
import com.example.max.chucknorristest.domain.GetJoke
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity(), MainContract.View {

    @BindView(R.id.textViewPhrase)
    lateinit var textViewPhrase: TextView
    @BindView(R.id.button)
    lateinit var button: Button
    @BindView(R.id.progressBar)
    lateinit var progressBar: ProgressBar

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
        val chuckNorrisService = ServiceFactory.create(ChuckNorrisService::class.java,
                ChuckNorrisService.SERVICE_ENDPOINT)
        val repository = MainRepository(chuckNorrisService)
        val observeOn = AndroidSchedulers.mainThread()
        val subscribeOn = Schedulers.io()
        val jokeUseCase = GetJoke(repository, subscribeOn, observeOn)
        presenter = MainPresenter(this, jokeUseCase)
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
