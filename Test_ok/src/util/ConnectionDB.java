package util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/quanlynhansu";
    private static final String USERNAME = "hvt2503";
    private static final String PASSWORD = "hvt252003@gmail.com";

    //Mở kết nối
    public static Connection openConnection(){
        //1. Khởi tạo đối tượng connection
        Connection conn = null;
        try{
            //2. Set Driver kết nối với CSDL
            Class.forName(DRIVER);
            //3. Tạo đối tượng conn từ Driver Manager
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return conn;
    }
    //Đóng kết nối
    public static void closeConnection(Connection conn, CallableStatement callSt){
        if(conn != null){
            try{
                conn.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        if(callSt != null){
            try{
                callSt.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }

        }
    }
}
