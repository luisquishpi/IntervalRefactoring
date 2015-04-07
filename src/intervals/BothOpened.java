package intervals;

public class BothOpened extends OpeningType {

    @Override
    Opening getTypeCode() {
        return Opening.BOTH_OPENED;
    }

    public boolean includes(Interval interval, double value) {
        return value > interval.getMinimum() && value < interval.getMaximum();
    }

    public boolean includes(Interval intervalClass, Interval interval) {
        switch (interval.getType()) {
        case BOTH_OPENED:
            return intervalClass.getMinimum() <= interval.getMinimum()
                    && intervalClass.getMaximum() >= interval.getMaximum();
        case LEFT_OPENED:
            return intervalClass.getMinimum() <= interval.getMinimum()
                    && intervalClass.getMaximum() > interval.getMaximum();
        case RIGHT_OPENED:
            return intervalClass.getMinimum() < interval.getMinimum()
                    && intervalClass.getMaximum() >= interval.getMaximum();
        case UNOPENED:
            return intervalClass.getMinimum() < interval.getMinimum()
                    && intervalClass.getMaximum() > interval.getMaximum();
        }
        return false;
    }

}
