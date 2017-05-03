package nx.domain.tcc.converters.ipaddr;

import nx.domain.tcc.AbstractConverter;

public class BigEndianlToIPv4Converter extends AbstractConverter {
    public BigEndianlToIPv4Converter() {
        super("BigEndianlToIPv4", "big endian → IPv4");
        this.shortHelp = "Convert big-endian hexadecimal string into IPv4 address.";
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
            buf.append(Integer.toString(Integer.parseInt(source.substring(0, 2), 16)));
            buf.append(".");
            buf.append(Integer.toString(Integer.parseInt(source.substring(2, 4), 16)));
            buf.append(".");
            buf.append(Integer.toString(Integer.parseInt(source.substring(4, 6), 16)));
            buf.append(".");
            buf.append(Integer.toString(Integer.parseInt(source.substring(6, 8), 16)));
            return buf.toString();
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
