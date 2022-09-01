import java.util.ArrayList;
import java.util.Random;

public class Bank {
    public ArrayList<Account> listOfAccounts = new ArrayList<Account>();
    public ArrayList<ATM> listOfAMTs = new ArrayList<ATM>();
    public ArrayList<Integer> listOfAccountNumbers = new ArrayList<Integer>();


    public Bank() {
        this.listOfAMTs = new ArrayList<ATM>();
        this.listOfAccounts = new ArrayList<Account>();
    }


    public int createAccount() {
        Account a = new Account();
        int accNumber = generateRandomNumber();
        a.setAccountNumber(accNumber);
        listOfAccounts.add(a);
        listOfAccountNumbers.add(accNumber);
        return a.getAccountNumber();
    }

    public void attachATM(ATM atm) {
        listOfAMTs.add(atm);
    }

    public int accessAcctInfo(int acctNum) {
        int balance = 0;
        balance = listOfAccounts.get(0).getBalance();
        return balance;
    }

    public void updateAcctBal(int acctNum, int diff) {
        for (Account listOfAccount : listOfAccounts) {
            if (acctNum == listOfAccount.getAccountNumber()) {
                if (diff < 0) {
                    if (listOfAccount.getBalance() >= Math.abs(diff)) {
                        listOfAccount.setBalance(listOfAccount.getBalance() + diff);
                    } else {
                        System.out.println("Difference is greater than balance.");
                    }
                } else {
                    listOfAccount.setBalance(listOfAccount.getBalance() + diff);
                }
            }
        }
    }





    public int generateRandomNumber() {
        Random rnd = new Random();
        int number = rnd.nextInt(100000,999999);
        boolean isRepeated = true;
        if(getListOfAccountNumbers().size() != 0) {
            while (isRepeated) {
                for (Integer listOfAccountNumber : getListOfAccountNumbers()) {
                    if (number == listOfAccountNumber) {
                        number = rnd.nextInt(999999);
                    }
                }
                isRepeated = false;
            }
        }
        String cardNumber;
        cardNumber = String.format("%06d", number);
        number = Integer.parseInt(cardNumber);
        return number;
    }

    public ArrayList<Integer> getListOfAccountNumbers() {
        return listOfAccountNumbers;
    }
}
