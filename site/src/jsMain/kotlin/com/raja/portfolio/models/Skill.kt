package com.raja.portfolio.models

import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.percent

enum class Skill constructor(
    val title: String,
    val percentage: CSSSizeValue<CSSUnit.percent>
)
{
    Android(
        title = "Android",
        percentage = 80.percent
    ),
    iOS(
        title = "iOS",
        percentage = 80.percent
    ),
    Flutter(
        title = "Flutter",
        percentage = 80.percent
    ),
    KMP(
        title = "KMP",
        percentage = 80.percent
    ),
    CMP(
        title = "CMP",
        percentage = 80.percent
    ),
    Backend(
        title = "Backend with Kotlin",
        percentage = 80.percent
    )
}