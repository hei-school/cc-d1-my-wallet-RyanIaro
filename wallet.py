def check_balance():
    print(f"Your current balance is: {balance}$.")
    show_menu()

def deposit():
    global balance
    amount = input("How much money to deposit? ")
    try:
        amount = float(amount)
        if amount > 0:
            balance += amount
            print(f"You deposited {amount}$. Your new balanceis: {balance}$.")
        else:
            print("Invalid amount. Please enter a positive number.")
    except ValueError:
        print("Invalid input. Please enter a valid number.")
    show_menu()

def withdraw():
    global balance
    amount = input("How much money to withdraw? ")
    try:
        amount = float(amount)
        if amount > 0:
            if amount <= balance:
                balance -= amount
                print(f"You withdraw {amount}$. Your new balanceis: {balance}$.")
            else:
                print("You too poor for that.")
        else:
            print("Invalid amount. Please enter a positive number.")
    except ValueError:
        print("Invalid input. Please enter a valid number.")
    show_menu()

def exit_program():
    print("Your throw the wallet and never see it again, nor get the money inside it back.")
    quit()

def put_in_pocket():
    print("You put the wallet in your pocket but it couldn't breathe so it came out.")
    show_menu()

def show_menu():
    print("\nThis is your wallet, what do you want to do?")
    print("1. Check balance")
    print("2. Deposit some money")
    print("3. Withdraw some money")
    print("4. Put in your pocket")
    print("5. Throw and buy a new one later (you lose your money)")

    choice = input(": ")

    try:
        choice = int(choice)
        if 1 <= choice <= 5:
            actions[choice]()
        else:
            print("Invalid choice. Please enter a number between 1 and 5.")
            show_menu()
    except ValueError:
        print("Invalid input. Please enter a valid number.")
        show_menu()

def main():
    show_menu()

balance = 0
actions = {
    1: check_balance,
    2: deposit,
    3: withdraw,
    4: put_in_pocket,
    5: exit_program
}

if __name__ == "__main__":
    main()
