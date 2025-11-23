package com.raja.portfolio.sections

import androidx.compose.runtime.Composable
import com.raja.portfolio.components.PortfolioCard
import com.raja.portfolio.components.PortfolioNavigation
import com.raja.portfolio.components.SectionTitle
import com.raja.portfolio.components.ServiceCard
import com.raja.portfolio.models.Section
import com.raja.portfolio.models.myPortfolio
import com.raja.portfolio.models.myServices
import com.raja.portfolio.utils.Constants.SECTION_WIDTH
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.scrollBehavior
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun PortfolioSection() {
    Box(
        modifier = Modifier
            .id(Section.Portfolio.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 150.px)
        ,
        contentAlignment = Alignment.Center
    ) {
        PortfolioContent()
    }
}

@Composable
fun PortfolioContent()
{
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .maxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier.fillMaxWidth().margin(bottom = 20.px),
            section = Section.Portfolio,
            alignment = Alignment.CenterStart
        )
        Row(
            modifier = Modifier
                .id("scrollableContainer")
                .fillMaxWidth()
                .maxWidth(
                    if (breakpoint > Breakpoint.MD) 950.px
                    else if (breakpoint > Breakpoint.SM) 625.px
                    else 300.px
                )
                .overflow(Overflow.Hidden)
                .scrollBehavior(ScrollBehavior.Smooth),
        ) {
            myPortfolio.forEach { portfolio ->
                PortfolioCard(
                    modifier = Modifier.margin(right = 25.px),
                    portfolio = portfolio
                )
            }
        }
        PortfolioNavigation()
    }
}