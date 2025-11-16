package com.raja.portfolio.components

import androidx.compose.runtime.Composable
import com.raja.portfolio.models.Section
import com.raja.portfolio.utils.Constants.FONT_FAMILY
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SectionTitle(
    section: Section,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.CenterStart
) {
    Column(
        modifier = modifier
    ) {
        P(
            Modifier
                .fillMaxWidth()
                .fontSize(20.px)
                .fontFamily(FONT_FAMILY)
                .fontWeight(FontWeight.Normal)
                .color(Color.lightblue)
                .textAlign(
                    when (alignment) {
                        Alignment.CenterStart -> TextAlign.Start
                        Alignment.CenterEnd -> TextAlign.End
                        else -> TextAlign.Center
                    }
                )
                .margin(topBottom = 4.px)
                .toAttrs()
        ) {
            Text(value = section.title)
        }
        P(
            Modifier
                .fillMaxWidth()
                .fontSize(30.px)
                .fontFamily(FONT_FAMILY)
                .fontWeight(FontWeight.Bold)
                .color(Color.darkblue)
                .textAlign(
                    when (alignment) {
                        Alignment.CenterStart -> TextAlign.Start
                        Alignment.CenterEnd -> TextAlign.End
                        else -> TextAlign.Center
                    }
                )
                .margin(topBottom = 6.px)
                .toAttrs()
        ) {
            Text(value = section.subtitle)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.px)
                .margin(topBottom = 8.px),
        ) {
            Box(
                modifier = Modifier
                    .align(alignment)
                    .fillMaxWidth(40.percent)
                    .height(2.px)
                    .backgroundColor(Color.darkblue)
            )
        }
    }
}