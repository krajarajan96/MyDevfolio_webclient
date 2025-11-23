package com.raja.portfolio.models

import com.raja.portfolio.utils.Res

data class Portfolio constructor(
    val image: String,
    val imageDescription: String,
    val title: String,
    val description: String
)

val myPortfolio = listOf(
    Portfolio(
        image = Res.Image.BACKGROUND,
        imageDescription = "be",
        title = "IPCApp",
        description = "Android/Mobile"
    ),
    Portfolio(
        image = Res.Image.BACKGROUND,
        imageDescription = "",
        title = "DevPortfolio",
        description = "Kotlin/Frontend"
    ),
    Portfolio(
        image = Res.Image.BACKGROUND,
        imageDescription = "",
        title = "Talkatoo",
        description = "Kotlin/Backend"
    ),
    Portfolio(
        image = Res.Image.BACKGROUND,
        imageDescription = "",
        title = "SpecsAtHome",
        description = "Flutter/Mobile"
    ),
    Portfolio(
        image = Res.Image.BACKGROUND,
        imageDescription = "",
        title = "AppiumTestSuite",
        description = "Automation/Mobile"
    ),
    Portfolio(
        image = Res.Image.BACKGROUND,
        imageDescription = "",
        title = "ScrumApp",
        description = "iOS-Skip/Mobile"
    )
)