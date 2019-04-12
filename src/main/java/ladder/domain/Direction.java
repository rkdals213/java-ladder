package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Boolean.FALSE;
import static ladder.domain.BooleanGenerator.generatePoint;

public class Direction {
    private static final List<Direction> directions = new ArrayList<>();
    private final boolean left;
    private final boolean right;

    static {
        directions.add(new Direction(false, false));
        directions.add(new Direction(false, true));
        directions.add(new Direction(true, false));
    }

    private Direction(boolean left, boolean right) {
        if(left && right) {
            throw new IllegalStateException();
        }
        this.left = left;
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isCenter() {
        return !left && !right;
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction next() {
        if(this.right) {
            return next(FALSE);
        }

        return next(generatePoint());
    }

    public static Direction of(boolean first, boolean second) {
        if(!first && !second) {
            return directions.get(0);
        }
        if(!first && second) {
            return directions.get(1);
        }
        if(first && !second) {
            return directions.get(2);
        }
        return new Direction(first, second);
    }

    public static Direction first(boolean right) {
        return of(FALSE, right);
    }

    public Direction last() {
        return of(this.right, FALSE);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if((o == null) || getClass() != o.getClass()) return false;
        Direction pair = (Direction) o;
        return left == pair.left && right == pair.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return "Direction{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}