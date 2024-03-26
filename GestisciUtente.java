package app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GestisciUtente
 */
@WebServlet("/SubmitFormServlet")
public class GestisciUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestisciUtente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		utente p1 = new utente();
		String nome = request.getParameter("name");
		String email = request.getParameter("email");
		p1.setNome(nome);
		p1.setEmail(email);
		request.setAttribute("user", p1);
		request.getRequestDispatcher("/risultato.jsp").forward(request, response);
		
		// creiamo l'oggetto context in cui andremo a salvare la lista degli utenti
        ServletContext context = getServletContext();
        // assegnmo a lista l'elemento preso dal context con nome lista
        ArrayList <utente> lista  = (ArrayList<utente>) context.getAttribute("lista");
        // se lista è null creiamo un nuovo arraylist
        if (lista == null) {
        	
            lista = new ArrayList<>();
        }
        // aggiungiamo lo user alla lista
        lista.add(p1);
        
        // Memorizza l'ArrayList nell'oggetto ServletContext
        context.setAttribute("lista", lista);
         
        
	}

}
