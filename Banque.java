import java.util.Scanner;
public class Banque {
    public static final int nbMaxCompte = 1000;
    public static Compte T[] = new Compte[nbMaxCompte];
    public static int N = 0;
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\t\t\tMenu principale");
            System.out.println("\t\t\t---------------");
            System.out.println("\tAjouter un compte==========>1");
            System.out.println("\tSupprimer un compte=========>2");
            System.out.println("\tListe des comptes===========>3");
            System.out.println("\tDépot=======================>4");
            System.out.println("\tRetrait=====================>5");
            System.out.println("\tVirement====================>6");
            System.out.println("\tQuitter=====================>7");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add an account to the array
                    System.out.println("Adding a new account...");
                    System.out.print("Enter account holder name: ");
                    String accountHolder = scanner.next();
                    System.out.print("Enter initial balance: ");
                    float initialBalance = scanner.nextFloat();
                    Compte newAccount = new Compte(accountHolder, initialBalance);
                    T[N++] = newAccount;
                    break;
                case 2:
                    // Remove an account from the array
                    System.out.println("Removing an account...");
                    // Your code to remove an account from the Compte array (Banque.T)
                    // (You might need to shift elements if removing from the middle of the array)
                    break;
                case 3:
                    // Display list of accounts
                    System.out.println("List of accounts:");
                    for (int i = 0; i < N; i++) {
                        System.out.println(T[i]);
                    }
                    break;
                case 4:
                    // Deposit into an account
                    System.out.println("Deposit into an account...");
                    System.out.print("Enter account number: ");
                    int depositAccountNumber = scanner.nextInt();
                    System.out.print("Enter deposit amount: ");
                    float depositAmount = scanner.nextFloat();
                    for (int i = 0; i < N; i++) {
                        if (T[i].getNumero() == depositAccountNumber) {
                            T[i].deposer(depositAmount);
                            System.out.println("Deposit successful!");
                            break;
                        }
                    }
                    break;
                case 5:
                    // Withdraw from an account
                    System.out.println("Withdraw from an account...");
                    System.out.print("Enter account number: ");
                    int withdrawAccountNumber = scanner.nextInt();
                    System.out.print("Enter withdrawal amount: ");
                    float withdrawAmount = scanner.nextFloat();
                    for (int i = 0; i < N; i++) {
                        if (T[i].getNumero() == withdrawAccountNumber) {
                            boolean withdrawn = T[i].retirer(withdrawAmount);
                            if (withdrawn) {
                                System.out.println("Withdrawal successful!");
                            }
                            break;
                        }
                    }
                    break;
                case 6:
                    // Transfer funds between accounts
                    System.out.println("Transfer funds between accounts...");
                    System.out.print("Enter sender account number: ");
                    int senderAccountNumber = scanner.nextInt();
                    System.out.print("Enter receiver account number: ");
                    int receiverAccountNumber = scanner.nextInt();
                    System.out.print("Enter transfer amount: ");
                    float transferAmount = scanner.nextFloat();

                    Compte sender = null;
                    Compte receiver = null;

                    // Find sender and receiver accounts
                    for (int i = 0; i < N; i++) {
                        if (T[i].getNumero() == senderAccountNumber) {
                            sender = T[i];
                        }
                        if (T[i].getNumero() == receiverAccountNumber) {
                            receiver = T[i];
                        }
                    }

                    if (sender != null && receiver != null) {
                        sender.virerVers(transferAmount, receiver);
                        System.out.println("Transfer successful!");
                    } else {
                        System.out.println("Sender or receiver account not found.");
                    }
                    break;
                case 7:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                    break;
            }
        } while (choice != 7);

        scanner.close();
    }

    public static void main(String[] args) {
        menu();
    }
}
