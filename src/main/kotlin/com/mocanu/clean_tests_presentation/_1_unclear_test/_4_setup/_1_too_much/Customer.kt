package com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_too_much

data class Customer(
    val id: Long,
    val name: String,
    val age: Int,
    val address: Address,
    val accountBalanceEuroCents: Long,
) {

    fun accountIsOverdrawn(): Boolean =
        (accountBalanceEuroCents < 0)

    fun accountIsHealthy(): Boolean =
        (accountBalanceEuroCents >= 10_00)

    fun isLegallyAllowedToWithdraw(): Boolean = (age >= 18)

    fun isAllowedToWithdraw(amountInEuroCents: Long): Boolean =
        (amountInEuroCents <= (accountBalanceEuroCents + OVERDRAFT_LIMIT))

    companion object {
        const val OVERDRAFT_LIMIT = 5_00L
    }

}
