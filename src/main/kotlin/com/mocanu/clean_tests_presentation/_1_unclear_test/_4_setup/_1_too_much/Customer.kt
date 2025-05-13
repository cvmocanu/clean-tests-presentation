package com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_too_much

data class Customer(
    val id: Long,
    val name: String,
    val age: Int,
    val address: Address,
    val accountBalanceEuroCents: Long,
) {

    fun accountIsOverdrawn(): Boolean = (accountBalanceEuroCents < 0)

    fun isLegallyAllowedToWithdraw(): Boolean = (age >= 18)

}
