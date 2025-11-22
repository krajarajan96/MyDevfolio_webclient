package com.raja.portfolio.models

import com.raja.portfolio.utils.Res

data class Service constructor(
    val icon: String,
    val iconDescription: String,
    val title: String,
    val description: String
)

val myServices by lazy {
    listOf(
        Service(
            icon = Res.Icon.ANDROID,
            iconDescription = "Android development",
            title = "Android development",
            description = "Tell a few lines about experiences with developing products in android."
        ),
        Service(
            icon = Res.Icon.IOS,
            iconDescription = "iOS development",
            title = "iOS development",
            description = "Tell a few lines about experiences with developing products in iOS."
        ),
        Service(
            icon = Res.Icon.FLUTTER,
            iconDescription = "Flutter development",
            title = "Flutter development",
            description = "Tell a few lines about experiences with developing products in flutter."
        ),
        Service(
            icon = Res.Icon.SERVER,
            iconDescription = "Kotlin Backend",
            title = "Kotlin Backend",
            description = "Tell a few lines about experiences with developing products in backend."
        ),
        Service(
            icon = Res.Icon.KOTLIN_CMP,
            iconDescription = "Compose Multiplatform",
            title = "Compose Multiplatform",
            description = "Tell a few lines about experiences with developing products in CMP."
        ),
        Service(
            icon = Res.Icon.AUTOMATION,
            iconDescription = "Appium automation testing",
            title = "Appium automation testing",
            description = "Tell a few lines about experiences with developing products in appium."
        ),
        Service(
            icon = Res.Icon.WEB,
            iconDescription = "Web scraping",
            title = "Web scraping",
            description = "Tell a few lines about experiences with developing products in web scraping."
        )
    )
}