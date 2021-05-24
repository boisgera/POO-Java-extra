import java.lang.System;
import java.util.ArrayList;
import java.util.List;

// <svg version="1.1"
//      baseProfile="full"
//      width="300" height="200"
//      xmlns="http://www.w3.org/2000/svg">
//   <rect width="100%" height="100%" fill="red" />
//   <circle cx="150" cy="100" r="80" fill="green" />
//   <text x="150" y="125" font-size="60" text-anchor="middle" fill="white">SVG</text>
// </svg>


public class App {
  public static void main(String[] args) {
    String[][] svgAttributesArray = {
      {"xmlns", "http://www.w3.org/2000/svg"},
      {"version", "1.1"},
      {"baseProfile", "full"},
      {"width", "300"},
      {"height", "200"},
      {"viewbox", "0 0 300 200"}
    };
    SVGAttributes svgAttributes = new SVGAttributes(svgAttributesArray);

    String[][] rectangleAttributesArray = {
      {"width", "100%"},
      {"height", "100%"},
      {"fill", "red"}
    };
    RectangleAttributes rectangleAttributes = new RectangleAttributes(rectangleAttributesArray);

    String[][] circleAttributesArray = {
      {"cx", "150"},
      {"cy", "100"},
      {"r", "80"},
      {"fill", "green"}
    };
    CircleAttributes circleAttributes = new CircleAttributes(circleAttributesArray);

    String[][] textAttributesArray = {
      {"x", "150"},
      {"y", "125"},
      {"font-size", "60"},
      {"text-anchor", "middle"},
      {"fill", "white"}
    };
    TextAttributes textAttributes = new TextAttributes(textAttributesArray);

 SVG svg = new SVG(svgAttributes,
        new Rectangle(rectangleAttributes),
        new Circle(circleAttributes),
        new Text(textAttributes, new TextNode("SVG"))
    );

    System.out.println(svg.toXML());
    svg.write("demo2.svg");
  }
}