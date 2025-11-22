package com.raja.portfolio.sections

import androidx.compose.runtime.Composable
import com.raja.portfolio.components.SectionTitle
import com.raja.portfolio.components.ServiceCard
import com.raja.portfolio.models.Section
import com.raja.portfolio.models.myServices
import com.raja.portfolio.utils.Constants.SECTION_WIDTH
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Col

@Composable
fun ServiceSection()
{
    Box(
        modifier = Modifier
            .id(Section.Service.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 150.px)
        ,
        contentAlignment = Alignment.TopCenter
    ) {
        ServiceContent()
    }
}

@Composable
fun ServiceContent()
{
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            section = Section.Service,
            alignment = Alignment.Center
        )
        SimpleGrid(numColumns = numColumns(base = 1, sm = 2, md = 3)) {
            myServices.forEach { service ->
                ServiceCard(service = service)
            }
        }
    }
}