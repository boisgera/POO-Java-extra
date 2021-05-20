import java.lang.NullPointerException;
import java.util.Objects;

// TODO equals, hashCode

public class Color {
    public final Integer R;
    public final Integer G;
    public final Integer B;

    // TODO: reduce code duplication
    public Color(int R, int G, int B) {
      if ((R < 0) || (R > 255)) {
        String error;
        error = "R should be between 0 and 255, got " + R + " instead.";
        throw new IllegalArgumentException(error);
      }
      if ((G < 0) || (G > 255)) {
        String error;
        error = "G should be between 0 and 255, got " + G + " instead.";
        throw new IllegalArgumentException(error);
      }
      if ((B < 0) || (B > 255)) {
        String error;
        error = "B should be between 0 and 255, got " + B + " instead.";
        throw new IllegalArgumentException(error);
      }
      this.R = R;
      this.G = G;
      this.B = B;
    }
  
  @Override
  public boolean equals(Object other) {
      if (!(other instanceof Color)) {
          return false;
      }
      Color color = (Color) other;
      return (this.R == color.R) && (this.G == color.G) && (this.B == color.B);
  }

  @Override
  public int hashCode() {
      return Objects.hash(this.R, this.G, this.B);
  }

  public Color(String hexString) {
      Color color = Color.parseHexString(hexString);
      this.R = color.R;
      this.G = color.G;
      this.B = color.B;
  }

  public static Color parseHexString(String hexString) {
      if (hexString.length() != 7) {
          throw new IllegalArgumentException("invalid : hexString should have a length of 7.");
      } else if (hexString.charAt(0) != '#') {
          throw new IllegalArgumentException("invalid : hexString should start with a '#'.");
      } else {
          hexString = hexString.toLowerCase();
          for (int i=1; i <= 6; i++) {
              if ("0123456789abcdef".indexOf(hexString.charAt(i)) == -1) {
                  throw new IllegalArgumentException("invalid character in hexString.");
              }
          }
      }
      int R = Integer.parseInt(hexString.substring(1, 3), 16);
      int G = Integer.parseInt(hexString.substring(3, 5), 16);
      int B = Integer.parseInt(hexString.substring(5, 7), 16);
      return new Color(R, G, B);
  }

  public static String channelToHex(Integer integer) {
    String string = Integer.toHexString(integer);
    if (string.length() == 1) {
      string = "0" + string;
    }
    return string;
  }

  public String toHexString() {
      return "#" + channelToHex(this.R) + channelToHex(this.G) + channelToHex(this.B);
  }

  public String toString() {
    return "rgb(" + R.toString() + ", " + G.toString() + ", " + B.toString() + ")";
  }
}