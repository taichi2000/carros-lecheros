package cl.german;


public enum Cardinal {
    N("O", "E"),
    S("E", "O"),
    E("N", "S"),
    O("S", "N");

    private String left;
    private String right;


    Cardinal(String left, String right) {
        this.left = left;
        this.right = right;
    }


    public Cardinal left() {
        return Cardinal.valueOf(left);
    }


    public Cardinal right() {
        return Cardinal.valueOf(right);
    }
}
