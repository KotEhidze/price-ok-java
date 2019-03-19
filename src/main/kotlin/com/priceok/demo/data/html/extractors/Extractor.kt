package com.priceok.demo.data.html.extractors

import org.jsoup.nodes.Element

interface Extractor {

    fun extract(element: Element, model: MutableMap<String, Any?>)

}