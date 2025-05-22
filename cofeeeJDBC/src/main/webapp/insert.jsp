<%-- 8a. Q1. Read all the existing records from the table coffee which is from the database test and insert a
new coffee product into it [Create a table coffee with fields ( id,coffee_name,price)] using HTML and
JSP to get the fields and display the results respectively--%>

<%@ page import="java.sql.*" %>
<%
    String id = request.getParameter("id");
    String name = request.getParameter("coffee_name");
    String price = request.getParameter("price");

    Connection conn = null;
    PreparedStatement insertStmt = null;
    Statement selectStmt = null;
    ResultSet rs = null;

    try {
        // Load JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connect to MySQL database
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");

        // Insert if form data is provided
        if (id != null && name != null && price != null) {
            String insertQuery = "INSERT INTO coffee (id, coffee_name, price) VALUES (?, ?, ?)";
            insertStmt = conn.prepareStatement(insertQuery);
            insertStmt.setInt(1, Integer.parseInt(id));
            insertStmt.setString(2, name);
            insertStmt.setDouble(3, Double.parseDouble(price));
            insertStmt.executeUpdate();
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
        out.println("Error: " + e.getMessage());
    } finally {
        try { if (rs != null) rs.close(); } catch (Exception e) {}
        try { if (insertStmt != null) insertStmt.close(); } catch (Exception e) {}
        try { if (selectStmt != null) selectStmt.close(); } catch (Exception e) {}
        try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
%>
</table>