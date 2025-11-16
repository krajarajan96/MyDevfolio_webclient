package com.raja.portfolio.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.raja.portfolio.models.Section
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.events.EventListener

@Composable
fun ObserveViewPortEntered(
    sectionId: String,
    distanceFromTop: Double,
    onViewPortEntered: () -> Unit
) {
    var viewPortEntered by remember {
        mutableStateOf(false)
    }
    val listener = remember {
        EventListener {
            val top = document.getElementById(sectionId)?.getBoundingClientRect()?.top
            if ( top != null && top < distanceFromTop ) {
                viewPortEntered = true
            }
        }
    }
    LaunchedEffect(viewPortEntered) {
        if (viewPortEntered) {
            onViewPortEntered()
            window.removeEventListener("scroll", callback = listener)
        }
        else {
            window.addEventListener("scroll", callback = listener)
        }
    }
}