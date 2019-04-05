package nx.domain.tcc.converters.ipaddr;

import nx.domain.tcc.AbstractConverter;

public class LittleEndianToIPv4Converter extends AbstractConverter {
    public LittleEndianToIPv4Converter() {
        super("LittleEndianToIPv4", "little endian → IPv4");
        this.shortHelp = "Convert little-endian hexadecimal (319ac40a) into IPv4 address (10.196.154.49).";
    }

    @Override
    public String convert(String source) {
        StringBuilder formattedValue = new StringBuilder(32);
        for (int count = 8 - source.length(); count > 0; count--)
            formattedValue.append('0');
        formattedValue.append(source);
        source = formattedValue.toString();

        StringBuilder buf = new StringBuilder(16);
        try {
            buf.insert(0, Integer.toString(Integer.parseInt(source.substring(0, 2), 16)));
            buf.insert(0, ".");
            buf.insert(0, Integer.toString(Integer.parseInt(source.substring(2, 4), 16)));
            buf.insert(0, ".");
            buf.insert(0, Integer.toString(Integer.parseInt(source.substring(4, 6), 16)));
            buf.insert(0, ".");
            buf.insert(0, Integer.toString(Integer.parseInt(source.substring(6, 8), 16)));
            return buf.toString();
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
