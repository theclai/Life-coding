package leetcode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SkypeCallAvgPerDay {
    /**
     * In real system, it has to be replaced with date
     */
    private static final String KEY = "today";
    /**
     * Key will the date, I am using string here
     */
    ConcurrentHashMap<String, LinkedHashMap<UUID, SkypeSession>> sessions;
    private int totalSession = 0;
    private int totalDuration = 0;
    private int avgDurationPerDay;

    public SkypeCallAvgPerDay() {
        sessions = new ConcurrentHashMap<>();
        avgDurationPerDay=0;
    }

    public SkypeSession addNewCall() {
        SkypeSession skypeSession = new SkypeSession();
        skypeSession.sessionId = UUID.randomUUID();
        skypeSession.startTime = System.currentTimeMillis();
        LinkedHashMap<UUID, SkypeSession> sess = sessions.get(KEY);
        if (sess == null) {
            sess = new LinkedHashMap<>();
        }
        sess.put(skypeSession.sessionId, skypeSession);
        sessions.put(KEY, sess);
        //update total session
        totalSession += 1;
        return skypeSession;
    }

    public void endCall(UUID sessionId) {
        //get all the sessions
        LinkedHashMap<UUID, SkypeSession> sess = sessions.get(KEY);
        // find the session with id
        SkypeSession skypeSession = sess.get(sessionId);
        // update the end time and duration
        skypeSession.endTime = System.currentTimeMillis();
        skypeSession.duration = skypeSession.calculateDuration(skypeSession.startTime, skypeSession.endTime);
        // total duration
        totalDuration += totalDuration + skypeSession.duration;
        // update avg duration
        avgDurationPerDay = totalDuration / totalSession;

    }

    @AllArgsConstructor
    @NoArgsConstructor
    class SkypeSession {
        @Setter
        @Getter
        private UUID sessionId;
        @Getter
        @Setter
        private long startTime;
        @Getter
        @Setter
        private long endTime;
        @Getter
        @Setter
        private long duration;

        public long calculateDuration(long start, long stop) {
            if (stop < start) throw new IllegalArgumentException("End time can not be before start");
            long duration = stop - start;
            return duration;
        }
    }
}
