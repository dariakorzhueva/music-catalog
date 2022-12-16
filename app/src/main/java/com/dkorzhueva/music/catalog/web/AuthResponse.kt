package com.dkorzhueva.music.catalog.web

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(strict = false, name="lfm")
data class AuthResponse @JvmOverloads constructor(
    @field:Element(name = "status", required = false)
    var status: String = "",
    @field:Element(name = "session")
    var session: SessionEntity? = null
)