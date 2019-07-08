package ladder.domain;

public class Height {
    static final String ALERT_MINIMUM_LADDER_HEIGHT = "사다리의 최소 높이는 1입니다.";
    static final int MINIMUM_LADDER_HEIGHT = 1;

    private final int height;

    private Height(int inputHeight) {
        validationHeight(inputHeight);
        this.height = inputHeight;
    }

    public static Height from(int inputHeight) {
        return new Height(inputHeight);
    }

    private void validationHeight(int inputHeight) {
        if (inputHeight < MINIMUM_LADDER_HEIGHT) {
            throw new IllegalArgumentException(ALERT_MINIMUM_LADDER_HEIGHT);
        }
    }

    int getHeight() {
        return height;
    }
}