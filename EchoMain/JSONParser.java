package EchoMain;

/**
 * The JSONParser is used to parse input JSON data from WolframAlpha and
 * Microsoft Speech-to-Text and returns the relevant text output as a plaintext
 * String.
 *
 * @author Team P
 * @version 1.0
 * @since 2017-02-18
 */
public class JSONParser {

    public float confidence; // stores the confidence value from cognitive services
    public boolean cogSuccess = true; //bools to check whether json has been successfully parsed

    /**
     * Parses the JSON data sent back from WolframAlpha, extracts the
     * JsonObject which contains the plaintext answer to the query given and 
     * then returns it as a String.
     *
     * @param json is the input JSON data
     * @return result is the output plaintext String once the JSON has been
     * parsed
     */
    public String parseWolfram(String json) {

        String result = "";
        String check;   
        int firstIndex, secondIndex;

        try {

            // This block checks whether Wolfram has successfully processed the input query
            firstIndex = json.indexOf("success");
            firstIndex = json.indexOf(":", firstIndex);
            secondIndex = json.indexOf(",", firstIndex);
            check = json.substring(firstIndex + 2, secondIndex); //string result begins 2 chars from first index

            if (check.equals("false")) {
                result = "I'm sorry, but I couldn't quite understand your question.";
            } else {
                //finds the relevant "plaintext" json object
                firstIndex = json.indexOf("plaintext");
                secondIndex = json.indexOf("plaintext", firstIndex + 1);

                //string result begins 14 chars from secondIndex
                firstIndex = secondIndex + 14;
                secondIndex = json.indexOf("\"", firstIndex + 0);

                result = json.substring(firstIndex, secondIndex);

            }
        } catch (Exception e) {
            System.out.println("WolframParseException: Was not able to parse json returned from WolframAlpha");
        }

        return clean(result);
    }

    /**
     * Parses the JSON data sent back from Cognitive Services, extracts the
     * JsonObject which contains the plaintext answer to the query given and
     * then returns it as a String.
     *
     * @param json is the input JSON data
     * @return result is the output plaintext String once the JSON has been
     * parsed
     */
    public String parseCognitive(String json) {

        String result = "";
        String check;
        int firstIndex, secondIndex;

        this.cogSuccess = true; //Redundancy for safety

        try {

            // This block checks whether or not Cognitive services has succeeded in parsing the input data
            firstIndex = json.indexOf("status");
            secondIndex = json.indexOf(":", firstIndex);
            firstIndex = json.indexOf("\"", secondIndex);
            secondIndex = json.indexOf("\"", firstIndex + 1);

            check = json.substring(firstIndex + 1, secondIndex);

            if (!check.equals("success")) {
                this.cogSuccess = false;
            } else {
                firstIndex = json.indexOf("name") + 7;
                secondIndex = json.indexOf("\"", firstIndex);

                result = json.substring(firstIndex, secondIndex);

                firstIndex = json.indexOf("confidence") + 13;
                secondIndex = json.indexOf("\"", firstIndex);

                this.confidence = Float.parseFloat(json.substring(firstIndex, secondIndex));

            }

        } catch (Exception e) {
            System.out.println("CognitiveParseException: Was not able to parse json returned from Cognitive Services");
        }

        return result;
    }

    /**
     * Takes a String (input) and strips all line feeds, carriage returns and
     * tabs contained within the text.
     *
     * @param input Unformatted string containing \t || \r || \n
     * @return result Formatted output string
     */
    public String clean(String input) {

        input = input.replace("\\n", " ").replace("\\t", " ").replace("\\r", " ");
        String result = input.replace("\n", " ").replace("\t", " ").replace("\r", " ");

        return result;

    }

}
