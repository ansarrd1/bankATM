public class Customer {
    Bank bank;
    ATM atm;

    public Customer(Bank bank, ATM atm) {
        this.bank = bank;
        this.atm = atm;
    }

    public int openAccount() {
        int cardNumber = bank.createAccount();
        atm.loginToAccount(cardNumber);
        return cardNumber;

    }

    public void depositMoney(int amount) {
        atm.depositMoney(amount);
    }

    public void withdrawMoney(int amount) {
        atm.withdrawMoney(amount);
    }

    public int checkBalance() {
//        atm.logOut();
        return atm.getBalance();
    }

}
