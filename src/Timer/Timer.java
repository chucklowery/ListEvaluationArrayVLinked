package Timer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Timer {

    HashMap<TimeKey, Unit> results = new HashMap<>();
    long start = 0;
    long end = 0;
    TimeKey key;

    public void start(TimeKey key) {
        start = System.currentTimeMillis();
        this.key = key;
    }

    public void stop() {
        end = System.currentTimeMillis();
        long t = end - start;
        results.put(key, new Unit(key, t));
    }

    public Map<TimeKey, Unit> getResults() {
        return results;
    }

    public static class Unit implements TimeKey {

        Long time;
        TimeKey key;

        public Unit(TimeKey key, Long time) {
            this.time = time;
        }

        public Long getTime() {
            return time;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Unit)) {
                return false;
            }
            return ((Unit) o).key.equals(key);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(this.key);
        }
    }
}
