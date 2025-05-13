package com.mocanu.clean_tests_presentation._2_time_consuming_maintenance._3_mocks._2_testing_implementation_details

class Order(
    private val orderPriceCalculator: OrderPriceCalculator,
) {

    private val lines = mutableListOf<OrderLine>()
    private var discount: Int = 0

    fun addLine(line: OrderLine) {
        lines += line
    }

    fun applyDiscount(discount: Int) {
        require(discount > 0) { "discount must be positive, but got $discount" }

        this.discount = discount
    }

    fun calculateTotalPrice(): Int =
        orderPriceCalculator.calculateTotalPrice(lines, discount)
}
