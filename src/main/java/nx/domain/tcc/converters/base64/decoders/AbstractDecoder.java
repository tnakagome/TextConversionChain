package nx.domain.tcc.converters.base64.decoders;

import java.util.Base64;
import java.util.Base64.Decoder;

import nx.domain.tcc.AbstractConverter;
import nx.domain.tcc.Encoding;

abstract class AbstractDecoder extends AbstractConverter {
    private final Encoding encoding;
    private final Decoder  decoder;

    public AbstractDecoder(final Encoding encoding) {
        super("Base64Decoder" + encoding.name, "Base64 → text (" + encoding.name + ")");
        this.encoding  = encoding;
        this.decoder   = Base64.getDecoder();
        this.shortHelp = "Decode Base64 string and interpret as " + encoding.name + " encoding.";
    }

    @Override
    public String convert(String source) {
        if (source == null || source.length() == 0) {
            return null;
        }
        try {
            return new String(decoder.decode(source), encoding.name);
        } catch (Exception e) {
            return null;
        }
    }
}
