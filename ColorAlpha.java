
public class ColorAlpha {
    public final Color color;
    public final Integer A;

    public ColorAlpha(Color color, Integer A) {
        // TODO: reduce code duplication
        if ((A < 0) || (A > 255)) {
            String error;
            error = "A should be between 0 and 255, got " + A + " instead.";
            throw new IllegalArgumentException(error);
          }
        this.color = color;
        this.A = A;
    }

    public ColorAlpha(Integer R, Integer G, Integer B, Integer A) {
        this(new Color(R, G, B), A);
    }

    public ColorAlpha(String hexString) {
        if (hexString.length() != 9) {
            throw new IllegalArgumentException("invalid : hexString should have a length of 9.");
        }
        this.color = new Color(hexString.substring(0, 7));
        hexString = hexString.toLowerCase();
        for (int i=6; i <= 8; i++) {
            if ("0123456789abcdef".indexOf(hexString.charAt(i)) == -1) {
                throw new IllegalArgumentException("invalid character in hexString.");
            }
        }
        this.A = Integer.parseInt(hexString.substring(7, 9), 16);

    }

    public String toString() {
        String string = color.toString();
        string = string.substring(0, string.length() - 1);
        string += "," + A + ")";
        return string;
    }

    public String toHexString() {
        return color.toHexString() + Color.channelToHex(this.A);
    }
}