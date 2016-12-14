package com.example.max.chucknorristest.domain

import com.example.max.chucknorristest.presentation.showPhrase.MainContract
import rx.Observable
import rx.Scheduler

class GetJoke(val repository: MainContract.Model,
              subscribeOn: Scheduler,
              observeOn: Scheduler) :
        UseCase<GetJoke.Input, GetJoke.Output>(subscribeOn, observeOn) {

    override fun executeUseCase(values: Input?): Observable<Output> {
        return repository.requestPhrase().map{ Output(it.value) }
    }

    class Input() : UseCase.Input
    data class Output(val joke: String) : UseCase.Output

}