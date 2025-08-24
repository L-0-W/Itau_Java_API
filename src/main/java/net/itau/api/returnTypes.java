package net.itau.api;

import java.util.ArrayList;

public class returnTypes {
    public static class transactionsException {
        int eh;
        ArrayList<transaction> tn;
    }

    public static class transactionException {
        int eh;
        transaction tn;
    }
}