package com.kawai.kawaiyim_comp304lab4.model

import com.google.android.gms.maps.model.LatLng

data class Landmark(
    val name: String,
    val address: String,
    val category: String,
    val latLng: LatLng
)
