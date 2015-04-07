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

}
