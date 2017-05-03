package nx.domain.tcc.converters.hex;

import nx.domain.tcc.AbstractConverter;

/**
 * Convert UTF-8 encoded string into its hexadecimal representation.
 */
public class UTF8ToHexConverter extends AbstractConverter {
    private static final char[] lookupTable =
        { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

    public UTF8ToHexConverter() {
        super("UTF8TextToHex", "text (UTF-8) → hex");
        this.shortHelp = "Convert UTF-8 encoded string into its hexadecimal representation.";
    }

    @Override
    public String convert(String source) {
        if (source == null || source.length() == 0)
            return null;

        byte[] bytes = source.getBytes();
        StringBuilder buffer = new StringBuilder(bytes.length * 2);
        for (int index = 0; index < bytes.length; index++) {
            byte c = bytes[index];
            buffer.append(lookupTable[(c & 0xff) >>> 4]);
            buffer.append(lookupTable[(c & 0x0f)]);
        }
        return buffer.toString();
    }
}
