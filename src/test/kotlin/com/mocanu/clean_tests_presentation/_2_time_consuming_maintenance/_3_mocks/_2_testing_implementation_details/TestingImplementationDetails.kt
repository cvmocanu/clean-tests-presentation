package com.mocanu.clean_tests_presentation._2_time_consuming_maintenance._3_mocks._2_testing_implementation_details

import org.assertj.core.api.WithAssertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

class TestingImplementationDetails : WithAssertions {

    // [tell] using mocks to test implementation details
    // [show] the production code (OrderLine, Order, OrderPriceCalculator)
    // [show] and explain the first test
    // [tell] people do this kind of stuff to test classes in isolation
    // [tell] sometimes, people have test with mocks returning other mocks
    // [show] and explain the second test
    // [tell] note that it's much easier to understand than the first
    // [tell] the second test is also much more refactor-friendly when changing implementation details

    // [tell] The worst problem with mock-based testing: testing implementation details.
    //        Your tests should not fail if you change some implementation detail,
    //        but your production code does the same thing as before (e.g.
    //        you switch frameworks).
    //        Pragmatic reason: supporting your refactoring
    //
    //        mockist vs classicist
    //        cripples refactoring (prod code death) vs more than one test brakes when you introduce a bug
    //        I'm a convinced classicist

    @Test
    fun `should calculate total price correctly - mocks`() {
        val orderPriceCalculator = mock(OrderPriceCalculator::class.java)
        val order = Order(orderPriceCalculator)

        val line1 = OrderLine(productName = "Keyboard", perItemPrice = 50, quantity = 1)
        order.addLine(line1)

        val line2 = OrderLine(productName = "USB flash drive", perItemPrice = 10, quantity = 3)
        order.addLine(line2)

        val discount = 10
        order.applyDiscount(discount)

        `when`(orderPriceCalculator.calculateTotalPrice(listOf(line1, line2), 10))
            .thenReturn(13)

        assertThat(order.calculateTotalPrice())
            .isEqualTo(13)

        verify(orderPriceCalculator)
            .calculateTotalPrice(
                lines = listOf(line1, line2),
                discount = 10
            )
    }

    @Test
    fun `should calculate total price correctly - results`() {
        // NOTE: using the real OrderPriceCalculator
        val order = Order(OrderPriceCalculator())

        val line1 = OrderLine(productName = "Keyboard", perItemPrice = 50, quantity = 1)
        order.addLine(line1)

        val line2 = OrderLine(productName = "USB flash drive", perItemPrice = 10, quantity = 3)
        order.addLine(line2)

        val discount = 10
        order.applyDiscount(discount)

        assertThat(order.calculateTotalPrice())
            .isEqualTo(70)
    }

}
