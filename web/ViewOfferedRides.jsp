<%-- 
    Document   : ViewConfirmedRides
    Created on : Apr 2, 2020, 9:34:20 PM
    Author     : reem
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmed Rides</title>
    </head>
    <body>
        <h1> Confirmed Rides of User ${sessionScope.driver.emailID} </h1>
        
        <table align="center" cellpadding="5" cellspacing="5" border="1">
            <tr>

            
            </tr>
            <tr bgcolor="#0EB39C">
                <td><b>Ride ID</b></td>
                <td><b>Is to Uni</b></td>
                <td><b>Arrival/Departure Time</b></td>
                <td><b>Start Location</b></td>
                <td><b>End Location</b></td>
                <td><b>Current Seat Availability</b></td>
                <td><b>View Confirmed Passengers</b></td>

            </tr>
            


                
            <c:forEach items="${singleRides}" var = "ride" >
                <tr bgcolor="#E2FFFB">
                    <td>${ride.rideId}</td>
                    <td>${ride.isToUni}</td>
                    <td>${ride.arrivalDepartureTime}</td>
                    <td>${ride.startingLocation}</td>
                    <td>${ride.endingLocation}</td>
                    <td>${ride.seatAvailability}</td>
                    <td><button style = "height : 50px; width : 180px" ><a href="ViewConfirmedPassengersController"> <font size = 3  >Select</font></a></button></td>
                        
                </tr>
            </c:forEach>

  
        </table>




    </body>
</html>
