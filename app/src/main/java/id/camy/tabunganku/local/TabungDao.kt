package id.camy.tabunganku.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TabungDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(tabung: Tabung)

    @Update
    fun update(tabung: Tabung)

    @Delete
    fun delete(tabung: Tabung)

    @Query("SELECT * from tabung ORDER BY id ASC")
    fun getAllTabung(): LiveData<List<Tabung>>
}