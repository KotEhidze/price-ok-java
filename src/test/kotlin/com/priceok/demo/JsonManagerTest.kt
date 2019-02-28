package com.priceok.demo

import com.priceok.demo.data.json.JsonManager
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class JsonManagerTest {

    @Autowired
    lateinit var jsonManager: JsonManager

    @Test
    fun contextLoads() {

    }

    @Test
    fun readJsonTest(){
        jsonManager.readJson()
    }

    @Test
    fun writeJsonTest(){
        val exampleData =  mutableMapOf<String, Any>(
                "model" to "IPhone",
                "storage" to 16
        )
        jsonManager.writeJson(exampleData)
    }

}