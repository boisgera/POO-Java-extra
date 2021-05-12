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

    public static String element(
        String name, 
        String[][] attributes, 
        boolean indent, 
        String... children) 
    {
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

    public static void main(String[] args) {
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
        println(elt);
        write("demo1.svg", elt);
    }
}