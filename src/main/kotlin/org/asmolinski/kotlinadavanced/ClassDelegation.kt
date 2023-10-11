package org.asmolinski.kotlinadavanced

interface Animal {
    fun sound(): String
}

open class Dog: Animal {
    override fun sound() = "hau hau"
}

class PureBreedDogInheritance(val breed: String): Dog()
class PureBreedDogDelegate(val breed: String): Animal by Dog()

fun dogsExample() {
    val labrador = PureBreedDogInheritance("labrador retriever")
    val shepherd = PureBreedDogDelegate("owczarek podhalański")

    println("${labrador.breed} robi ${labrador.sound()}")
    println("${shepherd.breed} robi ${shepherd.sound()}")
}

class EnhancedList<T>(private val implementation: List<T>): List<T> by implementation {
    fun splitInHalf() = Pair(implementation.subList(0, size/2), implementation.subList(size/2, size))
}

fun listExample() {
    val enhancedList = EnhancedList(listOf(1,2,3,4,5,6))
    // works like regular list
    println(enhancedList.size)
    println(enhancedList.contains(1))
    // but with extra features!
    println(enhancedList.splitInHalf())
}

fun main() {
    dogsExample()
    listExample()
}