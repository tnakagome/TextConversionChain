package nx.domain.tcc.converters.imap;

import org.apache.james.imap.api.display.CharsetUtil;

import nx.domain.tcc.AbstractConverter;

public class ModifiedUtf7Decoder extends AbstractConverter {
    public ModifiedUtf7Decoder() {
        super("ModifiedUtf7Decoder", "Modified UTF-7 (IMAP) → text");
        this.shortHelp = "Decode modified UTF-7 (IMAP) string to text";
    }

    @Override
    public String convert(String source) {
        return CharsetUtil.decodeModifiedUTF7(source);
    }
}
