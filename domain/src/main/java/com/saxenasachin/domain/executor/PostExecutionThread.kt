package com.saxenasachin.domain.executor

import io.reactivex.Scheduler

/**
Created by Sachin Saxena on 19/06/22.
 */
interface PostExecutionThread {
    val scheduler: Scheduler
}
