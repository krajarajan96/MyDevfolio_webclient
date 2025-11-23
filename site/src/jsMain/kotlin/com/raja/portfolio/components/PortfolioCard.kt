package com.raja.portfolio.components

import androidx.compose.runtime.Composable
import com.raja.portfolio.models.Portfolio
import com.raja.portfolio.models.Theme
import com.raja.portfolio.styles.ServiceStyle
import com.raja.portfolio.styles.portfolioNavStyles
import com.raja.portfolio.styles.portfolioStyles
import com.raja.portfolio.utils.Res
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.argb
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowLeft
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowRight
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.browser.document
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun PortfolioCard(
    modifier: Modifier = Modifier,
    portfolio: Portfolio
)
{
    Link(
        modifier = portfolioStyles.toModifier()
            .textDecorationLine(TextDecorationLine.None),
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB,
        path = "https://github.com/krajarajan96"
    ) {
        Column(
            modifier = modifier.id("columnContainer"),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .id("boxContainer")
                    .fillMaxWidth()
                    .width(300.px),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(300.px)
                        .objectFit(ObjectFit.Cover),
                    src = portfolio.image,
                    description = portfolio.imageDescription
                )
                Box(
                    modifier = Modifier
                        .id("greenOverlay")
                        .fillMaxHeight()
                        .backgroundColor(argb(0.5F, r = 0, g = 167, b = 142)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier
                            .id("linkIcon")
                            .size(32.px)
                            .objectFit(ObjectFit.Contain),
                        src = Res.Icon.EXTERNAL_LINK,
                        description = "External link"
                    )
                }
            }
            P(
                Modifier
                    .id("PortfolioTitle")
                    .margin(bottom = 10.px)
                    .fontWeight(FontWeight.Bold)
                    .toAttrs()

            ) {
                Text(value = portfolio.title)
            }
            P(
                Modifier
                    .id("PortfolioDesc")
                    .margin(bottom = 20.px)
                    .fontWeight(FontWeight.Normal)
                    .toAttrs()
            ) {
                Text(value = portfolio.description)
            }
        }
    }
}

@Composable
fun PortfolioNavigation()
{
    Row(
        modifier = Modifier.fillMaxWidth().margin(topBottom = 10.px),
        horizontalArrangement = Arrangement.Center
    ) {
        FaArrowLeft(
            modifier = portfolioNavStyles
                .toModifier()
                .margin(right = 40.px)
                .cursor(Cursor.Pointer)
                .onClick {
                    document.getElementById("scrollableContainer")?.scroll(x = -(325.0), y = 0.0)
                },
            size = IconSize.LG
        )
        FaArrowRight(
            modifier = portfolioNavStyles
                .toModifier()
                .cursor(Cursor.Pointer)
                .onClick {
                    document.getElementById("scrollableContainer")?.scroll(x = 325.0, y = 0.0)
                },
            size = IconSize.LG
        )
    }
}