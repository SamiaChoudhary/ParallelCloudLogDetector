public class BruteForceRuleTest {
    public static void main(String[] args) {
        BruteForceRule rule = new BruteForceRule();
        assert !rule.evaluate(null, null);

        LogEntry successEntry = new LogEntry("SUCCESS_LOGIN", 1000L);
        IpProfile highProfile = new IpProfile(100L, 10);
        assert !rule.evaluate(successEntry, highProfile);

        LogEntry failedEntry = new LogEntry("FAILED_LOGIN", 1000L);
        IpProfile belowThresholdProfile = new IpProfile(500L, 4);
        assert !rule.evaluate(failedEntry, belowThresholdProfile);
    }
}