public class BruteForceRule {
    private static final int MAX_FAILED_ATTEMPTS = 5;
    private static final long TIME_WINDOW_MS = 60000;
    private static final String FAILED_LOGIN_EVENT = "FAILED_LOGIN";

    public boolean evaluate(LogEntry entry, IpProfile profile) {
        if (entry == null || profile == null) {
            return false;
        }
        if (!FAILED_LOGIN_EVENT.equalsIgnoreCase(entry.getEventType())) {
            return false;
        }
        long elapsedTimeMs = entry.getTimestamp() - profile.getFirstAttemptTime();
        return elapsedTimeMs >= 0
                && elapsedTimeMs <= TIME_WINDOW_MS
                && profile.getFailedAttempts() >= MAX_FAILED_ATTEMPTS;
    }

    public String getRuleName() {
        return "BRUTE_FORCE_DETECTION";
    }
}