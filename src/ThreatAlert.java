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
}