package nx.domain.tcc;

/**
 * Base class for all converters.
 */
public abstract class AbstractConverter {
    /**
     * Converter ID; must be unique.
     */
    public final String signature;

    /**
     * Users will see this string in the browser pull down menu.
     */
    public final String displayString;

    /**
     * Appear as description in the usage.jsp page.
     * Subclass constructors should initialize this string.
     */
    protected String shortHelp;

    public AbstractConverter(final String signature, final String displayString) {
        this.signature     = signature;
        this.displayString = displayString;
    }

    /**
     * Apply conversion to input string (source) and return the result.
     * <P>Implementations should catch all exceptions and return null.
     * In case an exception is thrown, ConverterServlet will catch it and
     * show an error message indicating the type and source of exception.
     * Also, stack trace is written to the servlet container log for analysis.
     *
     * @param source
     * @return converted string.
     */
    public abstract String convert(final String source);

    public String getShortHelp() {
        return shortHelp;
    }
}
