package nx.domain.tcc.converters.hex;

import nx.domain.tcc.AbstractConverter;

/**
 * Interpret source as a decimal number and convert it into a hexadecimal number.
 */
public class DecimalToHexConverter extends AbstractConverter {
    public DecimalToHexConverter() {
        super("DecimalToHex", "decimal → hex");
        this.shortHelp = "Convert a decimal number to a hexadecimal number.";
    }

    @Override
    public String convert(String source) {
        try {
            long longValue = Long.parseLong(source, 10);
            return Long.toHexString(longValue);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
