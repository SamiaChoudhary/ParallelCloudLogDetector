public class LogEntry {
	public String ip;
	public int failedAttempts;
	public int intervalMs;
	public String status;
	public boolean isPoisonPill;
	public LogEntry(String ip, int failedAttempts, int intervalMs, String status) {
        this.ip = ip;
        this.failedAttempts = failedAttempts;
        this.intervalMs = intervalMs;
        this.status = status;
        this.isPoisonPill = false;
    }
}