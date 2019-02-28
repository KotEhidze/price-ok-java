package com.priceok.demo

import com.priceok.demo.data.cloud.FirestoreDatabase
import com.priceok.demo.data.cloud.FirestoreProperties
import com.priceok.demo.data.json.JsonManager
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties

class DemoApplication


fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

