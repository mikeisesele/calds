package com.decagonhq.clads.ui.client.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal
@Parcelize
data class DressMeasurementModel(
    val measurementName: String,
    val measurement: BigDecimal
) : Parcelable