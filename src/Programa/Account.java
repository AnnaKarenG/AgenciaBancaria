package Programa;

public class Account {

    private static int accountAccount = 1;

    private int numberAccout;
    private Person person;
    private Double balance = 0.0;


    public Account(Person person) {
        this.numberAccout = Account.accountAccount;
        this.person = person;
        this.updateBalance();
        Account.accountAccount += 1;
    }


    public int getNumberAccount() {
        return numberAccout;
    }
    public Person getClient() {
        return person;
    }
    public void setClient(Person person) {
        this.person = person;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    private void updateBalance() {
        this.balance = this.getBalance();
    }

    public String toString() {

        return "\nBank account: " + this.getNumberAccount() +
                "\nCliente: " + this.person.getName() +
                "\nCPF: " + this.person.getCpf() +
                "\nEmail: " + this.person.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.getBalance()) +
                "\n" ;
    }

    public void deposit(Double value) {
        if(value > 0) {
            setBalance(getBalance() + value);
            System.out.println("Seu depósito foi realizado com sucesso!");
        }else {
            System.out.println("Não foi possível realizar o depósito!");
        }
    }

    public void withdraw(Double value) {
        if(value > 0 && this.getBalance() >= value) {
            setBalance(getBalance() - value);
            System.out.println("Saque realizado com sucesso!");
        }
        else {
            System.out.println("Não foi possível realizar o saque!");
        }
    }

    public void transfer(Account accountDeposit, Double value) {
        if(value > 0 && this.getBalance() >= value) {
            setBalance(getBalance() - value);
            accountDeposit.balance = accountDeposit.getBalance() + value;
            System.out.println("Transferência realizada com sucesso!");
        }else {
            System.out.println("Não foi possível realizar a tranferência");
        }

    }

}
