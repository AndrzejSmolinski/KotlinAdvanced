package org.asmolinski.kotlinadavanced

import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty
import java.time.Instant

class LazyHolder {
    val value: String by lazy {
        println(Instant.now().toString() + " inicjalizacja")
        "aaa"
    }
}

// line 43 in Lazy.kt

private fun lazyPropertyExample() {
    val lazyHolder = LazyHolder()
    println(Instant.now().toString() + " stworzony obiekt")
    Thread.sleep(1000)
    println(lazyHolder.value)
}

class ObservableHolder(initial: Int) {

    var value: Int by Delegates.observable(initial) {
            property, oldValue, newValue -> println("${property.name} changed value from $oldValue to $newValue")
    }
}

private fun observablePropertyExample() {
   val observableHolder = ObservableHolder(0)
   observableHolder.value = 1
   observableHolder.value += 10
   observableHolder.value--
}

data class InvocationCounter(
    var getCounter: Int = 0,
    var setCounter: Int = 0
)

class CountInvocationDelegate<T>(private var value: T, private val counter: InvocationCounter): ReadWriteProperty<Any, T> {

    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        counter.getCounter++
        return value
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        counter.setCounter++
        this.value = value
    }
}

class CustomDelegateHolder(initialValue: Int) {
    private val counter = InvocationCounter()
    var value: Int by CountInvocationDelegate(initialValue, counter)

    // property delegation
    val getCount by counter::getCounter
    val setCount by counter::setCounter
}

fun customDelegateExample() {
    val holder = CustomDelegateHolder(0)
    holder.value = 1
    holder.value = 2
    holder.value = 5
    holder.value = 4
    println(holder.value)

    println("property was set ${holder.setCount} times")
    println("property was get ${holder.getCount} times")
}

fun main() {
    lazyPropertyExample()
    observablePropertyExample()
    customDelegateExample()
}
