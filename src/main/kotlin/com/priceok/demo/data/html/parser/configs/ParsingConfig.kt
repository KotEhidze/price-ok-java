package com.priceok.demo.data.html.parser.configs

import com.priceok.demo.data.html.extractors.Extractor
import org.jsoup.nodes.Element

open class ParsingConfig {

    private val extractorsBySelectors = mutableMapOf<String, Extractor>()

    fun select(selector: String, extractor: (Element, MutableMap<String, Any?>) -> Unit) {
        extractorsBySelectors[selector] = object : Extractor {
            override fun extract(element: Element, model: MutableMap<String, Any?>) = extractor(element, model)
        }
    }

    val selectorExtractors
        get() = extractorsBySelectors.toMap()

}