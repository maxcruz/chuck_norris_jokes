package com.example.max.chucknorristest.domain

import rx.Observable
import rx.Scheduler

/**
 * This abstract class represents an execution unit for different use cases. Any use case in the
 * application should implement this contract. Use cases are the entry point to the domain layer.
 *
 * @param <I> the request type
 * @param <O> the response parameter
 */
abstract class UseCase<in I : UseCase.Input, O : UseCase.Output>(subscribeOn: Scheduler,
                                                                 observeOn: Scheduler) {

    val subscribeOn: Scheduler
    val observeOn: Scheduler

    /**
     * Only receive the scheduler in the constructor
     */
    init {
        this.subscribeOn = subscribeOn
        this.observeOn = observeOn
    }

    /**
     * Method to execute the use case
     */
    fun execute(requestValues: I? = null): Observable<O> {
        return executeUseCase(requestValues).subscribeOn(subscribeOn).observeOn(observeOn)
    }

    /**
     * Abstract method to implement the use case login
     */
    protected abstract fun executeUseCase(values: I?): Observable<O>

    /**
     * Wrapper for parameters
     */
    interface Input {}

    /**
     * Wrapper for results
     */
    interface Output {}

}