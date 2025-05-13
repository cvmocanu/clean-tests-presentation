package com.mocanu.clean_tests_presentation._2_time_consuming_maintenance.x_2_intentionally_shared_fixture

import com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_irrelevant_detail.aValidCustomer
import com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_too_much.Customer
import org.assertj.core.api.WithAssertions
import org.junit.jupiter.api.Test

class IntentionallySharedFixture : WithAssertions {

    // [show] and explain the tests
    // [show] `customer` is a shared fixture, and this is
    //        done on purpose
    // [do  ] run the tests
    // [do  ] business change: change the healthy limit to 15_00
    // [do  ] re-run, note that the first test fails
    // [do  ] change the shared fixture
    // [do  ] re-run, note that now the second test fails
    // [tell] we could fix the second test, but there is a better way
    //        -> don't share fixtures: this also makes the tests clearer
    //        * keep the tests independent of each other
    // [do  ] refactor: each test with its own fixture

    private val customer: Customer =
        aValidCustomer()
            .copy(accountBalanceEuroCents = 10_00)

    @Test
    fun `account with at least 10 EUR is healthy`() {
        assertThat(customer.accountIsHealthy())
            .isTrue()
    }

    @Test
    fun `should be able to withdraw max amount`() {
        assertThat(customer.isAllowedToWithdraw(10_00 + Customer.OVERDRAFT_LIMIT))
            .isTrue()
    }

}
