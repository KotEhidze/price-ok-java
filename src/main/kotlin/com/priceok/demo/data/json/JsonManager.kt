package com.priceok.demo.data.json

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component
import java.io.File
import java.io.IOException



@Component
class JsonManager{
    val mapper = ObjectMapper()
    val FILE_PATH = "D:\\country.json"

    fun readJson () {
        val info   = mapper.readTree(File(FILE_PATH))
        print(info)
    }

    // TODO : fix file overwriting
    fun writeJson (map: MutableMap<String, Any>) {

        try {
            // Writing to a file
            mapper.writeValue(File(FILE_PATH), map)

        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

}

