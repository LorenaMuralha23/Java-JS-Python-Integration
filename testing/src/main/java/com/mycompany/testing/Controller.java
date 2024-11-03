package com.mycompany.testing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mycompany.testing.ReceivedJSON;

@RestController
@RequestMapping("/test")
public class Controller {
    
    @Autowired
    ObjectMapper objMapper;
 
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/send")
    public String receiveJSON(@RequestBody String messageReceived) throws JsonProcessingException{
        try {
            System.out.println("Received!");
            
            ReceivedJSON jsonReceived = objMapper.readValue(messageReceived, ReceivedJSON.class);
            
            sendingToPython(jsonReceived);
        } catch (JsonProcessingException ex) {
            System.out.println("Error!");
        }
        
        BackMessage msgToSend = new BackMessage("server", "JSON received and processed!");
        
        String jsonToSend = objMapper.writeValueAsString(msgToSend);
        
        
        
        return jsonToSend;
    }
    
    public void sendingToPython(ReceivedJSON message){
        RestTemplate restTemplate = new RestTemplate();
        String pythonURL = "http://localhost:5000/process-data";
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<ReceivedJSON> requestEntity = new HttpEntity<>(message, headers);
        
        // Chama o servidor Python
        ResponseEntity<String> response = restTemplate.postForEntity(pythonURL, requestEntity, String.class);
      
        // Retorna a resposta do servidor Python
        String messageReceived = response.getBody();
        System.out.println("Message received from python:");
        System.out.println(messageReceived);
    }
    
}
