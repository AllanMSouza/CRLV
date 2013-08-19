/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author allan
 */
public class Database {
    private final boolean KEEP_ALIVE = true;
    private static Database instancia = null;
    
    public static Database getInstance(){
        if(instancia == null){
            instancia = new Database();
        }
        
        return instancia;
    }
    
    private String host = "localhost";
    private String banco = "crlv";
    private String user = "root";
    private String senha = "toor";
    private String dbPath = "/home/allan/NetBeansProjects/CRLV/db/crlv";
    
    //private Connection con;
    
    public Connection abrirBanco(Connection con) throws ClassNotFoundException, SQLException{
        //System.out.println("jdbc:derby:"+dbPath);
        try {
            Properties props = new Properties();
            props.put("create", "false");
            props.put("user", user);
            props.put("password", senha);
            
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            con = DriverManager.getConnection("jdbc:derby:"+dbPath, props);
            con.createStatement().execute("set schema root");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return con;
    }
    
    public void fecharBanco(Connection con) throws SQLException {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized boolean testarConexao(Connection con) throws SQLException{
        boolean status = false;
        boolean conectado = false;
        
        if(KEEP_ALIVE){
            ResultSet rs = con.createStatement().executeQuery("select 1 from crlv");
            if(rs.next()){
                status = true;
                conectado = true;
            }
        }
        if(!conectado){
            try {
                abrirBanco(con);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return status;
    }
    
//    public Connection getConnection(){
//        return con;
//    }
    
   
            
    
}
