/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DriverRideManagementModule.Ride;
import PassengerRideManagementModule.Passenger;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author azada
 */
@WebServlet(name = "RequestSelectedRidesController", urlPatterns = {"/RequestSelectedRidesController"})
public class RequestSelectedRideController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String outcomeMessage = null;
        HttpSession session = request.getSession();
        Passenger p = (Passenger) session.getAttribute("passenger");
        
        if (p.getEmailID().equals(request.getParameter("driver_id"))){
            outcomeMessage = "Error! Can't request own ride";
        }
        else{
            boolean addSuccess = Ride.createRequest(Integer.parseInt(request.getParameter("selected_ride")), p.getEmailID(), request.getParameter("pickup_location"), request.getParameter("dropoff_location"));
            if (addSuccess) {
                outcomeMessage = "Successfully requested ride!";
            } else {
                outcomeMessage = "Error! Unable to request ride";
            }
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("RideRequestConfirmation.jsp");
        request.setAttribute("outcome_message", outcomeMessage);
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}