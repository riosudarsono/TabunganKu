package id.camy.tabunganku.local

import android.app.Application
import androidx.lifecycle.LiveData
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class TabungRepository(application: Application) {
    private val mTabungDao: TabungDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = TabungRoomDatabase.getDatabase(application)
        mTabungDao = db.tabungDao()
    }

    fun getAllTabung(): LiveData<List<Tabung>> = mTabungDao.getAllTabung()

    fun insert(tabung: Tabung) {
        executorService.execute { mTabungDao.insert(tabung) }
    }

    fun delete(tabung: Tabung) {
        executorService.execute { mTabungDao.delete(tabung) }
    }

    fun update(tabung: Tabung) {
        executorService.execute { mTabungDao.update(tabung) }
    }
}