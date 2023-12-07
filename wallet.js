const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let balance = 0;

function checkBalance() {
  console.log(`Your current balance is: ${balance}$`);
  showMenu();
}

function deposit() {
  rl.question('How much money to deposit? ', (amount) => {
    amount = parseFloat(amount);
    if (!isNaN(amount) && amount > 0) {
      balance += amount;
      console.log(`You deposit ${amount}$. Your new balance is: ${balance}$`);
    } else {
      console.log('Invalid amount. Please enter a valid number.');
    }
    showMenu();
  });
}

function withdraw() {
  rl.question('How much money to withdraw? ', (amount) => {
    amount = parseFloat(amount);
    if (!isNaN(amount) && amount > 0) {
      if (amount > balance) {
        console.log('You too poor for that.');
      } else {
        balance -= amount;
        console.log(`You withdraw ${amount}$. Your new balance is: ${balance}$`);
      }
    } else {
      console.log('Invalid amount. Please enter a valid number.');
    }
    showMenu();
  });
}

function exitProgram() {
  console.log('You throw the wallet and never see it again, nor get the money inside it back.');
  rl.close();
}

function showMenu() {
  console.log(`
This is your wallet, what do you want to do?(choose a number)
1. Check balance
2. Deposit some money
3. Withdraw some money
4. Put in your pocket
5. Throw and buy a new one later (you lose your money)
`);
  rl.question(': ', (choice) => {
    switch (choice) {
      case '1':
        checkBalance();
        break;
      case '2':
        deposit();
        break;
      case '3':
        withdraw();
        break;
      case '4':
        console.log('You put the wallet in your pocket.');
        showMenu();
        break;
      case '5':
        exitProgram();
        break;
      default:
        console.log('Invalid choice. Please enter a number between 1 and 5.');
        showMenu();
        break;
    }
  });
}

showMenu();
