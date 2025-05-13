package com.mocanu.clean_tests_presentation._2_time_consuming_maintenance._3_mocks._1_missing_tests_for_mocks

import com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_irrelevant_detail.aValidCustomer
import com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_too_much.Customer
import com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_too_much.CustomerRepository
import com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_too_much.CustomerService
import org.assertj.core.api.WithAssertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class MissingTestsForMocks : WithAssertions {

    // [tell] personal advice: avoid mocks as much as possible

    // [show] using a mock CustomerRepository, to test the service in isolation
    //        (not necessarily useful)
    // [tell] sometimes, people forget to also test the real `CustomerRepository`
    //        with a real DB
    //        => tests pass, but it fails in production, because an SQL query
    //           is incorrect
    //        * don't forget to also test your real repositories
    //
    // [tell] always test the repository/DAO with the real DB;
    //        e.g. if you're using Postgres in prod, use that to test the
    //        repositories, not H2 in Postgres compatibility mode;
    //        H2 is not Postgres: you don't want green tests and broken prod
    //
    // [tell] sometimes, the SQL queries change very often
    //        In this case, consider your repository/DAO classes an implementation
    //        detail, and test your services with a real database.
    //        The tests will be slower, but they won't need updating so often,
    //        supporting your refactoring.
    //
    //        Also, you can update the DB in multiple ways:
    //        * updateName
    //        * getCustomer + change name in the model + saveCustomer
    //        * etc.
    //        Reading what is in the DB after the update is much more robust
    //        (no failure when you're refactoring) than testing what
    //        repository methods have been called.

    private val customerRepository: CustomerRepository = mock(CustomerRepository::class.java)
    private val customerService = CustomerService(customerRepository)

    @Test
    fun `should disable customer correctly`() {
        val customer: Customer = aValidCustomer()

        customerService.suspend(customer)

        verify(customerRepository)
            .updateName(customer.id, CustomerService.SUSPENDED_NAME)
    }

}
