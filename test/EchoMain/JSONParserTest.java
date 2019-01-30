package EchoMain;

import EchoMain.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author majusa
 */
public class JSONParserTest {
    
    public JSONParserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Tests whether parseWolfram returns the correct substring result from the
     * JSON output from WolframAlpha.
     */
    @Test
    public void testParseWolfram() {
        System.out.println("parseWolfram");
        String json = "{\"queryresult\" : { \"success\" : true, \"error\" : false, \"numpods\" : 13, \"datatypes\" : \"Book,City,Country,Leader,Movie,People,USState,WikipediaStats\", \"timedout\" : \"\", \"timedoutpods\" : \"\", \"timing\" : 5.827, \"parsetiming\" : 0.253, \"parsetimedout\" : false, \"recalculate\" : \"\", \"id\" : \"MSPa531gi5a999c78ce35g00005334a5hb94650ga3\", \"host\" : \"http:\\/\\/www5a.wolframalpha.com\", \"server\" : \"45\", \"related\" : \"http:\\/\\/www5a.wolframalpha.com\\/api\\/v2\\/relatedQueries.jsp?id=MSPa541gi5a999c78ce35g000023b760b44g5ca33a2761554860090389433\", \"version\" : \"2.6\", \"pods\" : [ { \"title\" : \"Input interpretation\", \"scanner\" : \"Identity\", \"id\" : \"Input\", \"position\" : 100, \"error\" : false, \"numsubpods\" : 1, \"subpods\" : [ { \"title\" : \"\", \"img\" : { \"src\" : \"http:\\/\\/www5a.wolframalpha.com\\/Calculate\\/MSP\\/MSP551gi5a999c78ce35g00005d67d2cghe3cf6gi?MSPStoreType=image\\/gif&s=45\", \"alt\" : \"Donald Trump (politician, etc.)\", \"title\" : \"Donald Trump (politician, etc.)\", \"width\" : 207, \"height\" : 18 }, \"plaintext\" : \"Donald Trump (politician, etc.)\" } ] }, { \"title\" : \"Basic information\", \"scanner\" : \"Data\", \"id\" : \"BasicInformation:PeopleData\", \"position\" : 200, \"error\" : false, \"numsubpods\" : 1, \"subpods\" : [ { \"title\" : \"\", \"img\" : { \"src\" : \"http:\\/\\/www5a.wolframalpha.com\\/Calculate\\/MSP\\/MSP561gi5a999c78ce35g0000171b38ai5i05egde?MSPStoreType=image\\/gif&s=45\", \"alt\" : \"full name | Donald John Trump\\ndate of birth | Friday, June 14, 1946 (age: 70 years)\\nplace of birth | New York City, New York, United States\", \"title\" : \"full name | Donald John Trump\\ndate of birth | Friday, June 14, 1946 (age: 70 years)\\nplace of birth | New York City, New York, United States\", \"width\" : 402, \"height\" : 100 }, \"plaintext\" : \"full name | Donald John Trump\\ndate of birth | Friday, June 14, 1946 (age: 70 years)\\nplace of birth | New York City, New York, United States\" } ] }, { \"title\" : \"Image\", \"scanner\" : \"Data\", \"id\" : \"Image:PeopleData\", \"position\" : 300, \"error\" : false, \"numsubpods\" : 1, \"subpods\" : [ { \"title\" : \"\", \"imagesource\" : \"http:\\/\\/en.wikipedia.org\\/wiki\\/File:Donald_Trump.jpg\", \"img\" : { \"src\" : \"http:\\/\\/www5a.wolframalpha.com\\/Calculate\\/MSP\\/MSP571gi5a999c78ce35g0000476c0i2aa15fdih3?MSPStoreType=image\\/gif&s=45\", \"alt\" : \"\", \"title\" : \"\", \"width\" : 91, \"height\" : 150 }, \"plaintext\" : \"\" } ] }, { \"title\" : \"Leadership position\", \"scanner\" : \"Data\", \"id\" : \"Position:LeaderData\", \"position\" : 400, \"error\" : false, \"numsubpods\" : 1, \"subpods\" : [ { \"title\" : \"\", \"img\" : { \"src\" : \"http:\\/\\/www5a.wolframalpha.com\\/Calculate\\/MSP\\/MSP581gi5a999c78ce35g00000g5hb5fifd71ci54?MSPStoreType=image\\/gif&s=45\", \"alt\" : \"official position | President (45th)\\ncountry | United States\\npolitical affiliation | Republican\\nstart date | 20 January 2017\", \"title\" : \"official position | President (45th)\\ncountry | United States\\npolitical affiliation | Republican\\nstart date | 20 January 2017\", \"width\" : 281, \"height\" : 132 }, \"plaintext\" : \"official position | President (45th)\\ncountry | United States\\npolitical affiliation | Republican\\nstart date | 20 January 2017\" } ] }, { \"title\" : \"Timeline\", \"scanner\" : \"Data\", \"id\" : \"Timeline:PeopleData\", \"position\" : 500, \"error\" : false, \"numsubpods\" : 1, \"subpods\" : [ { \"title\" : \"\", \"img\" : { \"src\" : \"http:\\/\\/www5a.wolframalpha.com\\/Calculate\\/MSP\\/MSP591gi5a999c78ce35g000019f3i4839ech39ha?MSPStoreType=image\\/gif&s=45\", \"alt\" : \"\", \"title\" : \"\", \"width\" : 550, \"height\" : 38 }, \"plaintext\" : \"\" } ] }, { \"title\" : \"Notable facts\", \"scanner\" : \"Data\", \"id\" : \"NotableFacts:PeopleData\", \"position\" : 600, \"error\" : false, \"numsubpods\" : 1, \"subpods\" : [ { \"title\" : \"\", \"img\" : { \"src\" : \"http:\\/\\/www5a.wolframalpha.com\\/Calculate\\/MSP\\/MSP601gi5a999c78ce35g00005bd1cd409i4f1f76?MSPStoreType=image\\/gif&s=45\", \"alt\" : \"Elected to become the 45th U.S. president in the 2016 election\\nReal estate mogul, author, and television personality known for his extravagant lifestyle and forthright manner\\nChairman and CEO of The Trump Organization, a United States-based real estate development company\\nHost and executive producer of the television reality show, The Apprentice\\nFounder of Trump Entertainment Resorts, which runs casinos and hotels around the world\\nFollowed father into real-estate development, working for his father's firm before graduating from college\", \"title\" : \"Elected to become the 45th U.S. president in the 2016 election\\nReal estate mogul, author, and television personality known for his extravagant lifestyle and forthright manner\\nChairman and CEO of The Trump Organization, a United States-based real estate development company\\nHost and executive producer of the television reality show, The Apprentice\\nFounder of Trump Entertainment Resorts, which runs casinos and hotels around the world\\nFollowed father into real-estate development, working for his father's firm before graduating from college\", \"width\" : 538, \"height\" : 238 }, \"plaintext\" : \"Elected to become the 45th U.S. president in the 2016 election\\nReal estate mogul, author, and television personality known for his extravagant lifestyle and forthright manner\\nChairman and CEO of The Trump Organization, a United States-based real estate development company\\nHost and executive producer of the television reality show, The Apprentice\\nFounder of Trump Entertainment Resorts, which runs casinos and hotels around the world\\nFollowed father into real-estate development, working for his father's firm before graduating from college\" } ] }, { \"title\" : \"Physical characteristics\", \"scanner\" : \"Data\", \"id\" : \"PhysicalCharacteristics:PeopleData\", \"position\" : 700, \"error\" : false, \"numsubpods\" : 1, \"subpods\" : [ { \"title\" : \"\", \"img\" : { \"src\" : \"http:\\/\\/www5a.wolframalpha.com\\/Calculate\\/MSP\\/MSP611gi5a999c78ce35g00002bie3db376e75274?MSPStoreType=image\\/gif&s=45\", \"alt\" : \"height | 6' 3\\\"\", \"title\" : \"height | 6' 3\\\"\", \"width\" : 127, \"height\" : 36 }, \"plaintext\" : \"height | 6' 3\\\"\" } ], \"states\" : [ { \"name\" : \"Show metric\", \"input\" : \"PhysicalCharacteristics:PeopleData__Show metric\" } ] }, { \"title\" : \"Familial relationships\", \"scanner\" : \"Data\", \"id\" : \"FamilialRelationships:PeopleData\", \"position\" : 800, \"error\" : false, \"numsubpods\" : 4, \"subpods\" : [ { \"title\" : \"Parents\", \"img\" : { \"src\" : \"http:\\/\\/www5a.wolframalpha.com\\/Calculate\\/MSP\\/MSP621gi5a999c78ce35g0000466agf8iff7e7790?MSPStoreType=image\\/gif&s=45\", \"alt\" : \"Fred Trump | Mary Anne Trump\", \"title\" : \"Fred Trump | Mary Anne Trump\", \"width\" : 227, \"height\" : 18 }, \"plaintext\" : \"Fred Trump | Mary Anne Trump\" }, { \"title\" : \"Siblings\", \"img\" : { \"src\" : \"http:\\/\\/www5a.wolframalpha.com\\/Calculate\\/MSP\\/MSP631gi5a999c78ce35g00001dbdh8ig179gf623?MSPStoreType=image\\/gif&s=45\", \"alt\" : \"Maryanne Trump Barry | Elizabeth Trump Grau | Fred Trump, Jr. | Robert Trump\", \"title\" : \"Maryanne Trump Barry | Elizabeth Trump Grau | Fred Trump, Jr. | Robert Trump\", \"width\" : 533, \"height\" : 38 }, \"plaintext\" : \"Maryanne Trump Barry | Elizabeth Trump Grau | Fred Trump, Jr. | Robert Trump\" }, { \"title\" : \"Spouses\", \"img\" : { \"src\" : \"http:\\/\\/www5a.wolframalpha.com\\/Calculate\\/MSP\\/MSP641gi5a999c78ce35g000014d4i4h471bg90e1?MSPStoreType=image\\/gif&s=45\", \"alt\" : \"Ivana Trump (1977-1992) | Marla Maples (1993-1999) | Melania Trump (2005-)\", \"title\" : \"Ivana Trump (1977-1992) | Marla Maples (1993-1999) | Melania Trump (2005-)\", \"width\" : 535, \"height\" : 18 }, \"plaintext\" : \"Ivana Trump (1977-1992) | Marla Maples (1993-1999) | Melania Trump (2005-)\" }, { \"title\" : \"Children\", \"img\" : { \"src\" : \"http:\\/\\/www5a.wolframalpha.com\\/Calculate\\/MSP\\/MSP651gi5a999c78ce35g00001c35eag370fcg2ee?MSPStoreType=image\\/gif&s=45\", \"alt\" : \"Eric Trump | Ivanka Trump | Donald Trump, Jr. | Tiffany Trump | Barron Trump\", \"title\" : \"Eric Trump | Ivanka Trump | Donald Trump, Jr. | Tiffany Trump | Barron Trump\", \"width\" : 541, \"height\" : 38 }, \"plaintext\" : \"Eric Trump | Ivanka Trump | Donald Trump, Jr. | Tiffany Trump | Barron Trump\" } ], \"states\" : [ { \"name\" : \"Show full dates\", \"input\" : \"FamilialRelationships:PeopleData__Show full dates\" } ] }, { \"title\" : \"Notable films\", \"scanner\" : \"Data\", \"id\" : \"NotableFilms:PeopleData\", \"position\" : 900, \"error\" : false, \"numsubpods\" : 1, \"subpods\" : [ { \"title\" : \"Appeared in\", \"img\" : { \"src\" : \"http:\\/\\/www5a.wolframalpha.com\\/Calculate\\/MSP\\/MSP661gi5a999c78ce35g00000f990id2g98g2g27?MSPStoreType=image\\/gif&s=45\", \"alt\" : \"Zoolander (2001) | The Little Rascals (1994) | 54 (1998) | Eddie (1996) | The Central Park Five (2012) | ... (total: 10)\", \"title\" : \"Zoolander (2001) | The Little Rascals (1994) | 54 (1998) | Eddie (1996) | The Central Park Five (2012) | ... (total: 10)\", \"width\" : 541, \"height\" : 38 }, \"plaintext\" : \"Zoolander (2001) | The Little Rascals (1994) | 54 (1998) | Eddie (1996) | The Central Park Five (2012) | ... (total: 10)\" } ], \"states\" : [ { \"name\" : \"More\", \"input\" : \"NotableFilms:PeopleData__More\" } ], \"definitions\" : { \"word\" : \"Appeared in\", \"desc\" : \"Includes films where an individual appeared as him or herself, or in historical or archival footage.\" } }, { \"title\" : \"Notable books\", \"scanner\" : \"Data\", \"id\" : \"NotableBooks:PeopleData\", \"position\" : 1000, \"error\" : false, \"numsubpods\" : 1, \"subpods\" : [ { \"title\" : \"\", \"img\" : { \"src\" : \"http:\\/\\/www5a.wolframalpha.com\\/Calculate\\/MSP\\/MSP671gi5a999c78ce35g00004acih058ba30i514?MSPStoreType=image\\/gif&s=45\", \"alt\" : \"Trump: Surviving at the Top (1990) | Trump: The Art of the Deal (1987)\", \"title\" : \"Trump: Surviving at the Top (1990) | Trump: The Art of the Deal (1987)\", \"width\" : 479, \"height\" : 18 }, \"plaintext\" : \"Trump: Surviving at the Top (1990) | Trump: The Art of the Deal (1987)\" } ] }, { \"title\" : \"Estimated net worth\", \"scanner\" : \"Data\", \"id\" : \"NetWorth:PeopleData\", \"position\" : 1100, \"error\" : false, \"numsubpods\" : 1, \"subpods\" : [ { \"title\" : \"\", \"img\" : { \"src\" : \"http:\\/\\/www5a.wolframalpha.com\\/Calculate\\/MSP\\/MSP681gi5a999c78ce35g000048gd4611d0d04bh0?MSPStoreType=image\\/gif&s=45\", \"alt\" : \"$4.5 billion (US dollars)\\n(based on 2015 Forbes estimates)\", \"title\" : \"$4.5 billion (US dollars)\\n(based on 2015 Forbes estimates)\", \"width\" : 184, \"height\" : 36 }, \"plaintext\" : \"$4.5 billion (US dollars)\\n(based on 2015 Forbes estimates)\" } ], \"states\" : [ { \"name\" : \"Show history\", \"input\" : \"NetWorth:PeopleData__Show history\" } ] }, { \"title\" : \"Wikipedia summary\", \"scanner\" : \"Data\", \"id\" : \"WikipediaSummary:PeopleData\", \"position\" : 1200, \"error\" : false, \"numsubpods\" : 1, \"subpods\" : [ { \"title\" : \"\", \"img\" : { \"src\" : \"http:\\/\\/www5a.wolframalpha.com\\/Calculate\\/MSP\\/MSP691gi5a999c78ce35g000058d8a05ccbda0da6?MSPStoreType=image\\/gif&s=45\", \"alt\" : \"\", \"title\" : \"\", \"width\" : 538, \"height\" : 96 }, \"plaintext\" : \"\" } ], \"states\" : [ { \"name\" : \"More\", \"input\" : \"WikipediaSummary:PeopleData__More\" } ], \"infos\" : { \"links\" : { \"url\" : \"http:\\/\\/en.wikipedia.org\\/wiki?curid=4848272\", \"text\" : \"Full entry\" } } }, { \"title\" : \"Wikipedia page hits history\", \"scanner\" : \"Data\", \"id\" : \"PopularityPod:WikipediaStatsData\", \"position\" : 1300, \"error\" : false, \"numsubpods\" : 1, \"subpods\" : [ { \"title\" : \"\", \"img\" : { \"src\" : \"http:\\/\\/www5a.wolframalpha.com\\/Calculate\\/MSP\\/MSP701gi5a999c78ce35g0000499466bg389fi9i1?MSPStoreType=image\\/gif&s=45\", \"alt\" : \"\", \"title\" : \"\", \"width\" : 546, \"height\" : 181 }, \"plaintext\" : \"\" } ], \"states\" : [ { \"name\" : \"Linear scale\", \"input\" : \"PopularityPod:WikipediaStatsData__Linear scale\" } ] } ], \"assumptions\" : { \"type\" : \"SubCategory\", \"word\" : \"Donald Trump\", \"template\" : \"Assuming ${desc1}. Use ${desc2} instead\", \"count\" : 2, \"values\" : [ { \"name\" : \"DonaldTrump::6vv3q\", \"desc\" : \"Donald Trump\", \"input\" : \"*DPClash.PersonE.Donald+Trump-_*DonaldTrump%3A%3A6vv3q-\" }, { \"name\" : \"DonaldTrumpJr::76ws3\", \"desc\" : \"Donald Trump, Jr.\", \"input\" : \"*DPClash.PersonE.Donald+Trump-_*DonaldTrumpJr%3A%3A76ws3-\" } ] }, \"sources\" : [ { \"url\" : \"http:\\/\\/www.wolframalpha.com\\/sources\\/BookDataSourceInformationNotes.html\", \"text\" : \"Book data\" }, { \"url\" : \"http:\\/\\/www.wolframalpha.com\\/sources\\/LeaderDataSourceInformationNotes.html\", \"text\" : \"Leader data\" }, { \"url\" : \"http:\\/\\/www.wolframalpha.com\\/sources\\/MovieDataSourceInformationNotes.html\", \"text\" : \"Movie data\" }, { \"url\" : \"http:\\/\\/www.wolframalpha.com\\/sources\\/PeopleDataSourceInformationNotes.html\", \"text\" : \"People data\" } ] }}";
        JSONParser instance = new JSONParser();
        
        String expResult = "full name | Donald John Trump date of birth | Friday, June 14, 1946 (age: 70 years) place of birth | New York City, New York, United States";
        String result = instance.parseWolfram(json);
        assertEquals("parseWolfram failed to parse the input JSON", expResult, result);
        
    }

