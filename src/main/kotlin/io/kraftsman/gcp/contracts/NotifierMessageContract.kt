package io.kraftsman.gcp.contracts

interface NotifierMessageContract {
    val orderId: Int
    val message: String
}
