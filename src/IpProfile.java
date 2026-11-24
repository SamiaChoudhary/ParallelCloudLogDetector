public class IpProfile {
    private final String ipAddress;
    private int totalAttempts;
    private int failedAttempts;
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
    public int getTotalAttempts() {
        return totalAttempts;
    }
    public int getFailedAttempts() {
        return failedAttempts;
    }
    public int getSuccessfulLogins() {
        return successfulLogins;
    }
    public long getLastSeenTimestamp() {
        return lastSeenTimestamp;
    }
    public double getAverageIntervalMs() {
        return averageIntervalMs;
    }
    public boolean isBlocked() {
        return blocked;
    }
    public double getRiskScore() {
        return riskScore;
    }
    public void recordAttempt(boolean isFailed, int intervalMs) {
        if (this.totalAttempts == 0) {
            this.averageIntervalMs = intervalMs;
        } else {
            this.averageIntervalMs = ((this.averageIntervalMs * this.totalAttempts) + intervalMs) / (this.totalAttempts + 1);
        }
        this.totalAttempts++;
        if (isFailed) {
            this.failedAttempts++;
        } else {
            this.successfulLogins++;
        }
        this.lastSeenTimestamp = System.currentTimeMillis();
    }
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
    public void setRiskScore(double riskScore) {
        this.riskScore = riskScore;
    }
    public double getFailureRate() {
        if (totalAttempts == 0) return 0.0;
       return (failedAttempts * 100.0) / totalAttempts;
    }
    public boolean isHighRisk() {
        return riskScore >= 75.0 || getFailureRate() >= 80.0;
    }
    public void resetCounters() {
        this.totalAttempts = 0;
        this.failedAttempts = 0;
        this.successfulLogins = 0;
        this.averageIntervalMs = 0.0;
        this.riskScore = 0.0;
    }
    @Override
    public String toString() {
        return "IpProfile{ip='" + ipAddress + "', failed=" + failedAttempts + "/" + totalAttempts + ", risk=" + riskScore + "}";
    }
}