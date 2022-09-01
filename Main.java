public class Main {
    public static void main(String[] args) {
        Bank kaspi = new Bank();
        ATM kaspiATM1 = new ATM(kaspi);
        ATM kaspiATM2 = new ATM(kaspi);
        Customer ansar = new Customer(kaspi, kaspiATM1);
        System.out.println(ansar.openAccount()); // should print account number
        System.out.println(ansar.checkBalance()); // should print 0
        ansar.depositMoney(5000);
        System.out.println(ansar.checkBalance()); // should print 5000
        ansar.withdrawMoney(3000);
        System.out.println(ansar.checkBalance());

        Bank jusan = new Bank();
        ATM jusan1 = new ATM(jusan);
        Customer dima = new Customer(jusan, jusan1);
        System.out.println(dima.openAccount()); // should print account number
        System.out.println(dima.checkBalance()); // should print 0
        dima.depositMoney(5000);
        System.out.println(dima.checkBalance()); // should print 5000
        ansar.withdrawMoney(8000); // should print Difference is greater than balance
        System.out.println(dima.checkBalance());




    }
}