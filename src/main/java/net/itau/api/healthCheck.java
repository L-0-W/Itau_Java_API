package net.itau.api;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Objects;

@RestController
public class healthCheck {

    private static final Logger log = LogManager.getLogger(healthCheck.class);
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/health")
    public void checkHealth(HttpServletResponse response, RestTemplate restTemplate){
        ArrayList<String> newList = new ArrayList<>();
        newList.add("/estatisticas"); // -- GET
        newList.add("/transacao-post"); // -- POST
        newList.add("/transacao-delete"); // -- DELETE

        var count = 0;
        while(count < newList.size()){
            var element =  newList.get(count);

            if (Objects.equals(element, "/estatisticas")){
                try{
                    transaction str = restTemplate.getForObject("http://localhost:8080/estatisticas", transaction.class );

                    System.out.print("/estatisticas - Funcionando\n");
                } catch (Exception e){
                    log.error("Error from /estatisticas : {}", String.valueOf(e));
                    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    return;
                }
            }

            if (Objects.equals(element, "/transacao-post")){
                try{
                    transaction tsr = new transaction(125, "2025-08-23T20:05:30.789-03:00");
                    transaction str = restTemplate.postForObject("http://localhost:8080/transacao", tsr, transaction.class );

                    System.out.print("/transacao-post - Funcionando\n");
                } catch (Exception e){
                    log.error("Error from /transacao-post: {}", String.valueOf(e));
                    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    return;
                }
            }

            if (Objects.equals(element, "/transacao-delete")){
                try{
                    restTemplate.delete("http://localhost:8080/transacao");

                    System.out.print("/transacao-delete - Funcionando\n");
                } catch (Exception e){
                    log.error("Error from /transacao-delete: {}", String.valueOf(e));
                    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    return;
                }
            }


            count++;
        };
        response.setStatus(HttpServletResponse.SC_OK);
    }

}
