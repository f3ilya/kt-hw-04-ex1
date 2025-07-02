package ru.netology

fun main() {
    commissionCalc("Mastercard", 50_000, 100_000)
}

fun commissionCalc(typeCard: String = "Мир", lastTransfer: Int = 0, amount: Int): Long {
    val mounthlyLimit = 600_000
    val dailyLimit = 150_000
    val mounthlyLimitMastercard = 75_000

    when {
        lastTransfer + amount > mounthlyLimit -> return 0
        amount > dailyLimit -> return 0
        typeCard == "Мир" -> return 0
        typeCard == "Mastercard" -> when {
            amount <= dailyLimit && lastTransfer + amount <= mounthlyLimitMastercard -> return 0
            amount <= dailyLimit && lastTransfer + amount > mounthlyLimitMastercard -> {
                val amountExceedingLimit = when {
                    lastTransfer > mounthlyLimitMastercard -> amount
                    else -> amount - (mounthlyLimitMastercard - lastTransfer)
                }
                return Math.round(amountExceedingLimit * 0.006 + 20)
            }
        }
        typeCard == "Visa" -> when {
            amount <= dailyLimit && amount * 0.0075 > 35 -> return  Math.round(amount * 0.0075)
            amount <= dailyLimit && amount * 0.0075 < 35 -> return 35
        }
    }
    return 0
}