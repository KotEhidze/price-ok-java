package com.priceok.demo.data.html.parser.utils

import com.priceok.demo.data.html.parser.configs.ParsingConfig

fun config(init: ParsingConfig.() -> Unit) = ParsingConfig().apply(init)