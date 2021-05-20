
public class ColorAlpha {
    public final Integer R;
    public final Integer G;
    public final Integer B;
    public final Integer A;
    public final Color color;


    public ColorAlpha(Integer R, Integer G, Integer B, Integer A) {
        this.R = R;
        this.G = G;
        this.B = B;
        this.A = A;
        this.color = new Color(R, G, B);
    }

    public ColorAlpha(Color color, Integer A) {
        // TODO: reduce code duplication
        if ((A < 0) || (A > 255)) {
            String error;
            error = "A should be between 0 and 255, got " + A + " instead.";
            throw new IllegalArgumentException(error);
          }
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
        Color color = new Color(hexString.substring(0, 7));
        this.R = color.R;
        this.G = color.G;
        this.B = color.B;
        hexString = hexString.toLowerCase();
        for (int i=6; i <= 8; i++) {
            if ("0123456789abcdef".indexOf(hexString.charAt(i)) == -1) {
                throw new IllegalArgumentException("invalid character in hexString.");
            }
        }
        this.A = Integer.parseInt(hexString.substring(7, 9), 16);

    }

    public String toString() {
        String string = this.toColor().toString();
        string = string.substring(0, string.length() - 1);
        string += "," + A + ")";
        return string;
    }

    public String toHexString() {
        return this.toColor().toHexString() + Color.channelToHex(this.A);
    }
}