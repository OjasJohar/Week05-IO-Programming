package com.bridgelabz.practice_problem_2.convert_json_to_xml_format;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JsonToXmlConverterTest {

    @Test
    void testConvertJsonToXml() {
        String json = "{ \"employee\": { \"name\": \"John\", \"age\": 30, \"city\": \"New York\" } }";
        String expectedXml = "<LinkedHashMap><employee><name>John</name><age>30</age><city>New York</city></employee></LinkedHashMap>";

        try {
            String actualXml = JsonToXmlConverter.convertJsonToXml(json);

            // Normalize XML for comparison (ignoring whitespace differences)
            String normalizedActualXml = actualXml.replaceAll("\\s+", "");
            String normalizedExpectedXml = expectedXml.replaceAll("\\s+", "");

            assertEquals(normalizedExpectedXml, normalizedActualXml, "Converted XML should match expected XML");
        } catch (Exception e) {
            fail("Exception occurred during conversion: " + e.getMessage());
        }
    }

    @Test
    void testInvalidJson() {
        String invalidJson = "{ \"employee\": { \"name\": \"John\", \"age\": 30, ";

        assertThrows(Exception.class, () -> JsonToXmlConverter.convertJsonToXml(invalidJson),
                "Should throw an exception for invalid JSON");
    }

    @Test
    void testEmptyJson() {
        String emptyJson = "{}";

        try {
            String xml = JsonToXmlConverter.convertJsonToXml(emptyJson);
            assertNotNull(xml, "XML output should not be null for empty JSON");
            assertFalse(xml.contains("<HashMap/>") || xml.contains("<Map/>"),
                    "Expected empty XML representation");
        } catch (Exception e) {
            fail("Exception should not occur for empty JSON");
        }
    }
}
