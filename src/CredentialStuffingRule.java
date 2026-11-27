public class CredentialStuffingRule {
    private static final int UNIQUE_USER_THRESHOLD = 4;

    public boolean evaluate(LogEntry entry, IpProfile profile) {
        if (entry == null || profile == null) {
            return false;
        }
        return false;
    }

    public String getRuleName() {
        return "CREDENTIAL_STUFFING";
    }
}