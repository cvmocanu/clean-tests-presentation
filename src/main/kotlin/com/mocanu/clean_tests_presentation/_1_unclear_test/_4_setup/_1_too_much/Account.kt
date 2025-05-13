package com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_too_much

class Account(
    private val customer: Customer,
) {

    fun isOverdrawn(): Boolean = (customer.accountBalanceEuroCents < 0)

}
