package com.priceok.demo.data.cloud

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import java.io.FileInputStream
import java.io.InputStream

@Configuration
@PropertySource("classpath:config/firebase.properties")
@ConfigurationProperties
class FirestoreProperties {

    @Value("\${project.id}")
    private lateinit var id: String
    @Value("\${project.credentials}")
    private lateinit var credentials: String

    val projectId
        get() = id

    val credentialsStream: InputStream
        get() = FileInputStream(credentials)

}