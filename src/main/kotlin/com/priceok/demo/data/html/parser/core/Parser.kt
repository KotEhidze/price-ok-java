package com.priceok.demo.data.html.parser.core

interface Parser<T: ParsingModel> {

    fun parse(htmlContent: String) : T

}