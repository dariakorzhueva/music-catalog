package com.dkorzhueva.music.catalog.web

import org.simpleframework.xml.Element

data class SessionEntity @JvmOverloads constructor(
    @field:Element(name = "name")
    var name: String = "",
    @field:Element(name = "key")
    var key: String = "",
    @field:Element(name = "subscriber")
    var subscriber: Int = 0
)