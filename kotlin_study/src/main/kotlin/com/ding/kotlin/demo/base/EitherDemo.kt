package com.ding.kotlin.demo.base

import arrow.core.Either
import arrow.core.computations.either

class EitherDemo {
	fun test(): Either<String,Int>{
		return either.eager { 1 }
	}
}
