package nx.domain.tcc;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Converter registry
 */
public class Converters extends HashMap<String, AbstractConverter> {
    private static final long serialVersionUID = -6168747832595163772L;
    private LinkedList<String> selectorEntries;

    public Converters() {
        selectorEntries = new LinkedList<String>();
    }

    public void register(final AbstractConverter converter) {
        put(converter.signature, converter);
        selectorEntries.add(converter.signature);
    }

    public LinkedList<String> getSelectorEntries() {
        return selectorEntries;
    }
}
