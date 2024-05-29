package nx.domain.tcc.converters.base64.encoders;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Base64.Encoder;

import nx.domain.tcc.AbstractConverter;
import nx.domain.tcc.Encoding;

public class AbstractEncoder extends AbstractConverter {
    private Charset charset = null;
    private Encoder encoder = null;

    public AbstractEncoder(final Encoding encoding) {
        super("Base64Encoder" + encoding.name, "text (" + encoding.name + ") → Base64");
        this.encoder   = Base64.getEncoder();
        this.shortHelp = "Encode " + encoding.name + " string using Base64 encoder";
        this.charset   = Charset.forName(encoding.name);
    }

    @Override
    public String convert(String source) {
        if (source == null || source.length() == 0) {
            return null;
        }
        return encoder.encodeToString(source.getBytes(charset));
    }

}
