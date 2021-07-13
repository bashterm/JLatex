package jlatex.content;

/**
 * Represents a floating point number as LaTeX content. The floating point
 * number can be rendered directly ({{@link Float#toString()}) or if necessary,
 * the format can be set by providing a {#link
 * {@link String#format(String, Object...)} style printf specifier.
 * 
 * @author Michael Oland
 *
 */
public class LatexFloat extends LatexNumber<Float,LatexFloat>
{
}
