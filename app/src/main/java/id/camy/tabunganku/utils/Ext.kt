package id.camy.tabunganku.utils

import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

object Ext {

    fun toRp(total: Int): String {
        val invoiceString = total.toString() + ""
        val rupiahFormat = NumberFormat.getInstance(Locale.CANADA)
        return ("Rp. "
                + rupiahFormat.format(invoiceString.toDouble()).replace(",", "."))
    }

    fun toDate(date: Long): String? {
        val sDate = date.toString()
        val fmt = SimpleDateFormat("dd MMMM yyyy")
        return fmt.format(Date(if (sDate.length == 10) date * 1000 else date))
    }
}