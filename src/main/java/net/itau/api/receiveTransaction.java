package net.itau.api;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;


@RestController
public class receiveTransaction {

    private static final Logger log = LoggerFactory.getLogger(receiveTransaction.class);

    @PostMapping("/transacao")
    public void  postTransaction(@RequestBody transaction transaction1, HttpServletResponse response){
        int statusCode = validadeRequest(transaction1);

        if (statusCode == 201) {
            transactionList.insertFirst(transaction1);
            System.out.println(transactionList.getFirst().getValor());
        }

        var result = transactionList.getByIndex(1);
        if (result.eh == exceptionsHandler.SUCESSES) {System.out.println("Achado");}

        response.setStatus(statusCode);
    }

    public int validadeRequest (transaction transaction1){

        OffsetDateTime creatAt;
        OffsetDateTime currentDate;

        try {
            creatAt = OffsetDateTime.parse(transaction1.getDataHora());
            currentDate = OffsetDateTime.now();
        } catch(Exception e) {
            log.error("e: ", e);
            return 422;
        }

        if (creatAt.isAfter(currentDate)) {
            return 422;
        };

        if (!creatAt.isBefore(currentDate)) {
            return 422;
        }

        if (transaction1.getValor() < 0) {
            return 422;
        };

        return 201;
    }
}
