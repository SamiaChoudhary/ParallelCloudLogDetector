import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class ThreatAlert {
	private final String alertId;
	private final String sourceIp;
	private final String threatType;
	private final String severity;
	private final int failedCount;
	private final double riskScore;
	private final String timestamp;
    private boolean acknowledged;
    
    public ThreatAlert(String alertId, String sourceIp, String threatType, String severity, int failedCount, double riskScore) {
        this.alertId = alertId;
        this.sourceIp = sourceIp;
        this.threatType = threatType;
        this.severity = severity;
        this.failedCount = failedCount;
        this.riskScore = riskScore;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        this.acknowledged = false;
    }
    public String getAlertId() {
        return alertId;
    }
    public String getSourceIp() {
        return sourceIp;
    }
    public String getThreatType() {
        return threatType;
    }
    public String getSeverity() {
        return severity;
    }
    public int getFailedCount() {
        return failedCount;
    }
    public String getTimestamp() {
        return timestamp;
    }
    public boolean isAcknowledged() {
        return acknowledged;
    }
    public void markAcknowledged() {
        this.acknowledged = true;
    }
    public boolean isCritical() {
        return "CRITICAL".equalsIgnoreCase(this.severity) || this.riskScore >= 85.0;
    }
    public String toCsvRow() {
        return String.join(",", alertId, sourceIp, threatType, severity, String.valueOf(failedCount), String.valueOf(riskScore), timestamp);
    }
    
}