package com.raja.portfolio.sections

import androidx.compose.runtime.Composable
import com.raja.portfolio.components.Header
import com.raja.portfolio.components.SocialBar
import com.raja.portfolio.models.Section
import com.raja.portfolio.models.Theme
import com.raja.portfolio.styles.MainButtonStyle
import com.raja.portfolio.styles.MainImageStyle
import com.raja.portfolio.utils.Constants
import com.raja.portfolio.utils.Constants.FONT_FAMILY
import com.raja.portfolio.utils.Constants.SECTION_WIDTH
import com.raja.portfolio.utils.Res
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontStyle
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedin
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun MainSection()
{
    Box(
        modifier = Modifier
            .id(Section.Home.id)
            .maxWidth(SECTION_WIDTH.px)
            ,
        contentAlignment = Alignment.TopCenter
    ) {
        MainBackground()
        MainContent()
    }
}

@Composable
fun MainBackground()
{
    Image(
        modifier = Modifier
            .fillMaxSize()
            .objectFit(ObjectFit.Cover),
        src = Res.Image.BACKGROUND,
        description = "Background image"
    )
}

@Composable
fun MainContent()
{
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SimpleGrid(
                modifier = Modifier
                    .fillMaxWidth(80.percent)
                    .fillMaxHeight(),
                numColumns = numColumns(base = 1, md = 2)
            ) {
                MainText()
                MainImage()
            }
        }
    }
}

@Composable
fun MainText()
{
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        P(
            attrs = Modifier
                .margin(topBottom = 0.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(45.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.Main.rgb)
                .toAttrs()
        ) {
            Text(value = "Hello, I'm")
        }
        P(
            attrs = Modifier
                .margin(top = 10.px, bottom = 0.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(68.px)
                .fontWeight(FontWeight.Bolder)
                .color(Theme.NewSecondary.rgb)
                .toAttrs()
        ) {
            Text(value = "Rajarajan K")
        }
        P(
            attrs = Modifier
                .margin(top = 10.px, bottom = 10.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(20.px)
                .fontWeight(FontWeight.Bold)
                .color(Theme.Main.rgb)
                .toAttrs()
        ) {
            Text(value = "Mobile developer")
        }
        P(
            attrs = Modifier
                .margin(bottom = 25.px)
                .maxWidth(400.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(16.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.Secondary.rgb)
                .toAttrs()
        ) {
            Text(value = Constants.DESCRIPTION)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Button(
                MainButtonStyle
                    .toModifier()
                    .height(40.px)
                    .border(width = 0.px)
                    .borderRadius(r = 5.px)
                    .backgroundColor(Theme.Main.rgb)
                    .color(Colors.White)
                    .padding(leftRight = 20.px)
                    .margin(right = 20.px)
                    .toAttrs()
            ) {
                Link(
                    path = Section.Contact.path,
                    text = "Hire me",
                    modifier = Modifier
                        .color(Colors.White)
                        .textDecorationLine(TextDecorationLine.None)
                )
            }
            SocialBar()
        }
    }
}

@Composable
fun MainImage()
{
    Column(
        modifier = Modifier.fillMaxSize().fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(
            modifier = MainImageStyle
                .toModifier()
                .fillMaxHeight()
                .objectFit(ObjectFit.Contain),
            src = Res.Image.MY_PHOTO,
            description = "Background image"
        )
    }
}