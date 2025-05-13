package com.mocanu.clean_tests_presentation._1_unclear_test._5_execute.multiple

import com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_irrelevant_detail.aValidCustomer
import com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_too_much.Customer
import org.assertj.core.api.WithAssertions
import org.junit.jupiter.api.Test

class MultipleSutExecutions : WithAssertions {

    // [tell] `accountIsOverdrawn` should have its own tests

    @Test
    fun `a legal adult should be legally allowed to withdraw`() {
        val customer: Customer = aValidCustomer()
            .copy(
                accountBalanceEuroCents = 1,
                age = 18,
            )

        assertThat(customer.accountIsOverdrawn())
            .isFalse()

        assertThat(customer.isLegallyAllowedToWithdraw())
            .isTrue()
    }


    // [tell] multiple SUT executions => it's not clear what
    //        production code is being tested
    // [tell] extract setup code to a fixture utility
    // [do  ] replace setup code with `PersonFixture.givenThePersonTableContainsASingleValidPerson()`
    // [tell] now it's clear what the test is checking
    // [tell] if `PersonRepository.insert` is buggy, multiple tests will fail
    //        (this and the test for the `insert` method);
    //        if the DB schema changes a lot, this is an acceptable downside
    //        (less test code to update)
    //
    // [tell] note a pattern: we introduced test data builders and
    //        fixture utilities -
    //        - create whatever abstractions you need to keep the test
    //          code clean
    //        - treat your test code with the same respect you treat your
    //          production code

    @Test
    fun `should count persons correctly`() {
        PersonRepository.deleteAllCascade()
        PersonRepository.insert(aValidPerson())

        assertThat(PersonRepository.count())
            .isEqualTo(1)
    }

}
