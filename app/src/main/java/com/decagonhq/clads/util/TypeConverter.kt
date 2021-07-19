package com.decagonhq.clads.util


import com.decagonhq.clads.data.domain.DeliveryAddressModel
import androidx.room.TypeConverter
import com.decagonhq.clads.data.domain.DressMeasurementModel
import com.decagonhq.clads.data.domain.client.DeliveryAddress
import com.decagonhq.clads.data.domain.client.Measurement
import com.google.gson.Gson




/**
 * Converts a list of type string to string to enable room
 * savings as room doesn't accept lists as a type
 */
class TypeConverter {
    @TypeConverter
    fun fromString(string: String?): List<String>? {
        return string?.split(",")?.map { it }
    }

    @TypeConverter
    fun toString(stringList: List<String>?): String? {
        return stringList?.joinToString(",")
    }

    @TypeConverter
    fun AddressListToJsonString(value: List<DeliveryAddressModel>?): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToAddressList(value: String) = Gson().fromJson(value, Array<DeliveryAddressModel>::class.java).toList()

    @TypeConverter
    fun MeasurementListToJsonString(value: List<com.decagonhq.clads.data.remote.client.Measurement>?): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToMeasurementList(value: String) = Gson().fromJson(value, Array<com.decagonhq.clads.data.remote.client.Measurement>::class.java).toList()
}
