
public class ColorAlpha {
    public final Integer R;
    public final Integer G;
    public final Integer B;
    public final Integer A;
    public final Color color;

    public ColorAlpha(Integer R, Integer G, Integer B, Integer A) {
        this(new Color(R, G, B), A);
    }

    public ColorAlpha(Color color, Integer A) {
        // TODO: reduce code duplication
        if ((A < 0) || (A > 255)) {
            String error;
            error = "A should be between 0 and 255, got " + A + " instead.";
            throw new IllegalArgumentException(error);
        }
        this.color = color;
        this.R = color.R;
        this.G = color.G;
        this.B = color.B;
        this.A = A;
    }

    public ColorAlpha(Color color) {
        this(color, 255);
    }

    public ColorAlpha(String hexString) {
        if (hexString.length() != 9) {
            throw new IllegalArgumentException("invalid : hexString should have a length of 9.");
        }
        this.color = new Color(hexString.substring(0, 7));
        this.R = this.color.R;
        this.G = this.color.G;
        this.B = this.color.B;
        hexString = hexString.toLowerCase();
        for (int i=6; i <= 8; i++) {
            if ("0123456789abcdef".indexOf(hexString.charAt(i)) == -1) {
                throw new IllegalArgumentException("invalid character in hexString.");
            }
        }
        this.A = Integer.parseInt(hexString.substring(7, 9), 16);

    }

    public String toString() {
        String string = this.color.toString();
        string = string.substring(0, string.length() - 1);
        string += "," + A + ")";
        return string;
    }

    public String toHexString() {
        return this.color.toHexString() + Color.channelToHex(this.A);
    }
}