package nx.domain.tcc.converters.imap;

import org.apache.james.imap.api.display.CharsetUtil;

import nx.domain.tcc.AbstractConverter;

public class ModifiedUtf7Encoder extends AbstractConverter {
    public ModifiedUtf7Encoder() {
        super("ModifiedUtf7Encoder", "text → Modified UTF-7 (IMAP)");
        this.shortHelp = "Encode text to modified UTF-7 format (IMAP)";
    }

    @Override
    public String convert(String source) {
        return CharsetUtil.encodeModifiedUTF7(source);
    }
}
