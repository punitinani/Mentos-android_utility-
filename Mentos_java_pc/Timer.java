
public class Timer {

    public int ClientId;

    Timer(int getId) {

        ClientId = getId;
        System.out.println("The id  is  " + ClientId);
        java.util.Timer timer = new java.util.Timer();

        StartBg j = new StartBg(ClientId);
        timer.schedule(j, 0,2000);

        System.out.println("\n\n\n");

    }

}
