package com.mocanu.clean_tests_presentation._2_time_consuming_maintenance._3_mocks._2_testing_implementation_details

class OrderPriceCalculator {

    fun calculateTotalPrice(
        lines: List<OrderLine>,
        discount: Int,
    ): Int {
        var totalPrice = 0

        lines.forEach {
            totalPrice += it.perItemPrice * it.quantity
        }

        totalPrice -= discount

        return totalPrice
    }

}
