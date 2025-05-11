package com.mocanu.clean_tests_presentation.x_04_assertion_too_narrow

data class Person(
    val name: String,
    val age: Int,
) {

    companion object {
        val COMPARATOR: Comparator<Person> = Comparator.comparing<Person, String> { it.name }
            .thenComparingInt { it.age }
    }

}

fun main() {
    println()
}
