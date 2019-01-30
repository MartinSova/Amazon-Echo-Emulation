package EchoMain;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Access the Computational Alpha computational knowledge engine.
 *
 * See http://products.wolframalpha.com/api/documentation.html
 *
 * David Wakeling, 2017.
 */
public class Computational {

    final static String APPID = "HPTQ52-U9PL8492P2";

    /*
     * Solve.
     */
    private static String solve(String input) {
        final String method = "POST";
        final String url
                = ("http://api.wolframalpha.com/v2/query"
                + "?" + "appid" + "=" + APPID
                + "&" + "input" + "=" + urlEncode(input)
                + "&" + "output" + "=" + "JSON");
        final String[][] headers
                = {{"Content-Length", "0"}
                };
        final byte[] body = new byte[0];
        byte[] response = HttpConnect.httpConnect(method, url, headers, body);
        String xml = new String(response);
        return xml;
    }

    /*
     * URL encode string.
     */
    private static String urlEncode(String s) {
        try {
            return URLEncoder.encode(s, "utf-8");
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex);
            System.exit(1);
            return null;
        }
    }

    /**
     * Unashamedly using code given in workshops by Dr. David Wakeling.
     *
     * Currently, the main method queries WolframAlpha with a string input
     * (PROBLEM) and receives the solution data as a JSON String. It then parses
     * this String using the JSONParser in order to extract a plaintext output.
     *
     * @param json
     * @return 
     */
    public String compute(String json) {
        /* renew access token threads */
        String result = solve(json);
        //System.out.println(json);
        return result;
    }
}