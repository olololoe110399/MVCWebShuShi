package com.example.mvcwebshushi.model

import com.example.mvcwebshushi.dbcontext.ConnectDB
import com.example.mvcwebshushi.entity.Article
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet


class ArticleModel {
    private val db: ConnectDB = ConnectDB()

    @Throws(Exception::class)
    fun getArticlesFromTo(page: Int, pageSize: Int): List<Article> {
        val from = page * pageSize - (pageSize - 1)
        val to = page * pageSize
        val articles: MutableList<Article> = ArrayList()
        val query =
            "select * from (" + "select *, ROW_NUMBER() over (order by id) as rownumber from Article" + ") as articles " + "where articles.rownumber >= ? and articles.rownumber <=?"
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
                    val title = rs.getString(2)
                    val imgLink = rs.getString(3)
                    val content = rs.getString(4)
                    val fullContent = rs.getString(5)
                    articles.add(Article(id, title, imgLink, content, fullContent))
                }
            }
        } catch (ex: Exception) {
            throw ex
        } finally {
            db.close(conn, ps, rs)
        }
        return articles
    }

    @Throws(Exception::class)
    fun getDetailsPost(id: Int): Article? {
        val query = "select * from Article where id = ?"
        var article: Article? = null
        var conn: Connection? = null
        var ps: PreparedStatement? = null
        var rs: ResultSet? = null
        try {
            conn = db.open()
            ps = conn?.prepareStatement(query)
            ps?.setInt(1, id)
            rs = ps?.executeQuery()
            rs?.let {
                while (rs.next()) {
                    article = Article(
                        id = rs.getInt(1),
                        title = rs.getString(2),
                        imgLink = rs.getString(3),
                        content = rs.getString(4),
                        fullContent = rs.getString(5),
                    )
                }
            }
        } catch (ex: Exception) {
            throw ex
        } finally {
            db.close(conn, ps, rs)
        }
        return article
    }

    @get:Throws(Exception::class)
    val totalRows: Int
        get() {
            var rows = 0
            var conn: Connection? = null
            var ps: PreparedStatement? = null
            var rs: ResultSet? = null
            val query = "select count(*) from Article"
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
