package com.mocanu.clean_tests_presentation._1_unclear_test._5_execute.too_many

data class Person(
    val id: Long,
    val name: String,
    val age: Int,
) {

    companion object {
        val COMPARATOR: Comparator<Person> = Comparator.comparing<Person, String> { it.name }
            .thenComparingInt { it.age }
    }

}
