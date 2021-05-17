import static utils.Utils.*;

// <svg version="1.1"
//      baseProfile="full"
//      xmlns="http://www.w3.org/2000/svg">
//
//   <rect width="100%" height="100%" fill="red"/>
//
//   <circle cx="150" cy="100" r="80" fill="green"/>
//
//   <text x="150" y="125" font-size="60" text-anchor="middle" fill="white">SVG</text>
//
// </svg>

// TODO:
//
//   - Error handling in element (for attributes)
//
//   - Attributes adder (with several types for the value).

public class SVGTutorial {

    public static String[][] attrs(String allAttrs) {
        // TODO: "parse"; accept double or simple quotes (easier).
        return null;
    }

    public static String attrString(String[][] attributes) {
        String result = "";
        int n = length(attributes);
        for (int i=0; i<n; i++) {
            String[] kv = attributes[i];
            String key = kv[0];
            String value = kv[1];
            result += key + "=\"" + value + "\"";
            if (i<n-1) {
                result += " ";
            }
        }
        return result;
    }

    public static void checkAttributes(String[][] attributes) {
        for (String[] kv: attributes) {
            if (kv.length != 2) {
                String message = "attributes should contain pairs of strings. ";
                message += "One item of length " + kv.length + " != 2 has been found.";
                error(message);
            } else {
                for (String string: kv) {
                    if (string == null) {
                        String message = "attributes: null string found.";
                        error(message);
                    }
                }
            }

        }
    }

    public static String element(
        String name, 
        String[][] attributes, 
        boolean indent, 
        String... children) 
    {
        

        checkAttributes(attributes);

        String result = "";
        result += "<" + name + " " + attrString(attributes) + ">";
        for (String child: children) {
            if (indent) {
                result += "\n  ";
            }
            result += child;
        }
        if (indent) {
            result += "\n";
        }
        result += "</" + name + ">";
        return result;
    }

    public static String element(
        String name, 
        boolean indent, 
        String... children) 
    {
        String[][] noattrs = {};
        return element(name, noattrs, indent, children);
    }

    public static String element(
        String name, 
        String... children) 
    {
        return element(name, true, children);
    }

    public static String element(
        String name, 
        String[][] attributes, 
        String... children) 
    {
        return element(name, attributes, true, children);
    }

    public static String element(String name, String[][] attributes)
    {
        String[] noChildren = {};
        return element(name, attributes, false, noChildren);
    }

    public static String element(String name)
    {
        String[][] noAttrs = {};
        return element(name, noAttrs);
    }

    // TODO: fill the version, baseProfile and xmlns by default values ?
    public static String svg(String[][] attributes, String... children) {
        return element("svg", attributes, true, children);
    }

    public static String svg(String... children) {
        return element("svg", false, children);
    }

    public static String svg() {
        return element("svg");
    }

    public static String rect(String[][] attributes) {
        return element("rect", attributes);
    }
    public static String rect() {
        return element("rect");
    }

    public static String circle(String[][] attributes) {
        return element("circle", attributes);
    }
    public static String circle() {
        return element("circle");
    }

    public static String text(String[][] attributes, String... children) {
        return element("text", attributes, false, children);
    }

    public static String text(String... children) {
        return element("text", false, children);
    }

    public static String text() {
        return element("text");
    }

    public static void main1(String[] args) {
        String[][] rectAttributes1 = {
            {"width"},
            {"100%"}, 
            {"height"}, 
            {"100%"}, 
            {"fill"}, 
            {"red"}
        };
        
        // Without error handling: exception raised during execution:
        // ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1
        //
        // println(rect(rectAttributes1));

        String[][] rectAttributes2 = {
            {"width", "100%", "Euh, qu'est-ce que je fais là?"}, 
        };

        // Without error handling: third argument ignored
        //
        // println(rect(rectAttributes2));
        
        String[][] rectAttributes3 = {
            {"width", null}, 
        };

        // Without error handling: <rect width="null"></rect>
        //
        // println(rect(rectAttributes3));

    }

    public static void main2(String[] args) {
        // Source: <https://developer.mozilla.org/fr/docs/Web/SVG/Tutorial>
        String[][] svgAttributes = {
            {"version", "1.1"},
            {"baseProfile", "full"},
            {"width", "300"},
            {"height", "200"},
            {"xmlns", "http://www.w3.org/2000/svg"}
        };
        String[][] rectAttributes = {
            {"width", "100%"}, 
            {"height", "100%"}, 
            {"fill", "red"}
        };
        String[][] circleAttributes = {
            {"cx", "150"},
            {"cy", "100"},
            {"r", "80"}, 
            {"fill", "green"}
        };
        String[][] textAttributes = {
            {"x", "150"}, 
            {"y", "125"}, 
            {"font-size", "60"},
            {"text-anchor", "middle"},
            {"fill", "white"}
        };

        String elt = svg(svgAttributes,
            rect(rectAttributes),
            circle(circleAttributes),
            text(textAttributes, 
                "SVG"
            )
        );
        write("demo1.svg", elt);
    }

    public static void main(String[] args) {
        main1(args);
    }
}