package id.camy.tabunganku.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Tabung::class], version = 1)
abstract class TabungRoomDatabase : RoomDatabase() {

    abstract fun tabungDao(): TabungDao

    companion object {
        @Volatile
        private var INSTANCE: TabungRoomDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): TabungRoomDatabase {
            if (INSTANCE == null) {
                synchronized(TabungRoomDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        TabungRoomDatabase::class.java, "tabung_database")
                        .build()
                }
            }
            return INSTANCE as TabungRoomDatabase
        }
    }
}
