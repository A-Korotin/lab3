public enum TonnelAngle {
    steep(101), flat(103);

    private final int code;
    TonnelAngle(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
