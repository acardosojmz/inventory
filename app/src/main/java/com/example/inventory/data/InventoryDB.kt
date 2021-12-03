package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.inventory.data.dao.ArticleDAO
import com.example.inventory.data.entity.ArticleEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


@Database(entities = [ArticleEntity::class, ], version = 1)
abstract class InventoryDB : RoomDatabase() {

    abstract fun articleDao(): ArticleDAO

    companion object {
        @Volatile
        private var INSTANCE: InventoryDB? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): InventoryDB {
            //--- Ejecutar si la instancia no es nulo y devolver la instancia,
            //--- sino crear la base de datos
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    InventoryDB::class.java,
                    "inventory.dbf"
                )
                    //--- Limpia y reconstruye en lugar de migrar si no hay un objeto de migración
                    //--- Aqui no se revisa el tema de migración
                    .fallbackToDestructiveMigration()
                    .addCallback(InventoryDBCallback(scope))
                    .build()
                INSTANCE = instance
                //-- Devolver la instancia
                instance
            }
        }

        private class InventoryDBCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            /**
             * Override the onCreate method to populate the database.
             */
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                //--- Si se desea conservar los datos mediante reinicios de la aplicación,
                //--- comentar las siguientes líneas.
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populate(database.articleDao())
                    }
                }
            }
        }

        /**
         * Populate the database in a new coroutine.
         * If you want to start with more elements
         */
        suspend fun populate(articleDAO: ArticleDAO) {
            /*
            articleDAO.deleteAll()

            val quote = ArticleEntity( id=1,
                description = "Articulo de prueba",
                article = "Articulo XXXX",
                category = "Ninguno",
                brand = "Sin Marca",
                price = 0.0,
                image = ""

            )

            articleDAO.addArticle(quote).first()

             */

        }
    }
}