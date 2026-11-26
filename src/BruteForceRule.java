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
        long timeDiff = entry.getTimestamp() - profile.getFirstAttemptTime();
        return profile.getFailedAttempts() >= MAX_FAILED_ATTEMPTS;
    }
}