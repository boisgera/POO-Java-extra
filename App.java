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
    SVGAttributes svgAttributes = new SVGAttributes();
    svgAttributes.setXMLNS("http://www.w3.org/2000/svg");
    svgAttributes.setWidth("300");
    svgAttributes.setHeight("200");
    svgAttributes.setViewBox("0 0 300 200");

    // fuck, consider the Rect. The API verbosity is unbelievably shitty.
    // Lets do it anyway.
    Geometry geometry = new Geometry();
    geometry.setWidth("100");
    geometry.setHeight("100");
    Radii radii = new Radii();
    Fill fill = new Fill();
    fill.setColor("red");
    Stroke stroke = new Stroke();

    SVG svg = new SVG(svgAttributes,
        new Rectangle(geometry, radii, fill, stroke)
    );

    System.out.println(svg.toXML());
    svg.write("demo2.svg");
  }
}