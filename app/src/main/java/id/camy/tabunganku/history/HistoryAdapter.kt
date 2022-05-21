package id.camy.tabunganku.history

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import id.camy.tabunganku.R
import id.camy.tabunganku.local.Tabung
import id.camy.tabunganku.utils.Ext.toDate
import id.camy.tabunganku.utils.Ext.toRp
import kotlinx.android.synthetic.main.view_history.view.*
import java.util.concurrent.Executors

class HistoryAdapter(private var data: List<Tabung>) : RecyclerView.Adapter<HistoryAdapter.Holder>() {

    fun setItems(data: List<Tabung>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_history, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(data[position], position)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(mData: Tabung, position: Int) {
            with(itemView) {
                tv_jumlah.text = toRp(mData.jumlah ?: 0)
                tv_catatan.text = mData.catatan
                tv_date.text = toDate(mData.date ?: 0L)
            }
        }
    }
}