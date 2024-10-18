from flask import Flask, render_template, request, jsonify

app = Flask(__name__)

# In-memory list to store tasks
tasks = []

@app.route('/')
def index():
    return render_template('index.html', tasks=tasks)

@app.route('/add', methods=['POST'])
def add_task():
    task = request.form['task']
    if task:
        tasks.append(task)
    return jsonify(tasks)

@app.route('/update/<int:task_id>', methods=['POST'])
def update_task(task_id):
    new_task = request.form['task']
    if new_task:
        tasks[task_id] = new_task
    return jsonify(tasks)

@app.route('/remove/<int:task_id>', methods=['DELETE'])
def remove_task(task_id):
    if 0 <= task_id < len(tasks):
        tasks.pop(task_id)
    return jsonify(tasks)

if __name__ == '__main__':
    app.run(debug=True)
