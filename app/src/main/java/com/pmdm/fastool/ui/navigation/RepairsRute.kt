package com.pmdm.fastool.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pmdm.fastool.ui.features.repair.RepairViewModel
import com.pmdm.fastool.ui.features.repair.RepairsScreen
import kotlinx.serialization.Serializable

@Serializable
object RepairsRute


fun NavGraphBuilder.repairsScreenDestination(
    repairViewModel: RepairViewModel
) {

    composable<RepairsRute> { backStackEntry ->
        RepairsScreen(
            modifier = Modifier.fillMaxSize(),
            listaReparaciones = repairViewModel.repState,
            scaffoldEvent = repairViewModel::onScaffoldEvent,
            onRepairsEvent = repairViewModel::onRepairsEvent
        )
    }
}