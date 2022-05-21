package id.camy.tabunganku.history

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.camy.tabunganku.local.Tabung
import id.camy.tabunganku.local.TabungRepository

class HistoryViewModel(application: Application) : ViewModel() {
    private val mTabungRepository = TabungRepository(application)

    fun getAllTabung(): LiveData<List<Tabung>> = mTabungRepository.getAllTabung()

}