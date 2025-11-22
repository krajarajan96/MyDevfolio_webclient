package com.raja.portfolio.components

import androidx.compose.runtime.Composable
import com.raja.portfolio.models.Service
import com.raja.portfolio.models.Theme
import com.raja.portfolio.styles.ServiceStyle
import com.raja.portfolio.utils.Res
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontStyle
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ServiceCard(
    service: Service
) {
    Column(modifier = ServiceStyle
        .toModifier()
        .maxWidth(300.px)
        .padding(20.px)
        .margin(20.px)
        .borderRadius(
            topLeft = 10.px,
            topRight = 10.px,
            bottomLeft = 10.px,
            bottomRight = 10.px
        )
        .border(
            width = 2.px,
            style = LineStyle.Solid,
            color = Theme.LightGray.rgb
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .id("iconBox")
                .padding(10.px)
                .margin(20.px)
                .borderRadius(
                    topLeft = 20.px,
                    topRight = 20.px,
                    bottomLeft = 20.px,
                    bottomRight = 0.px
                )
                .border(
                    width = 2.px,
                    style = LineStyle.Solid,
                    color = Theme.Gray.rgb
                )
        ) {
            Image(
                modifier = Modifier
                    .size(40.px)
                    .objectFit(ObjectFit.Contain),
                src = service.icon,
                description = service.iconDescription
            )
        }
        P(
            Modifier
                .margin(bottom = 10.px)
                .fontWeight(FontWeight.Bold)
                .toAttrs()

        ) {
            Text(value = service.title)
        }
        P(
            Modifier
                .margin(bottom = 20.px)
                .fontWeight(FontWeight.Normal)
                .toAttrs()
        ) {
            Text(value = service.description)
        }
    }
}