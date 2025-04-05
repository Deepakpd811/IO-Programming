package com.bridgelab.json_filehandling.handonpractice.csv_to_json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;

import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;
import java.io.IOException;


public class ValidateEmail {

    public static boolean validateEmailFields(String emailSchema, String userdata) throws IOException, ProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode emailSchemaNode = objectMapper.readTree(new File(emailSchema));
        JsonNode userNode = objectMapper.readTree((new File(userdata)));

        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        JsonSchema schema = factory.getJsonSchema(emailSchemaNode);

        return  schema.validate(userNode).isSuccess();
    }

    public static void main(String[] args) throws IOException, ProcessingException {

        String emailSchemapath = "files/emailSchema.json";
        String userpath = "files/user.json";

        boolean isvalid = validateEmailFields(emailSchemapath, userpath);

        if(isvalid){
            System.out.println("Users json is valid");
        }else{

            System.out.println("Users json is not valid");
        }

    }

}
