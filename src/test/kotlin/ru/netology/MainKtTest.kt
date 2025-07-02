package ru.netology

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun commissionCalc_default() {
        val result = commissionCalc(amount = 75_000)
        assertEquals(0, result)
    }

    @Test
    fun commissionCalc_zero() {
        val result = commissionCalc(amount = 0)
        assertEquals(0, result)
    }

    @Test
    fun commissionCalc_moreThanMonthlyLimit() {
        val result = commissionCalc(lastTransfer = 550_000, amount = 75_000)
        assertEquals(0, result)
    }

    @Test
    fun commissionCalc_moreThanDailyLimit() {
        val result = commissionCalc(amount = 160_000)
        assertEquals(0, result)
    }

    @Test
    fun commissionCalc_return() {
        val result = commissionCalc("fef", 0, 100)
        assertEquals(0, result)
    }

    @Test
    fun commissionCalc_visaMoreThan35() {
        val result = commissionCalc("Visa", 0, 75_000)
        assertEquals(563, result)
    }

    @Test
    fun commissionCalc_visaLessThan35() {
        val result = commissionCalc("Visa", 0, 3_000)
        assertEquals(35, result)
    }

    @Test
    fun commissionCalc_MastercardLessThanMonthlyLimit() {
        val result = commissionCalc("Mastercard", 0, 65_000)
        assertEquals(0, result)
    }

    @Test
    fun commissionCalc_MastercardMoreThanMonthlyLimitAndLessThanLastTransfer() {
        val result = commissionCalc("Mastercard", 0, 90_000)
        assertEquals(110, result)
    }

    @Test
    fun commissionCalc_MastercardMoreThanMonthlyLimitAndMoreThanLastTransfer() {
        val result = commissionCalc("Mastercard", 90_000, 10_000)
        assertEquals(80, result)
    }
}