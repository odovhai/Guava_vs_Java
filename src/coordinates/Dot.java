package coordinates;

import java.math.BigDecimal;

public class Dot {
    private BigDecimal x;
    private BigDecimal y;

    public Dot(BigDecimal x, BigDecimal y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dot dot = (Dot) o;

        if (x != null ? !x.equals(dot.x) : dot.x != null) return false;
        return !(y != null ? !y.equals(dot.y) : dot.y != null);

    }

    @Override
    public String toString() {
        return "{" + x.doubleValue() + ":" + y.doubleValue() + "}";
    }

    @Override
    public int hashCode() {
        int result = x != null ? x.hashCode() : 0;
        result = 31 * result + (y != null ? y.hashCode() : 0);
        return result;
    }

    public BigDecimal getX() {
        return x;
    }

    public void setX(BigDecimal x) {
        this.x = x;
    }

    public BigDecimal getY() {
        return y;
    }

    public void setY(BigDecimal y) {
        this.y = y;
    }
}
