package com.example.mvcwebshushi.dbcontext

import com.example.mvcwebshushi.model.ArticleModel

fun main(args: Array<String>) {
    val article = ArticleModel()
    println("count=" + article.totalRows)
}
