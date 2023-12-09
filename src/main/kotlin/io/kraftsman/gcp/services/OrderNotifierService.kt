package io.kraftsman.gcp.services

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.cloud.spring.pubsub.core.PubSubTemplate
import io.kraftsman.gcp.dtos.pubsub.EmailNotifierMessage
import io.kraftsman.gcp.dtos.pubsub.LineNotifierMessage
import io.kraftsman.gcp.dtos.pubsub.SmsNotifierMessage
import io.kraftsman.gcp.models.NotifyChannel
import io.kraftsman.gcp.models.Order
import org.springframework.stereotype.Service

@Service
class OrderNotifierService(
    private val pubSubTemplate: PubSubTemplate,
) {

    private val objectMapper = jacksonObjectMapper()
    private val topics = mapOf(
        NotifyChannel.LINE to "send-line-notify",
        NotifyChannel.SMS to "send-sms-notify",
        NotifyChannel.EMAIL to "send-email-notify",
    )

    fun send(order: Order, channel: NotifyChannel): Unit {
        val message = when (channel) {
            NotifyChannel.LINE -> generateLineNotifierMessage(order)
            NotifyChannel.EMAIL -> generateEmailNotifierMessage(order)
            NotifyChannel.SMS -> generateSmsNotifierMessage(order)
        }

        val topic = topics.getOrDefault(channel, null)
        val payload = objectMapper.writeValueAsString(message)

        if (topic != null) {
            pubSubTemplate.publish(topic, payload)
        }
    }

    private fun generateLineNotifierMessage(order: Order): LineNotifierMessage =
        LineNotifierMessage(
            order.id,
            order.items.joinToString { "${it.product.name} x ${it.quantity}" }
        )

    private fun generateSmsNotifierMessage(order: Order): SmsNotifierMessage =
        SmsNotifierMessage(
            order.id,
            order.items.joinToString { "${it.product.name} x ${it.quantity}" }
        )

    private fun generateEmailNotifierMessage(order: Order): EmailNotifierMessage =
        EmailNotifierMessage(
            order.id,
            order.items.joinToString { "${it.product.name} x ${it.quantity}" },
            order.user.email
        )
}
