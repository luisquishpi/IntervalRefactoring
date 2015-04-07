package intervals;

public class Interval {

    private double minimum;

    private double maximum;

    private OpeningType _type;

    public Interval(double minimum, double maximum, Opening opening) {
        this.minimum = minimum;
        this.maximum = maximum;
        setType(opening);
    }

    public double midPoint() {
        return (maximum + minimum) / 2d;
    }

    public boolean includes(double value) {
        return _type.includes(this, value);
    }

    public boolean includes(Interval interval) {
        return _type.includes(this, interval);
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
        return this._type.getTypeCode();
    }

    public void setType(Opening type) {
        this._type = OpeningType.newType(type);
    }

}
