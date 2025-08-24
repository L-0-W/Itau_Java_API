package net.itau.api;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;

@RestController
public class  statistics {

    public record statisticsFields (
            double count,
            double sum,
            double avg,
            double min,
            double max
    ) { }

    public double sum(ArrayList<transaction> tn){
        double sum = 0;
        System.out.println(tn.get(0).getValor());
        for(transaction tsn : tn){
            sum+=tsn.getValor();
        }

        return sum;
    }

    public double avarage(ArrayList<transaction> tn){
        double sum = 0;
        for(transaction tsn : tn){
            sum+=tsn.getValor();
        }

        return sum/tn.size();
    }

    public double min(ArrayList<transaction> tn){
        double min = Integer.MAX_VALUE;
        for(transaction tsn : tn){
            if (tsn.getValor() < min) { min = tsn.getValor(); }
        }

        return min;
    }

    public double max(ArrayList<transaction> tn){
        double max = Integer.MIN_VALUE;
        for(transaction tsn : tn){
            if (tsn.getValor() > max) { max = tsn.getValor(); }
        }

        return max;
    }

    @GetMapping("/estatisticas")
    public statisticsFields returnStatistics(HttpServletResponse response){
        var result = transactionList.getLastMinuteTransactions();
        if (result.eh == exceptionsHandler.LIST_IS_EMPY) {response.setStatus(200); return new statisticsFields(
                0,
                0,
                0,
                0,
                0
        );}
        else {
            response.setStatus(200);
            return new statisticsFields(
                    result.tn.size(),
                    sum(result.tn),
                    avarage(result.tn),
                    min(result.tn),
                    max(result.tn)
            );
        }

    }
}
