public class BruteForceRule {
    private static final int MAX_FAILED_ATTEMPTS = 5;
    private static final long TIME_WINDOW_MS = 60000;

    public boolean evaluate(LogEntry entry, IpProfile profile) {
        if (entry == null || profile == null) {
            return false;
        }
        if (!"FAILED_LOGIN".equalsIgnoreCase(entry.getEventType())) {
            return false;
        }
        long currentTime = entry.getTimestamp();
        long firstAttemptTime = profile.getFirstAttemptTime();
        return false;
    }
}