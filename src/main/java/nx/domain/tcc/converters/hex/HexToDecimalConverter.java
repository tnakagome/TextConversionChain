package nx.domain.tcc.converters.hex;

import nx.domain.tcc.AbstractConverter;

/**
 * Interpret source as a hexadecimal number and convert it into a decimal number.
 */
public class HexToDecimalConverter extends AbstractConverter {
    public HexToDecimalConverter() {
        super("HexToDecimal", "hex → decimal");
        this.shortHelp = "Convert a hexadecimal number to a decimal number. Source number must not have 0x prefix.";
    }

    @Override
    public String convert(String source) {
        try {
            Long longValue = new Long(Long.parseLong(source, 16));
            return longValue.toString();
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
