import com.anatolii.anitsai.transaction.Transaction;

public class Main {

    public static void main(String[] args) {
        Transaction transaction = new Transaction("150.39 грн");
        System.out.println(transaction.getResultStr());
    }
}
