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


public class SVGTutorial {

    public static String attrString(String[][] attributes) {
        String result = "";
        int n = attributes.length;
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

    public static String[][] kv(String[][] attributes, String key, String value) {
        int n = attributes.length;
        String[][] newAttributes = new String[n+1][];
        for (int i=0; i<n; i++) {
            newAttributes[i] = attributes[i];
        }
        String[] kv = {key, value};
        newAttributes[n] = kv;
        return newAttributes;
    }

    public static String[][] kv(String[][] attributes, String key, int value) {
        String val = str(value);
        return kv(attributes, key, val);
    }

    public static String[][] kv(String[][] attributes, String key, double value) {
        String val = str(value);
        return kv(attributes, key, val);
    }

    public static void checkAttributes(String[][] attributes) {
        for (String[] kv: attributes) {
            // TODO : test for null String[]
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

    public static void testErrors(String[] args) {
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

        // TODO: test for null instead of pair.
        // CJ: DONE. NullPointerException at runtime.

    }

    public static void app(String[] args) {
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

        String textContent = "SVG";
        if (args.length != 0) {
            textContent = "";
            for (int i=0; i < args.length; i++) {
                if (i > 0) {
                    textContent += " ";
                }
                textContent += args[i];
            }
        }

        String elt = svg(svgAttributes,
            rect(rectAttributes),
            circle(circleAttributes),
            text(textAttributes, 
                textContent
            )
        );
        write("demo1.svg", elt);
    }

    public static void appAlt(String[] args) {
        // Source: <https://developer.mozilla.org/fr/docs/Web/SVG/Tutorial>

        String[][] svgAttributes = {};
        svgAttributes = kv(svgAttributes, "version", "1.1");
        svgAttributes = kv(svgAttributes, "baseProfile", "full");
        svgAttributes = kv(svgAttributes, "width", 300);
        svgAttributes = kv(svgAttributes, "height", 200);
        svgAttributes = kv(svgAttributes, "xmlns", "http://www.w3.org/2000/svg");

        String[][] rectAttributes = {};
        rectAttributes = kv(rectAttributes, "width", "100%");
        rectAttributes = kv(rectAttributes, "height", "100%");
        rectAttributes = kv(rectAttributes, "fill", "red");
 
        String[][] circleAttributes = {};
        circleAttributes = kv(circleAttributes, "cx", 150);
        circleAttributes = kv(circleAttributes, "cy", 100);
        circleAttributes = kv(circleAttributes, "r", 80);
        circleAttributes = kv(circleAttributes, "fill", "green");

        String[][] textAttributes = {};
        textAttributes = kv(textAttributes, "x", 150);
        textAttributes = kv(textAttributes, "y", 125);
        textAttributes = kv(textAttributes, "font-size", 60);
        textAttributes = kv(textAttributes, "text-anchor", "middle");
        textAttributes = kv(textAttributes, "fill", "white");

        String textContent = "SVG";
        if (args.length != 0) {
            textContent = "";
            for (int i=0; i < args.length; i++) {
                if (i > 0) {
                    textContent += " ";
                }
                textContent += args[i];
            }
        }

        String elt = svg(svgAttributes,
            rect(rectAttributes),
            circle(circleAttributes),
            text(textAttributes, 
                textContent
            )
        );
        write("demo1.svg", elt);
    }

    public static void main(String[] args) {
        // testErrors(args);
        appAlt(args);
        //app(args);
    }
}
