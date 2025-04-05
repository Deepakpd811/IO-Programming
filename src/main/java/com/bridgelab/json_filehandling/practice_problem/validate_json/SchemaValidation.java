package com.bridgelab.json_filehandling.practice_problem.validate_json;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;

public class SchemaValidation {

    // validate the schema data
    public static boolean validate(String schemaFilePath, String userFilePath) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        // Load schema
        JsonNode schemaNode = objectMapper.readTree(new File(schemaFilePath));

        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        JsonSchema schema = factory.getJsonSchema(schemaNode);

        // Load user data
        JsonNode dataNode = objectMapper.readTree((new File(userFilePath)));

        // validate method
        return schema.validate(dataNode).isSuccess();
    }

}
