<%--9b. Read all the existing records from the table coffee which is from the database test and query  coffee name starting with ‘D’ in the table using HTML and JSP to get the field and display the  results respectively--%>

<%@ page import="java.sql.*" %>
<%
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");

        stmt = conn.createStatement();
        String query = "SELECT * FROM coffee WHERE coffee_name LIKE 'D%'";
        rs = stmt.executeQuery(query);
%>

<h2>Coffee Products Starting with 'D'</h2>
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
        try { if (stmt != null) stmt.close(); } catch (Exception e) {}
        try { if (conn != null) conn.close(); } catch (Exception e) {}
    }
%>
</table>
