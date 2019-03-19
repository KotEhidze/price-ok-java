package com.priceok.demo

import com.priceok.demo.data.cloud.FirestoreDatabase
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class FirestoreDatabaseTest {

    @Autowired
    lateinit var firestoreDatabase: FirestoreDatabase

    companion object {
        const val COLLECTTION_NAME = "phones"
    }

    @Test
    fun insertDataTest(){
        val data =  mutableMapOf<String, Any>(
                "model" to "Iphone",
                "storage" to 32
        )
        firestoreDatabase.insertData(COLLECTTION_NAME, data)
    }

    @Test
    fun updateDataTest(){
        val documentName = "exampleName"

        val data =  mutableMapOf<String, Any>(
                "model" to "IPhone",
                "storage" to 16
        )
        firestoreDatabase.updateData(COLLECTTION_NAME,documentName, data)
    }

    @Test
    fun getDataTest () {
        val documentName = "exampleName"
        print(firestoreDatabase.getData(COLLECTTION_NAME, documentName).data)
    }

    fun deleteDataTest (){
        val documentName = "exampleName"
        firestoreDatabase.deleteData(COLLECTTION_NAME,documentName)
    }
}