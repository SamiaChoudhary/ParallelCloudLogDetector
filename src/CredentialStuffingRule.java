public class CredentialStuffingRule {
    private static final String RULE_NAME = "CREDENTIAL_STUFFING";
    private static final int UNIQUE_USER_THRESHOLD = 10;

    public boolean evaluate(LogEntry entry, IpProfile profile) {
        if (entry == null || profile == null) {
            return false;
        }
        return hasEnoughUniqueUsers(profile)
                && profile.getFailedAttempts() >= UNIQUE_USER_THRESHOLD;
    }

    private boolean hasEnoughUniqueUsers(IpProfile profile) {
        return profile.getUniqueUsernamesAttempted() >= UNIQUE_USER_THRESHOLD;
    }

    public String getRuleName() {
        return RULE_NAME;
    }
}