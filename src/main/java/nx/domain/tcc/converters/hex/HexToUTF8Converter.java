package nx.domain.tcc.converters.hex;

import nx.domain.tcc.AbstractConverter;
import nx.domain.tcc.Encoding;

/**
 * Treat a hexadecimal string as UTF-8 character codes and translate into a UTF-8 string.
 */
public class HexToUTF8Converter extends AbstractConverter {
    public HexToUTF8Converter() {
        super("HexToUTF8text", "hex → text (UTF-8)");
        this.shortHelp = "Treat a hexadecimal string as UTF-8 character codes and translate into a UTF-8 string.";
    }

    @Override
    public String convert(String source) {
        int valueLength = source.length();
        byte[] utf8Bytes = new byte[(valueLength / 2) + (valueLength % 2)];
        int currentIndex = 0;
        int bufIndex = 0;

        try {
            while (currentIndex < valueLength) {
                int endIndex = (currentIndex + 2 <= valueLength) ? (currentIndex + 2) : valueLength;
                String utf8CodeString = source.substring(currentIndex, endIndex);
                int utf8Code = Integer.parseInt(utf8CodeString, 16);
                utf8Bytes[bufIndex++] = (byte) (utf8Code & 0xff);
                currentIndex = endIndex;
            }
            return new String(utf8Bytes, Encoding.UTF8.name);
        } catch (Exception e) {
            return null;
        }
    }
}
