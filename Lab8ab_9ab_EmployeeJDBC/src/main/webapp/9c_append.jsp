<!-- 9c. Develop a JDBC project using MySQL to append the fields empno, empname and basicsalary
into the table Emp of the database Employee by getting the fields through keyboard and Generate
the report as follows for the table Emp (Emp_NO , Emp_Name, Basicsalary ) using HTML and JSP
to get the field and display the results respectively-->
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Delete Employees and Show Report</title>
    <style>
        body {
            font-family: monospace;
        }
        .line {
            border-top: 1px solid #000;
            margin: 10px 0;
        }
    </style>
</head>
<body>
<h2>Delete Employees Whose Name Starts With Input Letter</h2>
<form method="post">
    Enter starting letter for deletion: <input type="text" name="start" maxlength="1" required />
    <input type="submit" value="Delete and Show Report" />
</form>

<%
    String start = request.getParameter("start");
    if (start != null && !start.trim().isEmpty()) {
        int deletedCount = 0;
        int grandTotal = 0;
%>
<pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                    Delete and Salary Report
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<%
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "");

            // Step 1: Delete employees whose name starts with the input letter
            PreparedStatement deleteStmt = conn.prepareStatement("DELETE FROM Emp WHERE Emp_Name LIKE ?");
            deleteStmt.setString(1, start + "%");
            deletedCount = deleteStmt.executeUpdate();

            out.println("Deleted " + deletedCount + " employee(s) whose name starts with '" + start + "'.");
            out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            // Step 2: Show remaining employees in Emp table
            PreparedStatement selectStmt = conn.prepareStatement("SELECT * FROM Emp");
            ResultSet rs = selectStmt.executeQuery();

            while (rs.next()) {
                int no = rs.getInt("Emp_NO");
                String name = rs.getString("Emp_Name");
                int salary = rs.getInt("Basicsalary");
                grandTotal += salary;
%>
Emp_No    : <%= no %>  
Emp_Name  : <%= name %>  
Basic     : <%= salary %>  
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<%
            }

            out.println("Grand Total Salary = " + grandTotal);
            out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            conn.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
%>
</pre>
<% } %>
</body>
</html>
