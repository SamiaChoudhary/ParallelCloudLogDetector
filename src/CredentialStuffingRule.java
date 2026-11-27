public class CredentialStuffingRule {
    private static final int UNIQUE_USER_THRESHOLD = 5;

    public boolean evaluate(LogEntry entry, IpProfile profile) {
        if (entry == null || profile == null) {
            return false;
        }
        return profile.getUniqueUsernamesAttempted() >= UNIQUE_USER_THRESHOLD
                && profile.getFailedAttempts() >= UNIQUE_USER_THRESHOLD;
    }

    public String getRuleName() {
        return "CREDENTIAL_STUFFING";
    }
}