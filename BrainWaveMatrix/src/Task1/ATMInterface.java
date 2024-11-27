package Task1;

import java.util.Scanner;

// Define the interface
interface ATMOperations {
	void checkBalance();

	void deposit(double amount);

	void withdraw(double amount);
}

// Implement the interface
class ATM implements ATMOperations {
	private double balance;
	private final int PIN;

	public ATM(int pin, double initialBalance) {
		this.PIN = pin;
		this.balance = initialBalance;
	}

	public boolean validatePIN(int enteredPin) {
		return this.PIN == enteredPin;
	}

	@Override
	public void checkBalance() {
		System.out.println("Your current balance is: $" + balance);
	}

	@Override
	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Deposit successful! Your new balance is: $" + balance);
		} else {
			System.out.println("Invalid deposit amount!");
		}
	}

	@Override
	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("Withdrawal successful! Your new balance is: $" + balance);
		} else if (amount > balance) {
			System.out.println("Insufficient balance!");
		} else {
			System.out.println("Invalid withdrawal amount!");
		}
	}
}

// Main class for user interaction
public class ATMInterface {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ATM atm = new ATM(1234, 500.0); // Initialize ATM with PIN and balance

		System.out.println("Welcome to the ATM!");
		System.out.print("Enter your PIN: ");
		int enteredPin = scanner.nextInt();

		if (!atm.validatePIN(enteredPin)) {
			System.out.println("Invalid PIN. Exiting...");
			return;
		}

		while (true) {
			System.out.println("\nATM Menu:");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit Money");
			System.out.println("3. Withdraw Money");
			System.out.println("4. Exit");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				atm.checkBalance();
				break;
			case 2:
				System.out.print("Enter deposit amount: ");
				double depositAmount = scanner.nextDouble();
				atm.deposit(depositAmount);
				break;
			case 3:
				System.out.print("Enter withdrawal amount: ");
				double withdrawalAmount = scanner.nextDouble();
				atm.withdraw(withdrawalAmount);
				break;
			case 4:
				System.out.println("Thank you for using the ATM. Goodbye!");
				scanner.close();
				return;
			default:
				System.out.println("Invalid option. Please try again.");
			}
		}

	}

}
