package it.unisa.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.bean.Product;
import it.unisa.dao.ProductDAO;



@WebServlet(urlPatterns = {"", "/home"})
public class HomeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Crea un'istanza di ProductDAO
	    ProductDAO productDAO = new ProductDAO();

	    // Chiama il metodo getFavoritesProducts() per ottenere la lista di prodotti
	    List<Product> products = productDAO.getFavoritesProducts();
		
		
		request.setAttribute("products", products);	
	
		try {
			request.getRequestDispatcher("home.jsp").forward(request, response);
    	} catch (ServletException se) {
    		se.printStackTrace();
    	} catch (IOException e){
    		e.printStackTrace();
    	}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doGet(request, response);
    	} catch (ServletException se) {
    		se.printStackTrace();
    	} catch (IOException e){
    		e.printStackTrace();
    	}
	}

}
