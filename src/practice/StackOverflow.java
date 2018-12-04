package practice;

import java.util.LinkedList;
import java.util.Queue;

public class StackOverflow {
    static class Transaction{
        String name;
        double amount;
        String from;
        String to;
        long timeOfTheTransaction;

        public Transaction() {
        }

        public Transaction(String name, double amount, String from, String to, long timeOfTheTransaction) {
            this.name = name;
            this.amount = amount;
            this.from = from;
            this.to = to;
            this.timeOfTheTransaction = timeOfTheTransaction;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public long getTimeOfTheTransaction() {
            return timeOfTheTransaction;
        }

        public void setTimeOfTheTransaction(long timeOfTheTransaction) {
            this.timeOfTheTransaction = timeOfTheTransaction;
        }
    }
    public static void main(String[] args) {
        Queue<Transaction> transactions=new LinkedList<Transaction>();
        if(transactions.size()<=6){
            ((LinkedList<Transaction>) transactions).addFirst(new Transaction());
        }else{
            ((LinkedList<Transaction>) transactions).removeLast();
            ((LinkedList<Transaction>) transactions).addFirst(new Transaction());
        }
    }
}
