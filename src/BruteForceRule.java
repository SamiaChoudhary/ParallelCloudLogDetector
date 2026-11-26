public class BruteForceRuleTest {
    public static void main(String[] args) {
        BruteForceRule rule = new BruteForceRule();
        assert !rule.evaluate(null, null);

        LogEntry boundaryEntry = new LogEntry("FAILED_LOGIN", 61000L);
        IpProfile boundaryProfile = new IpProfile(1000L, 5);
        assert rule.evaluate(boundaryEntry, boundaryProfile);
    }
}