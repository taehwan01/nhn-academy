public class Error {
    // 사용자 먼저 시작 여부 입력 오류
    public static void invalidFirstPlay() {
        throw new IllegalArgumentException(Constants.ERROR_INVALID_FIRST_PLAY);
    }

    // 사용자 좌표 입력 오류
    public static void invalidCoordinate() {
        throw new IllegalArgumentException(Constants.ERROR_INVALID_COORDINATE);
    }

    // 이미 수가 놓여진 좌표 입력 오류
    public static void alreadyTaken() {
        throw new IllegalArgumentException(Constants.ERROR_ALREADY_TAKEN);
    }
}
