package com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_irrelevant_detail

import com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_too_much.Address
import com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_too_much.Customer

fun aValidCustomer() = Customer(
    id = 1,
    name = "John Doe",
    age = 21,
    address = Address(
        countryCode = "NL",
        province = "North Holland",
        city = "Amsterdam",
        postCode = "1072 AT",
        streetLine = "Ruysdaelkade 174",
    ),
    accountBalanceEuroCents = 10,
)
