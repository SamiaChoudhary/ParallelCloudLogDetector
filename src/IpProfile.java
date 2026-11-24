public class IpProfile {
	private final String ipAddress;
	private int totalAttempts;
	private int successfulLogins;
	private long lastSeenTimestamp;
    private double averageIntervalMs;
    private boolean blocked;
    private double riskScore;
}
public IpProfile(String ipAddress) {
    
}