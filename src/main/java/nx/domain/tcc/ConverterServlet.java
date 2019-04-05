package nx.domain.tcc;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConverterServlet extends HttpServlet {
    private static final long serialVersionUID = -6236502161292657400L;

    private static final String HEADER1 =
            "<!doctype html>\n<HTML>\n<HEAD>\n<TITLE>Text Conversion Chain</TITLE>\n"
            + "<META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
            + "<LINK rel=stylesheet type=\"text/css\" href=\"style.css\">\n"
            + "<BODY>\n<H3>Enter a string in the text box, choose converters from pull-downs, and press convert.</H3>\n"
            + "<FORM method=\"post\" action=\"/tcc/form\" name=\"form1\" onsubmit=\"return validateFields();\">\n"
            + "<TABLE id=\"table1\" class=\"conversionTable\">\n"
            + "<COL class=\"rowHeader\"><COL class=\"converter\"><COL class=\"result\">"
            + "<TR><TD><CENTER>text</CENTER></TD>\n"
            + "<TD colspan=2><TEXTAREA name=\"text\" maxlength=\"";

    private static final String HEADER2 = "\" autofocus>";

    private static final String HEADER3 = "</TEXTAREA></TD></TR>\n"
            + "<TR><TH>#</TH><TH>Converter</TH><TH>Converted</TH></TR>\n";

    private static final String TRAILER = "<TR><TD colspan=\"3\"><CENTER>\n"
            + "<INPUT type=\"submit\" value=\"convert\">\n"
            + "<INPUT type=\"button\" value=\"clear\" onClick=\"clearFields()\">\n"
            + "</CENTER></TD></TR>\n</TABLE>\n</FORM>\n" + "<P><A href=\"usage.jsp\" target=\"usage\">usage</A>\n"
            + "<SCRIPT src=\"tcc.js\"></SCRIPT>\n</HEAD>\n"
            + "</BODY>\n</HTML>\n";

    private static final String NBSP           = "&nbsp;";

    private int        numConverters           = 10;
    private String     postDataLimit           = "1000";
    private String     dateTimeFormat          = "y/M/d H:m:s";
    private String     millisecDateTimeFormat  = "y/M/d H:m:s.SSS";
    private String     microsecDateTimeFormat  = "y/M/d H:m:s.nnnnnn";
    private Converters converters;

    public void init() throws ServletException {
        String param = getInitParameter("numConverters");
        if (param != null && param.length() > 0) {
            try {
                numConverters = Integer.parseInt(param);
            } catch (NumberFormatException e) {
                System.err.println("Failed to parse \"numConverters\" in web.xml. It must be a number.");
            }
        }
        param = getInitParameter("postDataLimit");
        if (param != null && param.length() > 0) {
            try {
                int value = Integer.parseInt(param);
                postDataLimit = String.format("%d", value);
            } catch (NumberFormatException e) {
                System.err.println("Failed to parse \"postDataLimit\" in web.xml. It must be a number.");
            }
        }
        param = getInitParameter("dateTimeFormat");
        if (param != null) {
            dateTimeFormat = param;
            millisecDateTimeFormat = param + ".nnn";
            microsecDateTimeFormat = param + ".nnnnnn";
        }

        // Referenced by clock converters and usage.jsp
        System.setProperty("dateTimeFormat",         dateTimeFormat);
        System.setProperty("millisecDateTimeFormat", millisecDateTimeFormat);
        System.setProperty("microsecDateTimeFormat", microsecDateTimeFormat);

        initConverters();
    }

    /**
     * Read a text file containing the list of class names,
     * instantiate each class, and register them in the converter map.
     * <p>
     * This will allow for configuration of converters to choose from
     * without rebuilding the application.
     *
     * @throws ServletException
     */
    private void initConverters() throws ServletException {
        converters = new Converters();
        String filename = getInitParameter("converterList");

        if (filename == null || filename.length() == 0) {
            throw new ServletException("init-param 'converterList' must be defined in web.xml");
        }

        File file = new File(getServletContext().getRealPath("/") + filename);
        if (!file.exists()) {
            throw new ServletException(filename + " does not exist.");
        }

        try (LineNumberReader reader = new LineNumberReader(new FileReader(file))) {
            String className;
            while ((className = reader.readLine()) != null) {
                className = className.trim();
                if (className.length() == 0 || className.charAt(0) == '#')
                    continue;

                Class<?> clazz = Class.forName(className);
                AbstractConverter converter = (AbstractConverter)clazz.newInstance();
                converters.register(converter);
            }
        }
        catch (Exception e) {
            throw new ServletException(e.getMessage());
        }

        // Referenced by usage.jsp
        this.getServletConfig().getServletContext().setAttribute("converters", converters);
    }

    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = response.getWriter();

        writer.write(HEADER1);
        writer.write(postDataLimit);
        writer.write(HEADER2);
        String currentString = request.getParameter("text");
        if (currentString != null && currentString.length() > 0) {
            writer.write(currentString);
        }
        writer.write(HEADER3);

        boolean conversionError = false;
        for (int count = 1; count <= numConverters; count++) {
            String countString = Integer.toString(count);
            // row header
            writer.write("<TR><TD><CENTER>");
            writer.write(countString);
            writer.write("</CENTER></TD><TD class=\"converter\"><SELECT name=\"converter");
            writer.write(countString);
            writer.write("\">");

            // Converter pull down menu
            String selectedConverter = getConverterName(request, count);
            for (String key : converters.getSelectorEntries()) {
                AbstractConverter converter = converters.get(key);
                writer.write("<OPTION value=\"");
                writer.write(converter.signature);
                if (converter.signature.compareTo(selectedConverter) == 0)
                    writer.write("\" selected>");
                else
                    writer.write("\">");
                writer.write(converter.displayString);
            }
            writer.write("</SELECT></TD>\n<TD id=\"value");
            writer.write(countString);
            writer.write("\" class=\"result\">");

            // apply conversion to value and write it to the result column
            AbstractConverter converter = converters.get(selectedConverter);
            if (!conversionError && converter != null) {
                try {
                    currentString = converter.convert(currentString);
                    if (currentString != null) {
                        writer.write(currentString);
                    }
                    else {
                        writer.write("*** bad input ***");
                        conversionError = true;
                    }
                } catch (Exception e) {
                    // in case a sloppy converter fails to catch exceptions
                    writer.write(e.getClass().getName() + " raised from " + converter.getClass().getName()
                            + " while converting \"" + currentString + "\". See server log for details.");
                    e.printStackTrace();
                    currentString = "";
                    conversionError = true;
                }
            }
            else {
                writer.write(NBSP);
            }
            writer.write("</TD></TR>\n");
        }
        writer.write(TRAILER);
    }

    private String getConverterName(final HttpServletRequest request, final int count) {
        String converter = request.getParameter("converter" + count);
        if (converter == null || converter.length() == 0) {
            return "";
        } else {
            return converter;
        }
    }
}
