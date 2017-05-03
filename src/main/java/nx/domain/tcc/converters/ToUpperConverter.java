package nx.domain.tcc.converters;

import nx.domain.tcc.AbstractConverter;

public class ToUpperConverter extends AbstractConverter {
    public ToUpperConverter() {
        super("ToUpper", "lower case → upper case");
        this.shortHelp = "Convert lower case characters to upper case.";
    }

    @Override
    public String convert(String source) {
        return source.toUpperCase();
    }
}
