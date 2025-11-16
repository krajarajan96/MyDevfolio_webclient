package com.raja.portfolio.components

import androidx.compose.runtime.Composable
import com.raja.portfolio.models.Skill
import com.varabyte.kobweb.compose.css.CSSColor
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.CSSNumericValue
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.CSSUnitPercentage
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SkillBar(
    name: String,
    index: Int,
    percentage: CSSSizeValue<CSSUnit.percent> = 50.percent,
    barHeight: CSSSizeValue<CSSUnit.px> = 5.px,
)
{
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .maxWidth(500.px)
            .padding(topBottom = 5.px)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            P(
                Modifier.toAttrs()
            ) {
                Text(value = name)
            }
            P(
                Modifier.toAttrs()
            ) {
                Text(value = "${percentage.value} ${percentage.unit}")
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(barHeight)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(barHeight)
                    .backgroundColor(Color.lightblue)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth(percentage)
                    .height(barHeight)
                    .backgroundColor(Color.darkblue)
                    .transition(
                        Transition.of(
                            property = "width",
                            duration = 1000.ms,
                            delay = (index * 100).ms
                        )
                    )
            )
        }
    }
}