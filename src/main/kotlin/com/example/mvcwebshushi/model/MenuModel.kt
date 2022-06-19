package com.example.mvcwebshushi.model

import com.example.mvcwebshushi.dbcontext.ConnectDB
import com.example.mvcwebshushi.entity.Menu
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class MenuModel {
    private val db: ConnectDB = ConnectDB()

    @Throws(Exception::class)
    fun getMenusFromTo(page: Int, pageSize: Int): List<Menu> {
        val from = page * pageSize - (pageSize - 1)
        val to = page * pageSize
        val menus: MutableList<Menu> = ArrayList()
        val query =
            "select * from (" + "select *, ROW_NUMBER() over (order by id) as rownumber from Menu" + ") as menus " + "where menus.rownumber >= ? and menus.rownumber <=?"
        var conn: Connection? = null
        var ps: PreparedStatement? = null
        var rs: ResultSet? = null
        try {
            conn = db.open()
            ps = conn?.prepareStatement(query)
            ps?.setInt(1, from)
            ps?.setInt(2, to)
            rs = ps?.executeQuery()
            rs?.let {
                while (rs.next()) {
                    val id = rs.getInt(1)
                    val name = rs.getString(2)
                    val content = rs.getString(3)
                    val price = rs.getFloat(4)
                    menus.add(Menu(id, name, content, price))
                }
            }
        } catch (ex: Exception) {
            throw ex
        } finally {
            db.close(conn, ps, rs)
        }
        return menus
    }

    @get:Throws(Exception::class)
    val totalRows: Int
        get() {
            var rows = 0
            var conn: Connection? = null
            var ps: PreparedStatement? = null
            var rs: ResultSet? = null
            val query = "select count(*) from Menu"
            try {
                conn = db.open()
                ps = conn?.prepareStatement(query)
                rs = ps?.executeQuery()
                rs?.let {
                    while (rs.next()) {
                        rows = rs.getInt(1)
                    }
                }
            } catch (ex: Exception) {
                throw ex
            } finally {
                db.close(conn, ps, rs)
            }
            return rows
        }
}
