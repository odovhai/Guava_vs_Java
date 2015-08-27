package greet;

import com.google.common.collect.Range;

public class Greeting {

    private Range<Integer> timeRange;
    private String msg;
    private int priority;

    public static Greeting createGreeting(int low, int high, String msg, int priority) {
        return new Greeting(Range.closedOpen(low, high), msg, priority);
    }
    private Greeting(Range<Integer> timeRange, String msg, int priority) {
        this.timeRange = timeRange;
        this.msg = msg;
        this.priority = priority;
    }

    public Range<Integer> getTimeRange() {
        return timeRange;
    }

    public String getMsg() {
        return msg;
    }

    public int getPriority() {
        return priority;
    }
}
