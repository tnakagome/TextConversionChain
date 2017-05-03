package nx.domain.tcc.converters;

import nx.domain.tcc.AbstractConverter;

/**
 * This class does not do anything and return the input as is.
 * Use it to insert a separator in the pull-down menu. 
 */
public class Separator extends AbstractConverter {
    private static final String SEPARATOR = "&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;";

    public Separator() {
        super("Null", SEPARATOR);
    }

    @Override
    public String convert(String source) {
        return source;
    }
}
