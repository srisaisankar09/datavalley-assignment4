package Assignment4;

import java.sql.*;
import java.util.*;
class patientinfodetail {

    static final String JDBC_URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    static final String USERNAME = "Replace_with_your_Username";
    static final String PASSWORD = "Replace_with_your_password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");

      
            conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            stmt = conn.createStatement();
            String sql = "SELECT patient_id, patient_name, problem, bill FROM patients";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("patient_id");
                String name = rs.getString("patient_name");
                String problem = rs.getString("problem");
                double bill = rs.getDouble("bill");

                System.out.println("Patient ID: " + id);
                System.out.println("Patient Name: " + name);
                System.out.println("Problem: " + problem);
                System.out.println("Bill: $" + bill);
                System.out.println("--------------------------------------");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
