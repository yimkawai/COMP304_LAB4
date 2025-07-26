package com.kawai.kawaiyim_comp304lab4.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.kawai.kawaiyim_comp304lab4.data.sampleLandmarks
import com.kawai.kawaiyim_comp304lab4.ui.screens.*
import androidx.navigation.navArgument

@Composable
fun AppNavGraph() {
    val nav = rememberNavController()
    NavHost(nav, startDestination = "catList") {

        composable("catList") {
            CategoryScreen(
                categories = sampleLandmarks.map { it.category }.distinct(),
                onSelect = { nav.navigate("items/$it") }
            )
        }

        composable(
            route = "items/{cat}",
            arguments = listOf(navArgument("cat") { type = NavType.StringType })
        ) { back ->
            val cat = back.arguments!!.getString("cat")!!
            ItemScreen(
                landmarks = sampleLandmarks.filter { it.category == cat },
                onSelect = { lm ->
                    nav.navigate(
                        "map/${lm.name}/${lm.latLng.latitude}/${lm.latLng.longitude}/${lm.address}"
                    )
                },
                onBack = { nav.popBackStack() }
            )
        }

        composable(
            route = "map/{name}/{lat}/{lng}/{addr}",
            arguments = listOf(
                navArgument("name") { defaultValue = "" },
                navArgument("lat") { type = NavType.FloatType },
                navArgument("lng") { type = NavType.FloatType },
                navArgument("addr") { defaultValue = "" }
            )
        ) { back ->
            MapScreen(
                name = back.arguments!!.getString("name")!!,
                address = back.arguments!!.getString("addr")!!,
                lat = back.arguments!!.getFloat("lat").toDouble(),
                lng = back.arguments!!.getFloat("lng").toDouble(),
                onBack = { nav.popBackStack() }
            )
        }
    }
}
