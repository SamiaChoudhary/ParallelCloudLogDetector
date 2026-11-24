import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
public class LogGenerator {
    public static void main(String[] args) {
    	String filePath = "cloud_logs.csv";
    	final int TOTAL_LOGS = 500000;
    	final int ATTACK_PERCENTAGE = 5;
        Random rand = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("IP_Address,Failed_Attempts,Interval_Ms,Status\n");
        }
        for (int i = 0; i < TOTAL_LOGS; i++) {
            String ip;
            int failedAttempts;
            int intervalMs;
            String status;
            
            if (rand.nextInt(100) < ATTACK_PERCENTAGE) {
                ip = "192.168.1." + (100 + rand.nextInt(15));
                failedAttempts = 12 + rand.nextInt(30);
                intervalMs = 15 + rand.nextInt(80);
                status = "FAILED";
            }
            else {
                ip = "10.0." + rand.nextInt(255) + "." + rand.nextInt(255);
                failedAttempts = rand.nextInt(4);
                intervalMs = 500 + rand.nextInt(5000);
                status = (failedAttempts > 2) ? "FAILED" : "SUCCESS";
            }
        }
    
        catch (IOException e) {
            System.err.println("Error generating logs: " + e.getMessage());
        }	
    }
}