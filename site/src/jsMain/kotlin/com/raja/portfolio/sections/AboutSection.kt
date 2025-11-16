package com.raja.portfolio.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.raja.portfolio.components.SectionTitle
import com.raja.portfolio.components.SkillBar
import com.raja.portfolio.models.Section
import com.raja.portfolio.models.Skill
import com.raja.portfolio.styles.MainImageStyle
import com.raja.portfolio.utils.Constants.FONT_FAMILY
import com.raja.portfolio.utils.Constants.SECTION_WIDTH
import com.raja.portfolio.utils.ObserveViewPortEntered
import com.raja.portfolio.utils.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AboutSection()
{
    Box(
        modifier = Modifier
            .id(Section.About.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 150.px)
        ,
        contentAlignment = Alignment.TopCenter
    ) {
        AboutContent()
    }
}

@Composable
fun AboutContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleGrid(
            modifier = Modifier
                .fillMaxWidth(90.percent)
                .fillMaxHeight(),
            numColumns = numColumns(base = 1, md = 2)
        ) {
            if ( breakpoint >= Breakpoint.MD ) {
                AboutImage()
            }
            AboutMe()
        }
    }
}

@Composable
fun AboutImage() {
    Column(
        modifier = Modifier
            .fillMaxWidth(90.percent)
            .fillMaxHeight()
            .margin(leftRight = 2.px),
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .objectFit(ObjectFit.Contain),
            src = Res.Image.ABOUT_ME,
            description = "Background image"
        )
    }
}

@Composable
fun AboutMe() {
    var viewPortEntered by remember {
        mutableStateOf(false)
    }
    ObserveViewPortEntered(
        sectionId = Section.About.id,
        distanceFromTop = 400.0,
        onViewPortEntered = {
            viewPortEntered = true
        }
    )
    Column(
        modifier = Modifier
    ) {
        SectionTitle(
            section = Section.About,
            alignment = Alignment.CenterStart
        )

        P(
            Modifier
                .fillMaxWidth()
                .fontSize(20.px)
                .fontFamily(FONT_FAMILY)
                .fontWeight(FontWeight.Normal)
                .color(Color.lightblue)
                .textAlign(TextAlign.Start)
                .margin(topBottom = 4.px)
                .toAttrs()
        ) {
            Text(value = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")
        }

        Skill.entries.forEach { skill ->
            SkillBar(
                name = skill.title,
                index = skill.ordinal,
                percentage = if (viewPortEntered) skill.percentage else 0.percent
            )
        }
    }
}
