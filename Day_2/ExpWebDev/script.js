// Select the necessary DOM elements
const expenseForm = document.getElementById('expense-form');
const expenseBody = document.getElementById('expense-body');
const totalAmountEl = document.getElementById('total-amount');

let expenses = [];
let totalAmount = 0;

// Add event listener for form submission
expenseForm.addEventListener('submit', (e) => {
    e.preventDefault();
    
    // Get values from the form inputs
    const date = document.getElementById('date').value;
    const category = document.getElementById('category').value;
    const amount = parseFloat(document.getElementById('amount').value);
    const description = document.getElementById('description').value;

    // Validate inputs
    if (!date || !category || !amount) {
        alert("Please fill all the required fields.");
        return;
    }

    // Create a new expense object
    const newExpense = { date, category, amount, description };

    // Add the new expense to the expenses array
    expenses.push(newExpense);

    // Update the total amount
    totalAmount += amount;

    // Update the UI
    updateExpenseTable();
    updateTotalAmount();

    // Reset form
    expenseForm.reset();
});

// Function to update the expense table in the UI
function updateExpenseTable() {
    // Clear the current table body
    expenseBody.innerHTML = '';

    // Loop through the expenses and create a new row for each expense
    expenses.forEach((expense) => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${expense.date}</td>
            <td>${expense.category}</td>
            <td>${expense.amount.toFixed(2)}</td>
            <td>${expense.description}</td>
        `;
        expenseBody.appendChild(row);
    });
}

// Function to update the total amount in the UI
function updateTotalAmount() {
    totalAmountEl.textContent = totalAmount.toFixed(2);
}
