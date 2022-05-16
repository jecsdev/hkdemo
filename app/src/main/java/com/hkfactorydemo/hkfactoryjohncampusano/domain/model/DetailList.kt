package com.hkfactorydemo.hkfactoryjohncampusano.domain.model

import android.os.Parcel
import android.os.Parcelable

@kotlinx.serialization.Serializable
class DetailList(
    var productCode: String?,
    var productQuantity: Int,
    var productName: String?,
    var productPrice: Int,
    var subtotal: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(productCode)
        parcel.writeInt(productQuantity)
        parcel.writeString(productName)
        parcel.writeInt(productPrice)
        parcel.writeInt(subtotal)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DetailList> {
        override fun createFromParcel(parcel: Parcel): DetailList {
            return DetailList(parcel)
        }

        override fun newArray(size: Int): Array<DetailList?> {
            return arrayOfNulls(size)
        }
    }
}
