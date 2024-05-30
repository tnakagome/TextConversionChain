package nx.domain.tcc.converters;

import nx.domain.tcc.AbstractConverter;

public class LwsRemover extends AbstractConverter {
    public LwsRemover() {
        super("LwsRemover", "Remove linear white space chars");
        this.shortHelp = "Remove space, CR, LF, and TAB.";
    }
    @Override
    public String convert(String source) {
        return source.replaceAll("[ \r\n\t]+", "");
    }
}
