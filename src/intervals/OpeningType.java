package intervals;

public abstract class OpeningType {
    abstract Opening getTypeCode();

    public static OpeningType newType(Opening type) {
        switch (type) {
        case BOTH_OPENED:
            return new BothOpened();
        case LEFT_OPENED:
            return new LeftOpened();
        case RIGHT_OPENED:
            return new RightOpened();
        case UNOPENED:
            return new UnOpened();
        default:
            throw new IllegalArgumentException("Incorrect type Opening");
        }
    }
    public boolean includes(Interval interval, double value) {
        switch (interval.getType()) {
        case BOTH_OPENED:
            return value > interval.getMinimum() && value < interval.getMaximum();
        case LEFT_OPENED:
            return value > interval.getMinimum() && value <= interval.getMaximum();
        case RIGHT_OPENED:
            return value >= interval.getMinimum() && value < interval.getMaximum();
        case UNOPENED:
            return value >= interval.getMinimum() && value <= interval.getMaximum();
        }
        return false;
    }
    public boolean includes(Interval intervalClass, Interval interval) {
        switch (intervalClass.getType()) {
        case BOTH_OPENED:
            switch (interval.getType()) {
            case BOTH_OPENED:
                return intervalClass.getMinimum() <= interval.getMinimum() && intervalClass.getMaximum() >= interval.getMaximum();
            case LEFT_OPENED:
                return intervalClass.getMinimum() <= interval.getMinimum() && intervalClass.getMaximum() > interval.getMaximum();
            case RIGHT_OPENED:
                return intervalClass.getMinimum() < interval.getMinimum() && intervalClass.getMaximum() >= interval.getMaximum();
            case UNOPENED:
                return intervalClass.getMinimum() < interval.getMinimum() && intervalClass.getMaximum() > interval.getMaximum();
            }
            return false;
        case LEFT_OPENED:
            switch (interval.getType()) {
            case BOTH_OPENED:
                return intervalClass.getMinimum() <= interval.getMinimum() && intervalClass.getMaximum() >= interval.getMaximum();
            case LEFT_OPENED:
                return intervalClass.getMinimum() <= interval.getMinimum() && intervalClass.getMaximum() >= interval.getMaximum();
            case RIGHT_OPENED:
                return intervalClass.getMinimum() < interval.getMinimum() && intervalClass.getMaximum() >= interval.getMaximum();
            case UNOPENED:
                return intervalClass.getMinimum() < interval.getMinimum() && intervalClass.getMaximum() >= interval.getMaximum();
            }
            return false;
        case RIGHT_OPENED:
            switch (interval.getType()) {
            case BOTH_OPENED:
                return intervalClass.getMinimum() <= interval.getMinimum() && intervalClass.getMaximum() >= interval.getMaximum();
            case LEFT_OPENED:
                return intervalClass.getMinimum() <= interval.getMinimum() && intervalClass.getMaximum() > interval.getMaximum();
            case RIGHT_OPENED:
                return intervalClass.getMinimum() <= interval.getMinimum() && intervalClass.getMaximum() >= interval.getMaximum();
            case UNOPENED:
                return intervalClass.getMinimum() <= interval.getMinimum() && intervalClass.getMaximum() > interval.getMaximum();
            }
            return false;
        case UNOPENED:
            switch (interval.getType()) {
            case BOTH_OPENED:
                return intervalClass.getMinimum() <= interval.getMinimum() && intervalClass.getMaximum() >= interval.getMaximum();
            case LEFT_OPENED:
                return intervalClass.getMinimum() <= interval.getMinimum() && intervalClass.getMaximum() >= interval.getMaximum();
            case RIGHT_OPENED:
                return intervalClass.getMinimum() <= interval.getMinimum() && intervalClass.getMaximum() >= interval.getMaximum();
            case UNOPENED:
                return intervalClass.getMinimum() <= interval.getMinimum() && intervalClass.getMaximum() >= interval.getMaximum();
            }
            return false;
        }
        return false;
    }

}
