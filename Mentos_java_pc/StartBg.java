
import static java.lang.Thread.sleep;
import java.sql.*;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StartBg extends TimerTask {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/mentos";
    private static final String USER = "root";
    private static final String PASS = "";
    private static Connection conn = null;
    private static Connection conn1 = null;
    private static Statement stmt = null;
    public int ClietId;
    private boolean status = false;

    StartBg(int getId) {

        this.ClietId = getId;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn1 = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("In the constructor of the StartBg class ");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StartBg.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StartBg.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void run() {

        String sql1 = "";
        Statement stmt1 = null;
        int getCommand = 0;
        Thread t;

        try {

            stmt1 = conn1.createStatement();
            t = Thread.currentThread();

//            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            String sql = "SELECT * FROM entries "
                    + "WHERE id = '"
                    + ClietId + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int id = Integer.parseInt(rs.getString("status"));
                int command = Integer.parseInt(rs.getString("command"));

                if (id == 1) {

                    System.out.println("Status is  " + id);
                    switch (command) {
                        case 1:
                            System.out.println("System hybernate");
                            sleep(5000);
                            getCommand = 1;
                            Process p = Runtime.getRuntime().exec("shutdown -h -t 3");
                            System.exit(0);

                            break;

                        case 2:
                            System.out.println("System restart");
                            sleep(5000);
                            Process q = Runtime.getRuntime().exec("shutdown -r -t 3");
                            System.exit(0);
                            break;
                        case 3:
                            System.out.println("System shutdown ");
                            sleep(5000);
                            Process r = Runtime.getRuntime().exec("shutdown -s -t 3");
                            System.exit(0);
                            break;

                        default:
                            System.out.println("Default choice");
                            break;
                    }
                } else {

                    System.out.println("Id is 0 ");
                }
                System.out.println("\n\n\n\n");
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
