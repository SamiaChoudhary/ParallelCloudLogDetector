/**
 * Detects brute-force login attempts from a source IP within a configured time window.
 */
public class BruteForceRule {

    /** Minimum failed login attempts required to trigger brute-force detection. */
    private static final int MAX_FAILED_ATTEMPTS = 5;

    /** Time window in milliseconds within which failed attempts must occur. */
    private static final long TIME_WINDOW_MS = 60000;

    private static final String FAILED_LOGIN_EVENT = "FAILED_LOGIN";

    /**
     * Evaluates whether the incoming log entry and IP profile indicate a brute-force attack.
     *
     * @param entry   current log event
     * @param profile tracking profile for the source IP
     * @return {@code true} if brute-force threshold is met inside the time window, otherwise {@code false}
     */
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

    /**
     * Returns the identifier name of this detection rule.
     *
     * @return rule name string
     */
    public String getRuleName() {
        return "BRUTE_FORCE_DETECTION";
    }
}