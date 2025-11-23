package com.raja.portfolio.styles

import com.raja.portfolio.models.Theme
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.argb
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.translateX
import com.varabyte.kobweb.compose.ui.modifiers.visibility
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val portfolioStyles = CssStyle {

    cssRule(" > #columnContainer > #boxContainer > #greenOverlay") {
        Modifier
            .width(0.px)
            .transition(Transition.of(property = "width", duration = 500.ms))
    }
    cssRule(":hover > #columnContainer > #boxContainer > #greenOverlay") {
        Modifier
            .width(300.px)

    }

    cssRule(" > #columnContainer > #boxContainer > #greenOverlay > #linkIcon") {
        Modifier.visibility(Visibility.Hidden)
    }
    cssRule(":hover > #columnContainer > #boxContainer > #greenOverlay > #linkIcon") {
        Modifier.visibility(Visibility.Visible)
    }

    cssRule(" > #columnContainer > #portfolioTitle") {
        Modifier
            .translateX(0.px)
            .color(Colors.Black)
            .transition(Transition.of(property = "color", duration = 500.ms))
            .transition(Transition.of(property = "translate", duration = 500.ms))
    }
    cssRule(":hover > #columnContainer > #portfolioTitle") {
        Modifier
            .translateX(5.percent)
            .color(Theme.Main.rgb)
    }

    cssRule(" > #columnContainer > #portfolioDesc") {
        Modifier
            .translateX(0.px)
            .color(Colors.Black)
            .transition(Transition.of(property = "color", duration = 500.ms))
            .transition(Transition.of(property = "translate", duration = 500.ms))
    }
    cssRule(":hover > #columnContainer > #portfolioDesc") {
        Modifier
            .translateX(5.percent)
            .color(Theme.Main.rgb)
    }
}

val portfolioNavStyles = CssStyle {
    base {
        Modifier
            .color(Colors.LightGray)
            .transition(Transition.of(property = "color", duration = 200.ms))
    }
    hover {
        Modifier
            .color(Colors.Black)
    }
}