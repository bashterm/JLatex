package jlatex.content;

/**
 * Represents a integer as LaTeX content. The integer
 * be rendered directly ({{@link Float#toString()}) or if necessary,
 * the format can be set by providing a {#link
 * {@link String#format(String, Object...)} style printf specifier.
 * 
 * @author Michael Oland
 *
 */
public class LatexInteger extends LatexNumber<Integer,LatexInteger>
{
}
