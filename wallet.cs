using System;

class Wallet
{
    private static double balance = 0;

    static void CheckBalance()
    {
        Console.WriteLine($"Your current balance is: {balance}$");
        ShowMenu();
    }

    static void Deposit()
    {
        Console.Write("How much money to deposit? ");
        if (double.TryParse(Console.ReadLine(), out double amount) && amount > 0)
        {
            balance += amount;
            Console.WriteLine($"You deposited {amount}$. Your new balance is: {balance}$");
        }
        else
        {
            Console.WriteLine("Invalid amount. Please enter a positive number.");
        }
        ShowMenu();
    }

    static void Withdraw()
    {
        Console.Write("How much money to withdraw? ");
        if (double.TryParse(Console.ReadLine(), out double amount) && amount > 0)
        {
            if (amount <= balance)
            {
                balance -= amount;
                Console.WriteLine($"You withdraw {amount}$. Your new balance is: {balance}$");
            }
            else
            {
                Console.WriteLine("You too poor for that");
            }
        }
        else
        {
            Console.WriteLine("Invalid amount. Please enter a positive number.");
        }
        ShowMenu();
    }

    static void ExitProgram()
    {
        Console.WriteLine("You throw the wallet and never see it again, nor get the money inside it back.");
        Environment.Exit(0);
    }

    static void PutInPocket()
    {
        Console.WriteLine("You put the wallet in your pocket, but it couldn't breathe so it came out.");
        ShowMenu();
    }

    static void ShowMenu()
    {
        Console.WriteLine("\nThis is your wallet, what do you want to do?");
        Console.WriteLine("1. Check balance");
        Console.WriteLine("2. Deposit some money");
        Console.WriteLine("3. Withdraw some money");
        Console.WriteLine("4. Put in your pocket");
        Console.WriteLine("5. Throw and buy a new one later (you lose your money)");

        Console.Write(": ");

        if (int.TryParse(Console.ReadLine(), out int choice) && choice >= 1 && choice <= 5)
        {
            actions[choice]();
        }
        else
        {
            Console.WriteLine("Invalid choice. Please enter a number between 1 and 5.");
            ShowMenu();
        }
    }

    static void Main()
    {
        ShowMenu();
    }

    private static Action[] actions = {
        CheckBalance,
        Deposit,
        Withdraw,
        PutInPocket,
        ExitProgram
    };
}