    /**
     * Tests whether parseCognitive returns the correct substring result from
     * the JSON output from Cognitive Services Speech to Text.
     */
    @Test
    public void testParseCognitive() {
        System.out.println("parseCognitive");
        String json = "{\"version\":\"3.0\",\"header\":{\"status\":\"success\",\"scenario\":\"smd\",\"name\":\"Goodbye moon men goodbye munmun goodbye.\",\"lexical\":\"goodbye moon men goodbye munmun goodbye\",\"properties\":{\"requestid\":\"779585e4-c70b-4a60-994f-35b9d254ea97\",\"HIGHCONF\":\"1\"}},\"results\":[{\"scenario\":\"smd\",\"name\":\"Goodbye moon men goodbye munmun goodbye.\",\"lexical\":\"goodbye moon men goodbye munmun goodbye\",\"confidence\":\"0.7129729\",\"properties\":{\"HIGHCONF\":\"1\"}}]}";
        JSONParser instance = new JSONParser();
        
        String expResult = "Goodbye moon men goodbye munmun goodbye.";
        String result = instance.parseCognitive(json);
        assertEquals("parseCognitive failed to parse the input JSON", expResult, result);

    }

    /**
     * Tests whether clean() properly removes newlines, tabs and return 
     * characters from a given input string.
     * 
     */
    @Test
    public void testClean() {
        System.out.println("clean");
        String input = "Goodbye\\n moon\t men goodbye\\r munmun\n goodbye\n.";
        JSONParser instance = new JSONParser();
        
        String expResult = "Goodbye  moon  men goodbye  munmun  goodbye .";
        String result = instance.clean(input);
        assertEquals("clean() has failed to clean the input string", expResult, result);

    }
    
}
