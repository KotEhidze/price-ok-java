package com.priceok.demo.data.json

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component
import java.io.File
import java.io.IOException
import java.util.LinkedHashMap

@Component
class JsonManager{
    val mapper = ObjectMapper()
    val FILE_PATH = "D:\\test.json"
    val objectMap = LinkedHashMap<String, Any>()

    fun writeJson (map: MutableMap<String, Any>, objectId : String, isDone : Boolean) {
        objectMap.put(objectId, map)

        if (isDone) {
            try {
                // Writing to a file
                mapper.writeValue(File(FILE_PATH), objectMap)

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    fun readJson (): JsonNode? {
        val info   = mapper.readTree(File(FILE_PATH))
        return info
    }

    fun findJsonObject (objectId : String): JsonNode? {
        val allElements = readJson()
        if (allElements != null) {
            return allElements.findValue(objectId)
        }
        return null
    }

    fun clearJsonFile() {
        mapper.writeValue(File(FILE_PATH), null)
    }

}

