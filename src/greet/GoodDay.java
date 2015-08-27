package greet;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

import java.util.Set;

public class GoodDay {
    public static final String GREET_FORMAT = "Good %s, World";
    private static final Set<Greeting> RANGED_GREETINGS = ImmutableSet.of(
            Greeting.createGreeting(0, 2400, String.format(GREET_FORMAT, "night"), 0),
            Greeting.createGreeting(900, 1200, String.format(GREET_FORMAT, "morning"), 10),
            Greeting.createGreeting(1200, 1600, String.format(GREET_FORMAT, "day"), 10),
            Greeting.createGreeting(1330, 1400, String.format(GREET_FORMAT, "lunch"), 20),
            Greeting.createGreeting(1600, 2200, String.format(GREET_FORMAT, "evening"), 10)
    );

    public static final Ordering<Greeting> GREET_ORDER = new Ordering<Greeting>() {
        public int compare(Greeting g1, Greeting g2) {
            return Ints.compare(g1.getPriority(), g2.getPriority());
        }
    };

    public static String greet(int time) {
        return GREET_ORDER.max(Iterables.filter(RANGED_GREETINGS, greeting -> {
            return greeting.getTimeRange().contains(time);
        })).getMsg();
    }
}
