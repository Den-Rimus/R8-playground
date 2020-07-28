package com.example.r8playgroundlib

class Alice
class Bob

sealed class SomeOtherClass<out T, out E> {
   class Success<T>(val value: T) : SomeOtherClass<T, Nothing>()
   class Failure<E>(val error: E) : SomeOtherClass<Nothing, E>()
}

interface BaseFoo<D, E> {
   fun handle(result: SomeOtherClass<D, E>): Boolean
}

class Bar {
   interface DerivedFoo : BaseFoo<Alice, Bob>
}
