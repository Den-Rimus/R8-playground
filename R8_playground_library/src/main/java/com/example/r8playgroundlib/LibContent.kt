package com.example.r8playgroundlib

class Alice
class Bob

class SomeOtherClass<out T, out E>

interface BaseFoo<D, E> {
   fun handle(result: SomeOtherClass<D, E>): Boolean
}

class Bar {
   interface DerivedFoo : BaseFoo<Alice, Bob>
}
