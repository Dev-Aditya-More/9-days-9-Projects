import tkinter as tk
from tkinter import messagebox, simpledialog, font

# Function to add a task
def add_task():
    task = task_entry.get()
    if task:
        tasks_listbox.insert(tk.END, task)
        task_entry.delete(0, tk.END)
    else:
        messagebox.showwarning("Warning", "Please enter a task.")

# Function to update a selected task
def update_task():
    try:
        selected_task_index = tasks_listbox.curselection()[0]
        new_task = simpledialog.askstring("Update Task", "Enter the updated task:")
        if new_task:
            tasks_listbox.delete(selected_task_index)
            tasks_listbox.insert(selected_task_index, new_task)
    except IndexError:
        messagebox.showwarning("Warning", "Please select a task to update.")

# Function to remove a selected task
def remove_task():
    try:
        selected_task_index = tasks_listbox.curselection()[0]
        tasks_listbox.delete(selected_task_index)
    except IndexError:
        messagebox.showwarning("Warning", "Please select a task to remove.")

# Create the main window
app = tk.Tk()
app.title("To-Do List")
app.geometry("350x400")  # Initial window size reduced
app.configure(bg="#121212")  # Dark background

# Set custom font
custom_font = font.Font(family="Helvetica", size=12)

# Create the entry box for new tasks (slightly smaller)
task_entry = tk.Entry(app, bg="#1e1e1e", fg="white", insertbackground="white", font=custom_font, borderwidth=0, width=25)
task_entry.grid(row=0, column=0, padx=10, pady=20, sticky="ew")

# Create the button to add tasks (custom color)
add_task_button = tk.Button(app, text="Add Task", command=add_task, bg="#4CAF50", fg="black", font=custom_font, borderwidth=0)
add_task_button.grid(row=0, column=1, padx=10, pady=20)

# Create the Listbox to display tasks (slightly smaller)
tasks_listbox = tk.Listbox(app, bg="#1e1e1e", fg="white", selectbackground="#4e4e4e", selectforeground="black", font=custom_font, borderwidth=0, height=10)
tasks_listbox.grid(row=1, column=0, columnspan=2, padx=10, pady=10, sticky="nsew")

# Create the button to update tasks (custom color)
update_task_button = tk.Button(app, text="Update Task", command=update_task, bg="#FFA500", fg="black", font=custom_font, borderwidth=0)
update_task_button.grid(row=2, column=0, padx=10, pady=5, sticky="ew")

# Create the button to remove tasks (custom color)
remove_task_button = tk.Button(app, text="Remove Task", command=remove_task, bg="#F44336", fg="black", font=custom_font, borderwidth=0)
remove_task_button.grid(row=2, column=1, padx=10, pady=5, sticky="ew")

# Configure grid weight to make the Listbox expand
app.grid_rowconfigure(1, weight=1)
app.grid_columnconfigure(0, weight=1)
app.grid_columnconfigure(1, weight=0)

# Start the main loop
app.mainloop()
