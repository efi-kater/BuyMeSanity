package PagesUtils;

import java.sql.*;

public class DbUtils {
    private static final String USER_NAME = "sql12596781";
    private   static final String DATABASE_NAME = "sql12596781";
    private static final String PASSWORD = "V99tikqyKV";
    private static final String PORT = "3306";
    private static final String SERVER = "sql12.freemysqlhosting.net";

    private static Connection conn;

    public static void main(String[] args) {
        try {
            Connection c=getConnection();
            System.out.println(c);
            c.close();
        } catch (SQLException e){
            e.printStackTrace();
        }


    }

    public static Connection getConnection() throws SQLException {
      if (conn==null){
          conn = DriverManager.getConnection("jdbc:mysql://"+SERVER+":"+PORT, USER_NAME, PASSWORD);
          System.out.println(conn);

      }

        return conn;
}
    public void insertUser(Connection con, int id, String name, String data) throws SQLException {
        String statementToExecute = "INSERT INTO " + DATABASE_NAME + ".config_db (`config_id`, `config_name`,`config_data` ) VALUES ('" + id + "', '" + name + "', '" + data + "');";
        con.createStatement().execute(statementToExecute);
    }

    public static String getBrowser(Connection con) throws SQLException {
        String statementToExecute = "SELECT * FROM " + DATABASE_NAME + ".config_db;";
        String browser = "";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(statementToExecute);
        while(rs.next()){
            //Retrieve by column name
            int id  = rs.getInt("config_id");
            String name = rs.getString("config_name");
            String data = rs.getString("config_data");
            if (data.equalsIgnoreCase("chrome")){
                browser = data;
                break;
            }

        }
        rs.close();
        return browser;
    }

    public static String getSite(Connection con) throws SQLException {
        String statementToExecute = "SELECT * FROM " + DATABASE_NAME + ".config_db;";
        String browser = "";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(statementToExecute);
        while(rs.next()){
            //Retrieve by column name
            int id  = rs.getInt("config_id");
            String name = rs.getString("config_name");
            String data = rs.getString("config_data");
            if (data.equalsIgnoreCase("https://www.buyme.co.il")){
                browser = data;
                break;
            }

        }
        rs.close();
        return browser;
    }

    public int getHistoryLine(Connection con) throws SQLException {
        String statementToExecute = "SELECT * FROM " + this.DATABASE_NAME + ".history;";
        int line = 0;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(statementToExecute);
        while(rs.next()){
            //Retrieve by column name
            int id  = rs.getInt("test_id");
            line=id;

        }
        rs.close();
        return line;
    }
}
