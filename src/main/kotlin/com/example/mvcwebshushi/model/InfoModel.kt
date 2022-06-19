package com.example.mvcwebshushi.model

import com.example.mvcwebshushi.dbcontext.ConnectDB
import com.example.mvcwebshushi.entity.Information
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class InfoModel {
    private val db: ConnectDB = ConnectDB()

    @get:Throws(Exception::class)
    val infoPage: ArrayList<Information>
        get() {
            val query = "select * from Information"
            var conn: Connection? = null
            var ps: PreparedStatement? = null
            var rs: ResultSet? = null
            val output = ArrayList<Information>()
            try {
                conn = db.open()
                ps = conn?.prepareStatement(query)
                rs = ps?.executeQuery()
                rs?.let {
                    while (rs.next()) {
                        val id = rs.getInt(1)
                        val name = rs.getString(2)
                        val content = rs.getString(3)
                        val i = Information(id, name, content)
                        output.add(i)
                    }
                }
            } catch (ex: Exception) {
                throw ex
            } finally {
                db.close(conn, ps, rs)
            }
            return output
        }

    @Throws(Exception::class)
    fun getAddress(info: List<Information>): String {
        for (i in info.indices) {
            if (info[i].name == "address") {
                return info[i].content
            }
        }
        return ""
    }

    @Throws(Exception::class)
    fun getTel(info: List<Information>): String {
        for (i in info.indices) {
            if (info[i].name == "tel") {
                return info[i].content
            }
        }
        return ""
    }

    @Throws(Exception::class)
    fun getMail(info: List<Information>): String {
        for (i in info.indices) {
            if (info[i].name == "mail") {
                return info[i].name + ":" + info[i].content
            }
        }
        return ""
    }

    @Throws(Exception::class)
    fun getOpenHours(info: List<Information>): List<String> {
        val days: MutableList<String> = ArrayList()
        for (i in info.indices) {
            if (info[i].name.contains("day")) {
                days.add(info[i].name + ": " + info[i].content)
            }
        }
        return days
    }

    @Throws(Exception::class)
    fun getUrlCover(info: List<Information>): String {
        for (i in info.indices) {
            if (info[i].name == "imgCover") {
                return info[i].content
            }
        }
        return ""
    }
}
