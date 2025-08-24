package net.itau.api;

import java.time.OffsetDateTime;
import java.util.ArrayList;

public class transactionList {
        static no head = null;
        static int length = 0;

        public static void insertFirst(transaction transaction){
            if(head != null) {head.index = length;}

            no newNo = new no();

            newNo.data = transaction;
            newNo.next = head;
            newNo.index = 0;

            head = newNo;
            length++;
        }

        public static transaction getFirst(){
            return head.data;
        }

        public static returnTypes.transactionException getByIndex(int index){
            return head.getByIndex(index);
        }

        public static int getLength(){
            return length;
        }

        public static int removeAllItems(){
            if (head == null) {return exceptionsHandler.LIST_IS_EMPY;}

            head.next = null;
            head = null;

            return exceptionsHandler.SUCESSES;
        }

        public static returnTypes.transactionsException getLastMinuteTransactions(){
            returnTypes.transactionsException newTransactionException = new returnTypes.transactionsException();
            ArrayList<transaction> lastMinutesTransactions = new ArrayList<>();

            if(head == null) {

                newTransactionException.eh = exceptionsHandler.LIST_IS_EMPY;
                newTransactionException.tn = null;

                return newTransactionException;
            }

            no atual = head;
            OffsetDateTime currentTime = OffsetDateTime.now();
            OffsetDateTime transactionsDate;

            while(true) {
                transactionsDate = OffsetDateTime.parse(atual.data.getDataHora());

                if (transactionsDate.isAfter(currentTime.minusMinutes(1))) {
                    lastMinutesTransactions.add(atual.data);
                }

                if (atual.next == null) {break;} else {atual = atual.next;}
            }

            if(lastMinutesTransactions.isEmpty()) {

                newTransactionException.eh = exceptionsHandler.LIST_IS_EMPY;
                newTransactionException.tn = null;

                return newTransactionException;
            }

            newTransactionException.eh = exceptionsHandler.SUCESSES;
            newTransactionException.tn = lastMinutesTransactions;

            return newTransactionException;
        }

}
