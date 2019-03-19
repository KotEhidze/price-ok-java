package com.priceok.demo.data.html.parser.core

import com.priceok.demo.data.html.parser.configs.ParsingConfig
import org.jsoup.Jsoup

abstract class AbstractParser<T: ParsingModel>(private val parsingConfig: ParsingConfig) : Parser<T> {

    abstract fun createStructuredModel(map: Map<String, Any?>) : T

    override fun parse(htmlContent: String): T {
        val model = mutableMapOf<String, Any?>()
        val document = Jsoup.parse(htmlContent)
        parsingConfig.apply {
            selectorExtractors.forEach { selector, extractor ->
                extractor.extract(document.body().select(selector).first(), model)
            }
        }
        return createStructuredModel(model)
    }
}