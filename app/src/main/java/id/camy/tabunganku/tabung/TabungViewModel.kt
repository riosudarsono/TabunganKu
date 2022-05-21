package id.camy.tabunganku.tabung

import android.app.Application
import androidx.lifecycle.ViewModel
import id.camy.tabunganku.local.Tabung
import id.camy.tabunganku.local.TabungRepository

class TabungViewModel(application: Application) : ViewModel() {
    private val mTabungRepository = TabungRepository(application)

    fun insert(tabung: Tabung) {
        mTabungRepository.insert(tabung)
    }
}