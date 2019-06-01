package org.koreanNotebook

expect class Platform() {
    val platform: String
}

class Greeting {
//    fun database() {
//        val driver: SqlDriver = AndroidSqliteDriver(Database.Schema, context, "test.db")
//        val database = Database(driver)
//
//        val playerQueries: PlayerQueries = database.playerQueries
//
//        println(playerQueries.selectAll().executeAsList())
//// Prints [HockeyPlayer.Impl(15, "Ryan Getzlaf")]
//
//        playerQueries.insert(player_number = 10, full_name = "Corey Perry")
//        println(playerQueries.selectAll().executeAsList())
//    }
    fun greeting(): String = "Hello, ${Platform().platform}"
}
