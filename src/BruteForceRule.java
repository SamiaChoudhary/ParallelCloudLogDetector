public class BruteForceRuleTest {
    public static void main(String[] args) {
        BruteForceRule rule = new BruteForceRule();
        assert !rule.evaluate(null, null);
        // Example test case for non-FAILED_LOGIN event
        LogEntry successEntry = new LogEntry("SUCCESS_LOGIN", 1000L);
        IpProfile profile = new IpProfile(100L, 10);
        assert !rule.evaluate(successEntry, profile);
    }
}