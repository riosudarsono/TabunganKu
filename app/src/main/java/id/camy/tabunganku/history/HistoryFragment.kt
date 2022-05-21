package id.camy.tabunganku.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.camy.tabunganku.R
import id.camy.tabunganku.helper.ViewModelFactory
import id.camy.tabunganku.tabung.TabungViewModel
import id.camy.tabunganku.utils.Ext.toRp
import kotlinx.android.synthetic.main.fragment_history.*


class HistoryFragment : Fragment() {

    private lateinit var viewModel: HistoryViewModel
    private lateinit var adapter: HistoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = HistoryAdapter(ArrayList())
        rv_history.adapter = adapter
        rv_history.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        viewModel = obtainViewModel(requireActivity() as AppCompatActivity)
        viewModel.getAllTabung().observe(requireActivity(), Observer {
            adapter.setItems(it)
            var saldo = 0
            for (item in it){
                saldo += item.jumlah ?: 0
            }
            tv_saldo.text = toRp(saldo)
        })
    }

    private fun obtainViewModel(activity: AppCompatActivity): HistoryViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(HistoryViewModel::class.java)
    }

}