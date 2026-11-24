public class IpProfile {
	private final String ipAddress;
	private int totalAttempts;
	private int successfulLogins;
	private long lastSeenTimestamp;
    private double averageIntervalMs;
    private boolean blocked;
    private double riskScore;

public IpProfile(String ipAddress) {
    this.ipAddress = ipAddress;
    this.totalAttempts = 0;
    this.failedAttempts = 0;
    this.successfulLogins = 0;
    this.lastSeenTimestamp = System.currentTimeMillis();
    this.averageIntervalMs = 0.0;
    this.blocked = false;
    this.riskScore = 0.0;
}
public String getIpAddress() {
    return ipAddress;
}


}