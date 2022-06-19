package com.example.mvcwebshushi.controller

import com.example.mvcwebshushi.model.InfoModel
import java.io.IOException
import java.util.logging.Level
import java.util.logging.Logger
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "infoController", value = ["/info-controller"])
class InfoController : HttpServlet() {
    @Throws(ServletException::class, IOException::class)
    private fun processRequest(request: HttpServletRequest, response: HttpServletResponse) {
        response.contentType = "text/html;charset=UTF-8"
        try {
            val model = InfoModel()
            val info = model.infoPage
            request.setAttribute("address", model.getAddress(info))
            request.setAttribute("tel", model.getTel(info))
            request.setAttribute("mail", model.getMail(info))
            request.setAttribute("openHours", model.getOpenHours(info))
            request.setAttribute("map", model.getUrlCover(info))
            request.setAttribute("active", "FindUsColor")
            request.getRequestDispatcher("findus.jsp").forward(request, response)
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