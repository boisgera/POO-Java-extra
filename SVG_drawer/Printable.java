/**
 * Write a description of class Printable here.
 *
 * @author (Cyril JOLY)
 * @version (06/07/19)
 */
public abstract class Printable extends Picture
{
    abstract void translate(double x, double y);
    abstract void rotate(double angle);
    abstract void scale(double scale);
    protected abstract Printable makeCopy();
}
