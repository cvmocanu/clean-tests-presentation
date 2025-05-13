package com.mocanu.clean_tests_presentation._1_unclear_test._3_aggregate_test

import com.mocanu.clean_tests_presentation._1_unclear_test._2_bad_test_name.MathOperations
import org.assertj.core.api.WithAssertions
import org.intellij.lang.annotations.Language
import org.junit.jupiter.api.Test

class AggregateTest : WithAssertions {

    // * [tell] attempting to give it a proper name would reveal
    //          that we actually have 2 tests
    // * [tell] just split into 2 tests
    // * [tell] in some cases, it's not so obvious
    // * [tell] separate tests for parsing strings and numbers
    // * [tell] a single "complex" test, to check interaction between
    //          different parts of the code, parsing different things

    @Test
    fun test1() {
        assertThat(MathOperations.add(1, 2))
            .isEqualTo(3)

        assertThat(MathOperations.subtract(3, 1))
            .isEqualTo(2)
    }

    @Test
    fun `should parse JSON correctly`() {
        @Language("JSON")
        val serializedJson = """
            {
              "name": "John Doe",
              "age": 21
            }
        """.trimIndent()

        assertThat(JsonParser.parseJson(serializedJson))
            .isEqualTo(
                mapOf(
                    "name" to "John Doe",
                    "age" to 13,
                )
            )
    }

}
