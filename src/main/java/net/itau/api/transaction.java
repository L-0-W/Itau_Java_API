package net.itau.api;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public record transaction(double valor, String dataHora) {
    public double getValor(){
        return this.valor;
    }

    public String getDataHora(){
        return this.dataHora;
    }
}
