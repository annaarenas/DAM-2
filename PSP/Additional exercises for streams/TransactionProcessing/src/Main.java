import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction(1, "Credit", 100.0));
        transactions.add(new Transaction(2, "Withdrawal", 50.0));
        transactions.add(new Transaction(3, "Credit", 200.0));
        transactions.add(new Transaction(4, "Debit", 30.0));
        transactions.add(new Transaction(5, "Deposit", 150.0));
        transactions.add(new Transaction(6, "Credit", 70.0));
        transactions.add(new Transaction(7, "Debit", 520.0));
        transactions.add(new Transaction(8, "Debit", 90.0));
        transactions.add(new Transaction(9, "Deposit", 400.0));
        transactions.add(new Transaction(10, "Debit", 120.0));

        // Filter the transactions to get those of type "Credit" and print their IDs and amounts.
        List<Transaction> creditTransactions = transactions.stream().filter(t -> t.getType().equals("Credit")).toList();

        System.out.println("Credit Transactions:");
        for (Transaction t : creditTransactions) {
            System.out.println("ID: " + t.getId() + ", Amount: " + t.getAmount());
        }

        System.out.println();

        //Calculate the total amount of "Debit" transactions.
        Double totalDebitTransactions = transactions.stream().filter(t -> t.getType().equals("Debit")).mapToDouble(t -> t.getAmount()).sum();
        System.out.println("Total Amount of Debit Transactions: " + totalDebitTransactions);

        System.out.println();

        //Find the transaction with the highest amount and display its ID and type.
        Transaction highestAmountTransaction = transactions.stream().max((t1, t2) -> Double.compare(t1.getAmount(), t2.getAmount())).orElse(null);
        if (highestAmountTransaction != null) {
            System.out.println("Transaction with Highest Amount:");
            System.out.println("ID: " + highestAmountTransaction.getId() + " Type: " + highestAmountTransaction.getType());
        }

        System.out.println();

        // Print the IDs of all transactions with an amount greater than $500
        List<Transaction> greater500 = transactions.stream().filter(t -> t.getAmount() > 500).toList();
        System.out.println("Transactions with Amount Greater than 500:");
        for (Transaction t : greater500) {
            System.out.println("ID: " + t.getId());
        }

        System.out.println();

        // Group the transactions by type and print the total amount for each type.
        List<String> types = transactions.stream().map(t -> t.getType()).distinct().toList();

        System.out.println("Total Amount by Transaction Type:");
        for (String type : types) {
            double totalByType = transactions.stream().filter(t -> t.getType().equals(type)).mapToDouble(t -> t.getAmount()).sum();
            System.out.println("Type: " + type + " Amount: " + totalByType);
        }
    }
}