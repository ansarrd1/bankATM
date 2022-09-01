public class ATM {
    Bank b;
    boolean loggedIn;
    Account currentAccount;

    public ATM(Bank b) {
        this.b = b;
        loggedIn = false;
    }

    public void setBank(Bank b) {
        this.b = b;
    }

    public boolean loginToAccount(int acctNum) {
        for(int i=0; i<b.listOfAccounts.size(); i++) {
            if(acctNum == b.listOfAccounts.get(i).getAccountNumber()) {
                currentAccount = b.listOfAccounts.get(i);
                loggedIn = true;
                return true;
            }
        }
        return false;
    }

    public void depositMoney(int amount) {
        if(loginToAccount(currentAccount.getAccountNumber())) {
            b.updateAcctBal(currentAccount.getAccountNumber(), amount);
        } else {
            System.out.println("not logged");
        }
    }

    public void withdrawMoney(int amount) {
        if(loginToAccount(currentAccount.getAccountNumber())) {
            b.updateAcctBal(currentAccount.getAccountNumber(), -amount);
        } else {
            System.out.println("not logged");
        }
    }

    public int getBalance() {
        return currentAccount.getBalance();
    }

    public void logOut() {

    }
}
