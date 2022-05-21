package id.camy.tabunganku.tabung

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import id.camy.tabunganku.R
import id.camy.tabunganku.helper.ViewModelFactory
import id.camy.tabunganku.local.Tabung
import kotlinx.android.synthetic.main.activity_tabung.*

class TabungActivity : AppCompatActivity() {

    private lateinit var viewModel: TabungViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabung)

        viewModel = obtainViewModel(this)
        btn_simpan.setOnClickListener { onSave() }
    }

    private fun obtainViewModel(activity: AppCompatActivity): TabungViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(TabungViewModel::class.java)
    }

    private fun onSave(){
        val jumlah = edt_jumlah.text.toString()
        val catatan = edt_catatan.text.toString()

        if (jumlah.isEmpty()){
            Toast.makeText(this, "Silakan Masukkan jumlah tabungan", Toast.LENGTH_SHORT).show()
            return
        }
        if (catatan.isEmpty()){
            Toast.makeText(this, "Silakan Masukkan catatan tabungan", Toast.LENGTH_SHORT).show()
            return
        }

        val tabung = Tabung(jumlah = jumlah.toInt(), catatan = catatan, date = System.currentTimeMillis())
        viewModel.insert(tabung)

        val i = Intent().putExtra("DATA", 1)
        setResult(RESULT_OK, i)
        finish()
    }
}