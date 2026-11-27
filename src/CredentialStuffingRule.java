
public class CredentialStuffingRule {
	private static final int UNIQUE_USER_THRESHOLD = 4;
	public boolean evaluate(LogEntry entry, IpProfile profile) {
		
	}
	public String getRuleName() {
        return "CREDENTIAL_STUFFING";
    }

}
