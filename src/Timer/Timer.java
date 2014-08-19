package Timer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Timer {

    HashMap<TimeKey, Unit> results = new HashMap<>();
    long start = 0;
    long end = 0;
    TimeKey key;

    public void start(TimeKey key) {
        start = System.nanoTime();
        this.key = key;
    }

    public void stop() {
        end = System.nanoTime();
        long t = end - start;
        addTime(key, t);
    }

    protected void addTime(TimeKey key, long time) {
        Unit unit = results.get(key);
        if (unit == null) {
            unit = new Unit(key);
            results.put(key, unit);
        }
        unit.addTime(time);
    }

    public Map<TimeKey, Unit> getResults() {
        return results;
    }

    public static class Unit implements TimeKey {

        private TimeKey key;
        private ArrayList<Long> times = new ArrayList<>();

        public Unit(TimeKey key) {
            this.key = key;
        }

        public void addTime(Long time) {
            times.add(time);
        }

        public Long getTime() {
            return sumTimes() / times.size();
        }

        protected long sumTimes() {
            long total = 0;
            for (long time : times) {
                total += time;
            }
            return total;
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
