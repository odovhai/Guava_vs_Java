package greet;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

import java.util.Set;

public class GoodDay {


    public static final String GREET_FORMAT = "Good %s, World!";

    public static final Set<Greeting> RANGED_GREETINGS = ImmutableSet.of(
        Greeting.createGreeting(0, 2400, String.format(GREET_FORMAT, "Night"), 0),
        Greeting.createGreeting(900, 1200, String.format(GREET_FORMAT, "Morning"), 0),
        Greeting.createGreeting(1200, 1500, String.format(GREET_FORMAT, "Day"), 10),
        Greeting.createGreeting(1330, 1400, String.format(GREET_FORMAT, "Lunch"), 20)
    );

    public static final Ordering<Greeting> GREET_ORDER = new Ordering<Greeting>() {
        public int compare(Greeting left, Greeting right) {
            return Ints.compare(left.getPriority(), right.getPriority());
        }
    };

    public static String greet(int time) {
        return GREET_ORDER.max(Iterables.filter(RANGED_GREETINGS, greeting -> greeting.getTimeRange().contains(time))).getMsg();
    };
}
