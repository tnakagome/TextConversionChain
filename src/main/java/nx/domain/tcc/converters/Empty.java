package nx.domain.tcc.converters;

import nx.domain.tcc.AbstractConverter;

/**
 * This class does not do anything and return "&nbsp;".
 * This will be the first entry of each pulldown menu.
 */
public class Empty extends AbstractConverter {
    private static final String NBSP = "&nbsp;";

    public Empty() {
        super("Empty", NBSP);
    }

    @Override
    public String convert(String source) {
        return NBSP;
    }

}
