package binar.academy.chapter6topic5.model


import com.google.gson.annotations.SerializedName

data class ProductColor(
    @SerializedName("colour_name")
    val colourName: String,
    @SerializedName("hex_value")
    val hexValue: String
)