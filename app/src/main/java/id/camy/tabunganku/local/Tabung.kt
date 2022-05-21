package id.camy.tabunganku.local

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Tabung(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "title")
    var jumlah: Int? = 0,

    @ColumnInfo(name = "story")
    var catatan: String? = null,

    @ColumnInfo(name = "date")
    var date: Long? = null
) : Parcelable