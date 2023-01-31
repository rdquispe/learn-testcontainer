package com.rodrigo.quispe.learntestcontainer

import org.junit.jupiter.api.Test
import org.testcontainers.containers.GenericContainer

class RedisTest {

    @Test
    fun redisContainer() {
        val redis = GenericContainer("redis:7.0.8-alpine")
            .withExposedPorts(6379)

        redis.start()
        redis.stop()
    }
}