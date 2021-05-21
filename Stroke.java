public class Stroke extends Attributes {

    // TODO: accept / check via Color

    // TODO: extra constructors


    public Stroke(
        String color,
        String dasharray,
        String dashoffset,
        String linecap,
        String linejoin,
        String miterlimit,
        String opacity,
        String width
        )
    {
        this.attributes.put("stroke", color);
        this.attributes.put("stroke-dasharray", dasharray);
        this.attributes.put("stroke-dashoffset", dashoffset);
        this.attributes.put("stroke-linecap", linecap);
        this.attributes.put("stroke-linejoin", linejoin);
        this.attributes.put("stroke-miterlimit", miterlimit);
        this.attributes.put("stroke-opacity", opacity);
        this.attributes.put("stroke-width", width);
    }

} 