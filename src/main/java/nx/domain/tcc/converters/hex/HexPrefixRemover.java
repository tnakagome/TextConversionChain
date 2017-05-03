package nx.domain.tcc.converters.hex;

import nx.domain.tcc.AbstractConverter;

/**
 * Remove all "0x" from source string.
 */
public class HexPrefixRemover extends AbstractConverter {

    public HexPrefixRemover() {
        super("Rmove0x", "Remove 0x");
        this.shortHelp = "Remove all \"0x\" from source string.";
    }

    @Override
    public String convert(String source) {
        return source.replace("0x", "");
    }

}
