public class Fill extends Attributes {

    // TODO: accept / check via Color

    // TODO: extra constructors


    public Fill(
        String color,
        String opacity,
        String rule
        )
    {
        this.attributes.put("fill", color);
        this.attributes.put("fill-opacity", opacity);
        this.attributes.put("fill-rule", rule);

    }

}