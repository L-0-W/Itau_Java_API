package net.itau.api;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class deleteTransaction {

        @DeleteMapping("/transacao")
        public void deleteTransacao(HttpServletResponse response) {
            if(transactionList.removeAllItems() == exceptionsHandler.LIST_IS_EMPY) {response.setStatus(HttpServletResponse.SC_NO_CONTENT);}
            else { response.setStatus(200);}
        }

}
