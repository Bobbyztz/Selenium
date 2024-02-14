public class WaitSeconds {
    public static void wait(int seconds) {
            try {
                Thread.sleep(seconds* 1000L);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
}
