/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashmir;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Dwiky-PC
 */
class DatabaseConnection {
    private static Connection con;
    private static DatabaseConnection dbc;
    private DatabaseConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cashmir","root","");
            
           
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
    public static DatabaseConnection getDatabaseConnection(){
        if(dbc==null)
        {
            dbc = new DatabaseConnection();
        }
        return dbc;
    }
    
    public static Connection getConnection()
    {
        return con;
    }
}
