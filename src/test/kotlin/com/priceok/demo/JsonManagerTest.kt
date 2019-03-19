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
    fun writeJsonTest(){
        val exampleData =  mutableMapOf<String, Any>(
                "Brand" to "Iphone",
                "Model" to "6s",
                "Ram" to 2,
                "Storage" to 16,
                "Price" to 235
        )
        val exampleData1 =  mutableMapOf<String, Any>(
                "Brand" to "Samsung",
                "Model" to "7A",
                "Ram" to 3,
                "Storage" to 32,
                "Price" to 175
        )
        val exampleData2 =  mutableMapOf<String, Any>(
                "Brand" to "Samsung",
                "Model" to "Galaxy S2",
                "Ram" to 3,
                "Storage" to 64,
                "Price" to 120
        )
        val exampleData3 =  mutableMapOf<String, Any>(
                "Brand" to "Iphone",
                "Model" to "XS Max",
                "Ram" to 4,
                "Storage" to 256,
                "Price" to 1050
        )
        jsonManager.writeJson(exampleData, "1", false)
        jsonManager.writeJson(exampleData1, "2", false)
        jsonManager.writeJson(exampleData2, "3", false)
        jsonManager.writeJson(exampleData3, "4",true)
    }

    @Test
    fun readJsonTest(){
        print(jsonManager.readJson())
    }

    @Test
    fun findJsonObjectTest(){
        print(jsonManager.findJsonObject("3"))
    }

    @Test
    fun clearJsonFileTest(){
    jsonManager.clearJsonFile()
    }
}