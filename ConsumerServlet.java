//this is servlet file 
package appservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import appcode.BillLogic;

/**
 * Servlet implementation class ConsumerServlet
 */
public class ConsumerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsumerServlet() {
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
		doGet(request, response);

String consumerno = request.getParameter("consumerno");
		String consumername = request.getParameter("consumername");
		String previous = request.getParameter("pmonthreading");
		String current = request.getParameter("cmonthreading");
		String typeofcon = request.getParameter("connection");

		Long preLong = Long.parseLong(previous);
		Long currLong = Long.parseLong(current);

		BillLogic domesticbill = new BillLogic();
		BillLogic commercialbill = new BillLogic();

		float totalAmount = 0;

//		if (typeofcon == "domestic") {
//			long unitConsume1 = domesticbill.calculateUnitCnsume(currLong, preLong);
//			totalAmount = domesticbill.domesticBillAmount(unitConsume1);
//			System.out.println(totalAmount);
//		} else if (typeofcon == "commercial") {
//			long unitConsume2 = commercialbill.calculateUnitCnsume(currLong, preLong);
//			totalAmount = commercialbill.commercialBillAmount(unitConsume2);
//			System.out.println(totalAmount);
//		}

		switch (typeofcon) {
		case "domestic":
			long unitConsume1 = domesticbill.calculateUnitCnsume(currLong, preLong);
			totalAmount = domesticbill.domesticBillAmount(unitConsume1);
			break;
		case "commercial":
			long unitConsume2 = commercialbill.calculateUnitCnsume(currLong, preLong);
			totalAmount = commercialbill.commercialBillAmount(unitConsume2);
			break;
		default:
			System.out.println("Please Enter Valid Input!");
			break;
		}

		HttpSession session = request.getSession();
		session.setAttribute("consumerno", consumerno);
		session.setAttribute("consumername", consumername);
		session.setAttribute("billAmt", totalAmount);
		response.sendRedirect("billdisplay.jsp");


	}

}
