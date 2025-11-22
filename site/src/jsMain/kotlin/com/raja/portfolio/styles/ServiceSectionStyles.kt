package com.raja.portfolio.styles

import com.raja.portfolio.models.Theme
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val ServiceStyle = CssStyle {
    base {
        Modifier
            .border(
                width = 2.px,
                style = LineStyle.Solid,
                color = Theme.LightGray.rgb
            )
            .backgroundColor(Colors.White)
            .transition(Transition.of(property = "border", duration = 200.ms))
            .transition(Transition.of(property = "background", duration = 200.ms))
    }
    hover {
        Modifier
            .border(
                width = 2.px,
                style = LineStyle.Solid,
                color = Theme.Primary.rgb
            )
            .backgroundColor(Theme.Main.rgb)
    }
    cssRule(" > #iconBox") {
        Modifier.backgroundColor(Colors.Transparent)
            .transition(Transition.of(property = "background", duration = 200.ms))
    }
    cssRule(":hover > #iconBox") {
        Modifier.backgroundColor(Colors.White)
    }
    cssRule(" > p") {
        Modifier
            .color(Theme.Secondary.rgb)
            .transition(Transition.of(property = "color", duration = 200.ms))
    }
    cssRule(":hover > p") {
        Modifier.color(Colors.White)
    }
}