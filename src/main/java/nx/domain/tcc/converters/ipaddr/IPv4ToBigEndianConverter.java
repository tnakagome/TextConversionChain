package nx.domain.tcc.converters.ipaddr;

import java.net.Inet4Address;
import java.net.UnknownHostException;

import nx.domain.tcc.AbstractConverter;

public class IPv4ToBigEndianConverter extends AbstractConverter {
    public IPv4ToBigEndianConverter() {
        super("IPv4ToBigEndian", "IPv4 → big endian");
        this.shortHelp = "Convert an IPv4 address into big-endian hexadecimal striing.";
    }

    @Override
    public String convert(String source) {
        try {
            if (!source.matches("[0-9\\.]{1,15}"))
                throw new UnknownHostException();
            byte[] octets = Inet4Address.getByName(source).getAddress();
            return String.format("%02x%02x%02x%02x", octets[0], octets[1], octets[2], octets[3]);
        } catch (Exception e) {
            return null;
        }
    }
}
