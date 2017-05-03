package nx.domain.tcc.converters.base64.encoders;

import java.util.Base64;
import java.util.Base64.Encoder;

import nx.domain.tcc.AbstractConverter;

public class Base64Encoder extends AbstractConverter {
    private Encoder encoder = null;

    public Base64Encoder() {
        super("Base64Encoder", "text (UTF-8) → Base64");
        this.encoder   = Base64.getEncoder();
        this.shortHelp = "Encode UTF-8 string using Base64 encoder.";
    }

    @Override
    public String convert(String source) {
        if (source == null || source.length() == 0) {
            return null;
        }
        return encoder.encodeToString(source.getBytes());
    }
}
