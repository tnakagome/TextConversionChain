package nx.domain.tcc.converters.url.encoders;

import java.net.URLEncoder;

import nx.domain.tcc.AbstractConverter;
import nx.domain.tcc.Encoding;

public class AbstractUrlEncoder extends AbstractConverter {
    final Encoding encoding;

    public AbstractUrlEncoder(final Encoding encoding) {
        super("UrlEncoder" + encoding.name, "text → URL encode (" + encoding.name + ")");
        this.encoding  = encoding;
        this.shortHelp = "URL-encode string using " + encoding.name + " character encoding.";
    }

    @Override
    public String convert(String source) {
        try {
            return URLEncoder.encode(source, encoding.name);
        } catch (Exception e) {
            return null;
        }
    }
}
