package net.itau.api;

public class no {
    transaction data;
    no next;
    int index;

    public returnTypes.transactionException getByIndex(int index){
         returnTypes.transactionException newTE = new returnTypes.transactionException();

         newTE.eh = exceptionsHandler.SUCESSES;
         newTE.tn = data;

         if (this.index == index) {return newTE;}

         newTE.eh = exceptionsHandler.LIST_ENDED;
         newTE.tn = null;

         if (next == null) {return newTE;}


         return next.getByIndex(index);
    };
}
