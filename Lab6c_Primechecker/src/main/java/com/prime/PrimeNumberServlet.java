// 6C.Build a servlet program to check the given number is prime number or not using HTML with step by step procedure. 

package com.prime;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PrimeServlet")
public class PrimeNumberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Check if number is prime
    public boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int number = Integer.parseInt(request.getParameter("number"));

        boolean result = isPrime(number);

        out.println("<html><head><title>Prime Result</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; display: flex; justify-content: space-around; margin-top: 50px; }");
        out.println(".card { border: 1px solid #ccc; padding: 20px; border-radius: 8px; width: 400px; }");
        out.println("h2 { margin-top: 0; }");
        out.println("</style></head><body>");

        out.println("<div class='card'>");
        out.println("<h2>Prime Number Checker Result</h2>");
        out.println("<p>Entered Number: <strong>" + number + "</strong></p>");
        if (result) {
            out.println("<p><strong>" + number + "</strong> is a <strong>Prime Number</strong>.</p>");
        } else {
            out.println("<p><strong>" + number + "</strong> is <strong>not</strong> a Prime Number.</p>");
        }
        out.println("<br><a href='input.html'>Check Another Number</a>");
        out.println("</div>");

        out.println("</body></html>");
    }
}
