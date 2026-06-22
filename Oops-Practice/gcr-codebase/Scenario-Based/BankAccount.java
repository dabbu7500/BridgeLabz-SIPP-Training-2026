
public class BankAccount {
     int accountNumber;
     String accountHolder;
     double balance;
     static int totalAccounts=0;
    BankAccount(int accountNumber,String accountHolder,double balance)
    {
        this.accountHolder=accountHolder;
        this.accountNumber=accountNumber;
        this.balance=balance;
        totalAccounts++;
    }
     void deposit(double depositeAmount){
        balance+=depositeAmount;
        System.out.print("deposited "+depositeAmount);
    }
     void withdraw(double withrwalAmount)
    {
        if(withrwalAmount<=balance)
        {
            balance-=withrwalAmount;
            System.out.println("withrawl successfull "+"current balance ="+balance);
        }else{
            System.out.println("insufficiant balance");
        }
    }
        public void getStatement() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println();
    }
    public static int getTotalAccounts() {
        return totalAccounts;
    }
    public static void main(String[] args) {
         BankAccount acc1 = new BankAccount(101, "Himanshu", 10000);
        BankAccount acc2 = new BankAccount(102, "Rahul", 15000);
        BankAccount acc3 = new BankAccount(103, "Aman", 20000);

        acc1.deposit(1000);
        acc1.withdraw(500);
        acc1.deposit(2000);
        acc1.withdraw(3000);
        acc1.deposit(500);
        acc1.getStatement();

        acc2.deposit(1500);
        acc2.withdraw(2000);
        acc2.deposit(1000);
        acc2.withdraw(500);
        acc2.deposit(2500);
        acc2.getStatement();

        acc3.deposit(3000);
        acc3.withdraw(1000);
        acc3.deposit(2000);
        acc3.withdraw(5000);
        acc3.deposit(1000);
        acc3.getStatement();

        System.out.println("Total Accounts Created: " + BankAccount.getTotalAccounts());
    }

}
