<%-- 9a. Read all the existing records from the table coffee which is from the database test and delete
an existing coffee product from the table with its id and display the rest of the records using
HTML and JSP to get the field and display the results respectively--%>

<%@ page import="java.sql.*" %>
<%
    String id = request.getParameter("id");

    Connection conn = null;
    PreparedStatement deleteStmt = null;
    Statement selectStmt = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");

        // Delete if id is provided
        if (id != null) {
            String deleteQuery = "DELETE FROM coffee WHERE id = ?";
            deleteStmt = conn.prepareStatement(deleteQuery);
            deleteStmt.setInt(1, Integer.parseInt(id));
            int rowsDeleted = deleteStmt.executeUpdate();

            if (rowsDeleted > 0) {
                out.println("<p style='color:green;'>Coffee product deleted successfully.</p>");
            } else {
                out.println("<p style='color:red;'>No product found with the given ID.</p>");
            }
        }

        // Display all remaining records
        String selectQuery = "SELECT * FROM coffee";
        selectStmt = conn.createStatement();
        rs = selectStmt.executeQuery(selectQuery);
%>

<h2>Remaining Coffee Products</h2>
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
        try { if (deleteStmt != null) deleteStmt.close(); } catch (Exception e) {}
        try { if (selectStmt != null) selectStmt.close(); } catch (Exception e) {}
        try { if (conn != null) conn.close(); } catch (Exception e) {}
    }
%>
</table>
