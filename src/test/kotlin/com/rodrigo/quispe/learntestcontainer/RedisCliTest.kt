package com.rodrigo.quispe.learntestcontainer

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.Network
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
class RedisCliTest {

    companion object {
        val ALIAS_SERVER = "redis-server"
        val network = Network.newNetwork()

        @Container
        val redis = GenericContainer("redis:7.0.8-alpine")
            .withExposedPorts(6379)
            .withNetworkAliases(ALIAS_SERVER)
            .withNetwork(network)

        @Container
        val redisCli = GenericContainer("redis:7.0.8-alpine")
            .withExposedPorts(6379)
            .withNetwork(network)
            .dependsOn(redis)
    }

    @Test
    fun cliRedis() {
        val output = redisCli.execInContainer("redis-cli", "-h", ALIAS_SERVER, "ping").stdout
        Assertions.assertEquals("PONG", output.trim())
    }
}