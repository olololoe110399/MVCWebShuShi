package com.example.mvcwebshushi.dbcontext

import java.sql.*
import java.util.logging.Level
import java.util.logging.Logger

class ConnectDB {
    private var connection: Connection? = null

    fun open(): Connection? {
        try {
            Class.forName(DatabaseInfo.DEVICE_NAME)
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.UNAME, DatabaseInfo.UPASS)
        } catch (ex: ClassNotFoundException) {
            Logger.getLogger(this::class.simpleName).log(Level.SEVERE, null, ex)
        } catch (ex: SQLException) {
            Logger.getLogger(this::class.simpleName).log(Level.SEVERE, null, ex)
        }
        return connection
    }

    @Throws(SQLException::class)
    fun close(conn: Connection?, ps: Statement?, rs: ResultSet?) {
        if (rs != null && !rs.isClosed) {
            rs.close()
        }
        if (ps != null && !ps.isClosed) {
            ps.close()
        }
        if (conn != null && !conn.isClosed) {
            conn.close()
        }
    }
}
