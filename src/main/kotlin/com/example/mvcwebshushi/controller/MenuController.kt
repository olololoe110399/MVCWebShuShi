package com.example.mvcwebshushi.controller

import com.example.mvcwebshushi.model.ArticleModel
import com.example.mvcwebshushi.model.InfoModel
import com.example.mvcwebshushi.model.MenuModel
import java.io.IOException
import java.util.logging.Level
import java.util.logging.Logger
import javax.servlet.ServletException
import javax.servlet.http.*
import javax.servlet.annotation.*

@WebServlet(name = "menuController", value = ["/menu-controller"])
class MenuController : HttpServlet() {

    @Throws(ServletException::class, IOException::class)
    private fun processRequest(request: HttpServletRequest, response: HttpServletResponse) {
        response.contentType = "text/html;charset=UTF-8"
        try {
            var page = 1
            val pageSize = 2
            val menuModel = MenuModel()
            var totalPage = menuModel.totalRows
            if(request.getParameter("page")!=null){
                page = Integer.parseInt(request.getParameter("page"))
            }
            if(totalPage % pageSize == 0) {
                totalPage /= pageSize
            }else {
                totalPage =totalPage / pageSize + 1
            }

            if(page > totalPage){
                request.setAttribute("nonContent", "No menu here!")
            }else{
                request.setAttribute("content", menuModel.getMenusFromTo(page, pageSize))
            }
            request.setAttribute("page", page)
            request.setAttribute("totalPage", totalPage)
            request.setAttribute("active", "MenuColor")
            request.getRequestDispatcher("menu.jsp").forward(request, response)
        } catch (ex: java.lang.Exception) {
            Logger.getLogger(this::class.simpleName).log(Level.SEVERE, null, ex)
            response.sendRedirect("error.jsp")
        }
    }

    @Throws(ServletException::class, IOException::class)
    public override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        processRequest(request, response);
    }

    @Throws(ServletException::class, IOException::class)
    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        if (req != null && resp != null) {
            processRequest(req, resp);
        }
    }

    override fun getServletInfo() = "Short description"

    override fun destroy() {
    }
}