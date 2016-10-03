
import java.sql.Types;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author p_unit
 */
public class Core {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/mentos";
    private static final String USER = "root";
    private static final String PASS = "";
    private Connection conn = null;
    private Statement stmt = null;
    static int getIdConv;

    public boolean getConnected(int getId) {

//        Random rand  = new Random ();
//        int gen = rand.nextInt();
        getIdConv = getId;

        System.out.println("\n" + getId + "first");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            Thread th;
            th = new Thread() {

                public void run() {

                    try {
                        sleep(200);
                        System.out.println("Inside the query inserted method ");

                        System.out.println("Statement created ");

                        String query = "INSERT INTO entries "
                                + "(`id`, `device_id`, `status`, `command`)"
                                + " VALUES ('" + getIdConv + "','','0','0')";

                        stmt = conn.createStatement();

//                        stmt.setInt(1, getId);
//                        stmt.setString(2, "Pawan");
//                    stmt.setString(3, "Singh");
//                        stmt.setInt(4, 31);
                        stmt.executeUpdate(query);

                        System.out.println("Qquery executed");

                    } catch (InterruptedException | SQLException ex) {
                        Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            th.start();
            return true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;

    }

}
