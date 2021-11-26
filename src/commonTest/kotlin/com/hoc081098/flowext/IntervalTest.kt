package com.hoc081098.flowext

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.take
import kotlin.test.Test

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class IntervalTest {
  @Test
  fun run() = suspendTest {
    interval(100, 200)
      .take(20)
      .test((0L until 20).map { Event.Value(it) } + Event.Complete)
  }
}