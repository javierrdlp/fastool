package com.pmdm.fastool.ui.features.repair.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pmdm.fastool.ui.features.repair.RepairsEvent


@Immutable
data class ItemMenuDesplegable(
    val descripcion: String,
    val onClick: () -> Unit
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperiorAppBar(
    comportamientoAnteScroll: TopAppBarScrollBehavior,
    onRepairsEvent: (RepairsEvent) -> Unit,
    onClickSalir:()-> Unit,
    arrangeRepState: Boolean,
    arrangeDateState: Boolean
) {
    var expandidoState by remember { mutableStateOf(false) }
    val cerrarMenu: () -> Unit = { expandidoState = false }


    val descripcionEIconos = remember {
        listOf(
            ItemMenuDesplegable(
                descripcion = "Salir Aplicación", onClick = {
                    onClickSalir()

                }
            )
        )
    }
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = { }, modifier = Modifier.alpha(0f)) {
                    Icon(Icons.Rounded.Lock, contentDescription = null)
                }
                Row {
                    IconButton(onClick = { onRepairsEvent(RepairsEvent.OnClickFiltrarRep) }) {
                        Icon(
                            Icons.Rounded.Build,
                            tint = if(arrangeRepState)Color(0xFF056ad8) else Color.Gray,
                            contentDescription = null
                        )
                    }
                    Spacer(Modifier.width(30.dp))
                    IconButton(onClick = { onRepairsEvent(RepairsEvent.OnClickFiltrarDate) }) {
                        Icon(
                            Icons.Rounded.DateRange,
                            tint = if(arrangeDateState)Color(0xFF056ad8) else Color.Gray,
                            contentDescription = null
                        )
                    }
                }

                Box {
                    IconButton(onClick = { expandidoState = true }) {
                        Icon(Icons.Rounded.Menu, contentDescription = null)
                    }
                    DropdownMenu(
                        expanded = expandidoState,
                        onDismissRequest = cerrarMenu
                    ) {
                        for (i in descripcionEIconos.indices) {
                            DropdownMenuItem(
                                text = { Text(descripcionEIconos[i].descripcion) },
                                onClick = {
                                    descripcionEIconos[i].onClick()
                                    cerrarMenu()
                                }
                            )
                        }
                    }
                }
            }
        },
        scrollBehavior = comportamientoAnteScroll
    )
}