package com.raja.portfolio.models

import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.rgb
import org.jetbrains.compose.web.css.CSSColorValue

enum class Theme(
    val hex: String,
    val rgb: CSSColorValue
) {
    Primary(hex = "#00A78E", rgb = rgb(r = 0, g = 167, b = 142)),
    Secondary(hex = "#121D34", rgb = rgb(r = 18, g = 29, b = 52)),
    Gray(hex = "#CFCFCF", rgb = rgb(r = 207, g = 207, b = 207)),
    LightGray(hex = "#EDEDED", rgb = rgb(r = 237, g = 237, b = 237)),
    LighterGray(hex = "#F9F9F9", rgb = rgb(r = 249, g = 249, b = 249)),
    White(hex = "#FFFFFF", rgb = rgb(r = 255, g = 255, b = 255)),

    NewPrimary(hex = "#E9DEFF", rgb = rgb(r = 233, g = 222, b = 255)),
    Main(hex = "#9C2EF5", rgb = rgb(r = 156, g = 46, b = 245)),
    NewSecondary(hex = "#1E0044", rgb = rgb(r = 30, g = 0, b = 68)),
    Dark(hex = "#0B001A", rgb = rgb(r = 11, g = 0, b = 26)),
}