package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class Bankbranch {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Account> AccountBank;

    public static void main(String[] args) {
        AccountBank = new ArrayList<Account>();
        operations();
    }

    public static void operations() {

        System.out.println("------------------------------------------------------");
        System.out.println("-------------Bem vindos a Agência---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Opção 1 - Criar conta   |");
        System.out.println("|   Opção 2 - Depositar     |");
        System.out.println("|   Opção 3 - Sacar         |");
        System.out.println("|   Opção 4 - Transferir    |");
        System.out.println("|   Opção 5 - Listar        |");
        System.out.println("|   Opção 6 - Sair          |");

        int operacao = input.nextInt();;

        switch (operacao) {
            case 1:
                createAccount();
                break;

            case 2:
                depositAccount();
                break;

            case 3:
                withdrawAccount();
                break;

            case 4:
            transferAccount();
                break;

            case 5:
            listAccount();
                break;

            case 6:
                System.out.println("Comando executado com sucesso");
                System.exit(0);

            default:
                System.out.println("Opção inválida!");
                operations();
                break;
        }
    }

    public static void createAccount() {

        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("Email: ");
        String email = input.next();

        Person client = new Person(nome, cpf, email);

        Account Account = new Account(client);

        AccountBank.add(Account);
        System.out.println("--- Conta foi criada com sucesso ---");

        operations();

    }

    private static Account meetAccount(int numberAccout) {
        Account account = null;
        if(AccountBank.size() > 0) {
            for(Account accounts : AccountBank) {
                if(accounts.getNumberAccount() == numberAccout) {
                    account = accounts;
                }
            }
        }
        return account;
    }

    public static void depositAccount() {
        System.out.println("Número da conta: ");
        int numberAccout = input.nextInt();
        Account account = meetAccount(numberAccout);

        if(account != null) {
            System.out.println("Qual valor deseja depositar? ");
            Double valueDeposit = input.nextDouble();

            account.deposit(valueDeposit);
        }else {
            System.out.println("--- Conta não encontrada ---");
        }

        operations();
    }

    public static void withdrawAccount() {
        System.out.println("Número da conta: ");
        int numberAccout = input.nextInt();

        Account account = meetAccount(numberAccout);

        if(account != null) {
            System.out.println("Qual valor deseja sacar? ");
            Double valuewithdraw = input.nextDouble();

            account.withdraw(valuewithdraw);
            System.out.println("--- Saque realizado com sucesso ---");
        }else {
            System.out.println("--- Conta não encontrada ---");
        }

        operations();
    }

    public static void transferAccount() {
        System.out.println("Número da conta que vai enviar a transferência: ");
        int numberAccountSender = input.nextInt();

        Account accountSender = meetAccount(numberAccountSender);

        if(accountSender != null) {
            System.out.println("Número da conta do destinatário: ");
            int numberAccountRecipient = input.nextInt();

            Account accountRecipient = meetAccount(numberAccountRecipient);

            if(accountRecipient != null) {
                System.out.println("Valor da transferência: ");
                Double valor = input.nextDouble();

                accountSender.transfer(accountRecipient, valor);

            }else {
                System.out.println("--- A conta para depósito não foi encontrada ---");
            }

        }else {
            System.out.println("--- Conta para transferência não encontrada ---");
        }
        operations();
    }

    public static void listAccount() {
        if(!AccountBank.isEmpty()) {
            for(Account account: AccountBank) {
                System.out.println(account);
            }
        }else {
            System.out.println("--- Não há contas cadastradas ---");
        }

        operations();
    }
}
