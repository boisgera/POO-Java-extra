import java.lang.System;
import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    SVGAttributes svgAttributes = new SVGAttributes("full", null, null, "300", null, "1.1", "0 0 400 300", "400", null, null);
    SVG svg = new SVG(svgAttributes);
    System.out.println(svg.toXML());
    svg.write("demo2.svg");
  }
}