public class Text extends Element {

    public Text(TextAttributes attributes, Node... children) { 
        super("text", attributes, children);
    }

    @Override
    public void setAttributes(Attributes attributes) {
        attributes = new TextAttributes(attributes);
        super.setAttributes(attributes);
    }
    
}