package nx.domain.tcc.converters;

import nx.domain.tcc.AbstractConverter;

public class ToLowerConverter extends AbstractConverter {
    public ToLowerConverter() {
        super("ToLower", "upper case → lower case");
        this.shortHelp = "Convert upper case characters to lower case.";
    }

    @Override
    public String convert(String source) {
        return source.toLowerCase();
    }
}
