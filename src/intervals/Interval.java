package intervals;

public class Interval {

    private double minimum;

    private double maximum;

    private OpeningType type;

    public Interval(double minimum, double maximum, Opening opening) {
        this.minimum = minimum;
        this.maximum = maximum;
        setType(opening);
    }

    public double midPoint() {
        return (maximum + minimum) / 2d;
    }

    public boolean includes(double value) {
        switch (getType()) {
        case BOTH_OPENED:
            return value > this.getMinimum() && value < this.getMaximum();
        case LEFT_OPENED:
            return value > this.getMinimum() && value <= this.getMaximum();
        case RIGHT_OPENED:
            return value >= this.getMinimum() && value < this.getMaximum();
        case UNOPENED:
            return value >= this.getMinimum() && value <= this.getMaximum();
        }
        return false;
    }

    public boolean includes(Interval interval) {
        switch (getType()) {
        case BOTH_OPENED:
            switch (interval.getType()) {
            case BOTH_OPENED:
                return this.minimum <= interval.minimum && this.maximum >= interval.maximum;
            case LEFT_OPENED:
                return this.minimum <= interval.minimum && this.maximum > interval.maximum;
            case RIGHT_OPENED:
                return this.minimum < interval.minimum && this.maximum >= interval.maximum;
            case UNOPENED:
                return this.minimum < interval.minimum && this.maximum > interval.maximum;
            }
            return false;
        case LEFT_OPENED:
            switch (interval.getType()) {
            case BOTH_OPENED:
                return this.minimum <= interval.minimum && this.maximum >= interval.maximum;
            case LEFT_OPENED:
                return this.minimum <= interval.minimum && this.maximum >= interval.maximum;
            case RIGHT_OPENED:
                return this.minimum < interval.minimum && this.maximum >= interval.maximum;
            case UNOPENED:
                return this.minimum < interval.minimum && this.maximum >= interval.maximum;
            }
            return false;
        case RIGHT_OPENED:
            switch (interval.getType()) {
            case BOTH_OPENED:
                return this.minimum <= interval.minimum && this.maximum >= interval.maximum;
            case LEFT_OPENED:
                return this.minimum <= interval.minimum && this.maximum > interval.maximum;
            case RIGHT_OPENED:
                return this.minimum <= interval.minimum && this.maximum >= interval.maximum;
            case UNOPENED:
                return this.minimum <= interval.minimum && this.maximum > interval.maximum;
            }
            return false;
        case UNOPENED:
            switch (interval.getType()) {
            case BOTH_OPENED:
                return this.minimum <= interval.minimum && this.maximum >= interval.maximum;
            case LEFT_OPENED:
                return this.minimum <= interval.minimum && this.maximum >= interval.maximum;
            case RIGHT_OPENED:
                return this.minimum <= interval.minimum && this.maximum >= interval.maximum;
            case UNOPENED:
                return this.minimum <= interval.minimum && this.maximum >= interval.maximum;
            }
            return false;
        }
        return false;
    }

    public boolean intersectsWith(Interval interval) {
        // TODO
        return false;
    }

    public Interval intersection(Interval interval) {
        // TODO
        return null;
    }

    @Override
    public String toString() {
        // TODO
        return null;
    }

    @Override
    public boolean equals(Object object) {
        // TODO
        return false;
    }

    public double getMinimum() {
        return minimum;
    }

    public void setMinimum(double minimum) {
        this.minimum = minimum;
    }

    public double getMaximum() {
        return maximum;
    }

    public void setMaximum(double maximum) {
        this.maximum = maximum;
    }

    public Opening getType() {
        return this.type.getTypeCode();
    }

    public void setType(Opening type) {
        switch (type) {
        case BOTH_OPENED:
            this.type= new BothOpened();
            break;
        case LEFT_OPENED:
            this.type = new LeftOpened();
            break;
        case RIGHT_OPENED:
            this.type =new RightOpened();
            break;
        case UNOPENED:
            this.type= new UnOpened();
            break;
        default:
            throw new IllegalArgumentException("Incorrect type Opening");
        }
    }
}
