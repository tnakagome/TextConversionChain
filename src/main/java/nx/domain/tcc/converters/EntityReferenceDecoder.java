package nx.domain.tcc.converters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nx.domain.tcc.AbstractConverter;

public class EntityReferenceDecoder extends AbstractConverter {
    private static Pattern DECIMAL_PATTERN     = Pattern.compile("&#(-?[0-9]{1,3});");
    private static Pattern HEXADECIMAL_PATTERN = Pattern.compile("&#x(-?[0-9a-z]{1,2});", Pattern.CASE_INSENSITIVE);

    public EntityReferenceDecoder() {
        super("DecodeEntityReference", "Entity references → bytes");
        this.shortHelp = "Decode entity references like \"&#nnn;\" and \"&#xnnn;\" into bytes (minus sign can be used).";
    }

    @Override
    public String convert(String source) {
        source = convertHexadecimal(source);
        if (source == null)
            return null;
        return convertDecimal(source);
    }

    private String convertHexadecimal(final String source) {
        StringBuilder buffer = new StringBuilder(100);
        int start = 0, end = 0;
        Matcher m = HEXADECIMAL_PATTERN.matcher(source);
        try {
            while (m.find(start)) {
                start = m.start();
                if (end < start)
                    buffer.append(source.substring(end, start));
                end = m.end();
                String hex = m.group(1);
                byte value = (byte)(Integer.parseInt(hex, 16) & 0xff);
                buffer.append(String.format("%02x", value));
                start = end;
            }
            return (buffer.length() == 0) ? source : buffer.toString();
        }
        catch (Exception e) {
            return null;
        }
    }

    private String convertDecimal(final String source) {
        StringBuilder buffer = new StringBuilder(100);
        int start = 0, end = 0;
        Matcher m = DECIMAL_PATTERN.matcher(source);
        try {
            while (m.find(start)) {
                start = m.start();
                if (end < start)
                    buffer.append(source.substring(end, start));
                end = m.end();
                byte value = Byte.parseByte(m.group(1), 10);
                buffer.append(String.format("%02x", value));
                start = end;
            }
            return (buffer.length() == 0) ? source : buffer.toString();
        }
        catch (Exception e) {
            return null;
        }
    }
}
