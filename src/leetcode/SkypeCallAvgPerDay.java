package leetcode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class SkypeCallAvgPerDay {

    @AllArgsConstructor
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

        public void calculateDuration(long start, long stop) {
            this.duration = stop - start;
        }
    }
}
