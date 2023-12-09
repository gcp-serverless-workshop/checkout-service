package io.kraftsman.gcp.contracts

interface NotifierMessageContract {
    val orderId: Long
    val message: String
}
