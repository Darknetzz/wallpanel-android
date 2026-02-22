package xyz.wallpanel.app.network

import android.content.Context

interface MQTTServiceInterface {
    val isReady: Boolean

    fun publish(topic: String, payload: String, retain: Boolean)
    fun reconfigure(context: Context, options: MQTTOptions, listener: IMqttManagerListener)

    /** Closes the client. May throw Mqtt3MessageException or Mqtt5MessageException. */
    fun close()
}