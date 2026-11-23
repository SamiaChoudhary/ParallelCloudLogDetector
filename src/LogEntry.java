
public class LogEntry {
	@Override
    public String toString() {
        return isPoisonPill ? "POISON_PILL" : ip + " | Failed: " + failedAttempts + " | Interval: " + intervalMs + "ms | " + status;
    }
}
