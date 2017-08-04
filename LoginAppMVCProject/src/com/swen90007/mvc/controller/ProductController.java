package com.swen90007.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swen90007.mvc.model.Product;
import com.swen90007.mvc.service.ProductInformationService;

@WebServlet("/product.html")
public class ProductController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ProductInformationService pis;

    public void init() throws ServletException {
	super.init();
	pis = new ProductInformationService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException {
	
	String type = request.getParameter("type");
	List<Product> products = pis.getProductListByType(type);

	request.setAttribute("products", products);
	request.setAttribute("category", type);
	
	RequestDispatcher dispatcher = (RequestDispatcher) request.getRequestDispatcher("WEB-INF/views/productsdetails.jsp");
	dispatcher.forward(request, response);
    }
}
