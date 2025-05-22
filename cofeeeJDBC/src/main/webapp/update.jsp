<%-- 8b. Read all the existing records from the table coffee which is from the database test and update an
existing coffee product in the table with its id. [Create a table coffee with fields
( id,coffee_name,price)] using HTML and JSP to get the fields and display the results respectively--%>

<%@ page import="java.sql.*" %>
<%
    String id = request.getParameter("id");
    String name = request.getParameter("coffee_name");
    String price = request.getParameter("price");

    Connection conn = null;
    PreparedStatement updateStmt = null;
    Statement selectStmt = null;
    ResultSet rs = null;

    try {
        // Load JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connect to MySQL database
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");

        // Update if form data is provided
        if (id != null && name != null && price != null) {
            String updateQuery = "UPDATE coffee SET coffee_name = ?, price = ? WHERE id = ?";
            updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setString(1, name);
            updateStmt.setDouble(2, Double.parseDouble(price));
            updateStmt.setInt(3, Integer.parseInt(id));
            int rowsUpdated = updateStmt.executeUpdate();

            if (rowsUpdated > 0) {
                out.println("<p style='color:green;'>Coffee product updated successfully.</p>");
            } else {
                out.println("<p style='color:red;'>No product found with the given ID.</p>");
            }
        }

        // Select all records from coffee
        String selectQuery = "SELECT * FROM coffee";
        selectStmt = conn.createStatement();
        rs = selectStmt.executeQuery(selectQuery);
%>

<h2>Coffee Products</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Coffee Name</th>
        <th>Price</th>
    </tr>
<%
    while (rs.next()) {
%>
    <tr>
        <td><%= rs.getInt("id") %></td>
        <td><%= rs.getString("coffee_name") %></td>
        <td><%= rs.getDouble("price") %></td>
    </tr>
<%
    }
    } catch (Exception e) {
        out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
    } finally {
        try { if (rs != null) rs.close(); } catch (Exception e) {}
        try { if (updateStmt != null) updateStmt.close(); } catch (Exception e) {}
        try { if (selectStmt != null) selectStmt.close(); } catch (Exception e) {}
        try { if (conn != null) conn.close(); } catch (Exception e) {}
    }
%>
</table>
