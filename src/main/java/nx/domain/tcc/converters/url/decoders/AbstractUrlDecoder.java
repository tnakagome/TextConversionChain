package nx.domain.tcc.converters.url.decoders;

import java.net.URLDecoder;

import nx.domain.tcc.AbstractConverter;
import nx.domain.tcc.Encoding;

/**
 * Decode URL-encoded string using java.net.URLDecoder.decode(String s, String
 * enc)
 * <p>
 * The method will return invalid chars (e.g., multi-byte UTF-8 chars) as they
 * are.
 * <p>
 * http://docs.oracle.com/javase/8/docs/api/java/net/URLDecoder.html says:
 * <p>
 * <q>There are two possible ways in which this decoder could deal with illegal
 * strings. It could either leave illegal characters alone or it could throw an
 * IllegalArgumentException. Which approach the decoder takes is left to the
 * implementation.</q>
 */
abstract class AbstractUrlDecoder extends AbstractConverter {
    final Encoding encoding;

    public AbstractUrlDecoder(final Encoding encoding) {
        super("UrlDecoder" + encoding.name, "URL encoded (" + encoding.name + ") → text");
        this.encoding  = encoding;
        this.shortHelp = "Decode URL-encoded string. % encoded codes are interpreted as " + encoding.name + ".";
    }

    @Override
    public String convert(String source) {
        try {
            return URLDecoder.decode(source, encoding.name);
        } catch (Exception e) {
            return null;
        }
    }
}
