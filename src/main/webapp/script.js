function editUser(userId) {
    // Логика для редактирования пользователя с ID userId
    window.location.href = `userCabinet.jsp?id=${userId}`;
    console.log(`Editing user with ID: ${userId}`);
}

function deleteUser(userId) {
    // Логика для удаления пользователя с ID userId
    console.log(`Deleting user with ID: ${userId}`);
}


// document.addEventListener('DOMContentLoaded', function() {
//     const taskBoard = document.getElementById('taskBoard');
//     const createTaskButton = document.getElementById('createTaskButton');
//     const taskModal = document.getElementById('taskModal');
//     const closeButton = document.querySelector('.close');
//     const taskForm = document.getElementById('taskForm');
//     const taskIdInput = document.getElementById('taskId');
//     const titleInput = document.getElementById('title');
//     const descriptionInput = document.getElementById('description');
//     const statusInput = document.getElementById('status');
//
//     // Скрыть модальное окно по умолчанию
//     taskModal.style.display = 'none';
//
//
//     document.getElementById('createTaskButton').addEventListener('click', function() {
//         // Сброс формы или подготовка к новой задаче
//         document.getElementById('taskId').value = '';
//         document.getElementById('title').value = '';
//         document.getElementById('description').value = '';
//         document.getElementById('status').value = 'НЕ НАЧАТО';
//         showModal();
//     });
//
//
//     // Показать модальное окно для создания новой задачи
//     createTaskButton.addEventListener('click', function() {
//         taskIdInput.value = ''; // Сброс ID для новой задачи
//         titleInput.value = '';
//         descriptionInput.value = '';
//         statusInput.value = 'НЕ НАЧАТО';
//         taskModal.style.display = 'block';
//     });
//     window.addEventListener('click', function(event) {
//         if (event.target === taskModal) {
//             hideModal();
//         }
//     });
//
//     document.querySelector('.close').addEventListener('click', hideModal);
//     // Функция для показа модального окна
//     function showModal() {
//         taskModal.style.display = 'block';
//     }
//
//     // Функция для скрытия модального окна
//     function hideModal() {
//         taskModal.style.display = 'none';
//     }
//
//     // Закрыть модальное окно
//     closeButton.addEventListener('click', function() {
//         taskModal.style.display = 'none';
//     });
//
//     // Закрыть модальное окно при клике вне его области
//     window.addEventListener('click', function(event) {
//         if (event.target === taskModal) {
//             taskModal.style.display = 'none';
//         }
//     });
//
//     // Обработка отправки формы
//     taskForm.addEventListener('submit', function(event) {
//         event.preventDefault();
//         const task = {
//             id: taskIdInput.value,
//             title: titleInput.value,
//             description: descriptionInput.value,
//             tasksList: statusInput.value
//         };
//         const method = task.id ? 'PUT' : 'POST';
//         fetch('/user/tasks', {
//             method: method,
//             headers: {
//                 'Content-Type': 'application/json',
//             },
//             body: JSON.stringify(task)
//         })
//             .then(response => response.json())
//             .then(newTask => {
//                 if (method === 'POST') {
//                     addTaskToBoard(newTask);
//                 } else {
//                     updateTaskOnBoard(newTask);
//                 }
//                 taskModal.style.display = 'none';
//                 loadTasksFromServer(); // Обновить список задач
//             });
//     });
//
//     // Функция для добавления задачи на доску
//     function addTaskToBoard(task) {
//         const column = document.querySelector(`.task-column.${task.tasksList.toLowerCase().replace(" ", "-")}`);
//         if (column) {
//             const taskElement = createTaskElement(task);
//             column.appendChild(taskElement);
//             updateTaskCounts();
//         }
//     }
//
//     // Функция для обновления задачи на доске
//     function updateTaskOnBoard(task) {
//         const taskElement = document.querySelector(`.task-card[data-task-id="${task.id}"]`);
//         if (taskElement) {
//             taskElement.querySelector('h3').textContent = task.title;
//             taskElement.querySelector('p').textContent = task.description;
//             updateTaskCounts();
//         }
//     }
//
//     // Обработчик для кнопки редактирования
//     taskBoard.addEventListener('click', function(event) {
//         if (event.target.classList.contains('edit-button')) {
//             const taskId = event.target.getAttribute('onclick').match(/editTask\((\d+)\)/)[1];
//             fetch(`/user/tasks/${taskId}`)
//                 .then(response => response.json())
//                 .then(task => {
//                     taskIdInput.value = task.id;
//                     titleInput.value = task.title;
//                     descriptionInput.value = task.description;
//                     statusInput.value = task.tasksList;
//                     taskModal.style.display = 'block';
//                 });
//         }
//     });
//
//     // Обработчик для кнопки удаления
//     taskBoard.addEventListener('click', function(event) {
//         if (event.target.classList.contains('delete-button')) {
//             const taskId = event.target.getAttribute('onclick').match(/deleteTask\((\d+)\)/)[1];
//             if (confirm("Вы уверены, что хотите удалить эту задачу?")) {
//                 fetch(`/user/tasks/${taskId}`, { method: 'DELETE' })
//                     .then(() => {
//                         event.target.closest('.task-card').remove();
//                         updateTaskCounts();
//                     });
//             }
//         }
//     });
//
//     // Функция для создания элемента задачи
//     function createTaskElement(task) {
//         const taskElement = document.createElement('div');
//         taskElement.classList.add('task-card');
//         taskElement.dataset.taskId = task.id;
//         taskElement.innerHTML = `
//             <h3>${task.title}</h3>
//             <p>${task.description}</p>
//             <button class="edit-button" onclick="editTask(${task.id})">Редактировать</button>
//             <button class="delete-button" onclick="deleteTask(${task.id})">Удалить</button>
//         `;
//         return taskElement;
//     }
//
//     // Функция для обновления счетчиков задач
//     function updateTaskCounts() {
//         const taskColumns = document.querySelectorAll('.task-column');
//         taskColumns.forEach(column => {
//             const status = column.classList[1].replace('-', ' ');
//             const taskCount = column.querySelectorAll('.task-card').length;
//             column.querySelector('.task-count').textContent = taskCount;
//         });
//     }
//
//     // Функция для загрузки задач с сервера
//     function loadTasksFromServer() {
//         fetch('/user/tasks')
//             .then(response => response.json())
//             .then(tasks => {
//                 displayTasks(tasks);
//                 updateTaskCounts();
//             })
//             .catch(error => console.error('Error loading tasks:', error));
//     }
//
//     // Функция для отображения задач
//     function displayTasks(tasks) {
//         taskBoard.innerHTML = ''; // Очистить доску задач
//
//         const statuses = ["НЕ НАЧАТО", "В ПРОГРЕССЕ", "ВЫПОЛНЕНО"];
//         statuses.forEach(status => {
//             const column = document.createElement('div');
//             column.className = `task-column ${status.toLowerCase().replace(" ", "-")}`;
//
//             const header = document.createElement('div');
//             header.className = "column-header";
//             header.innerHTML = `<span class="status-dot"></span> ${status} <span class="task-count"></span>`;
//             column.appendChild(header);
//
//             const filteredTasks = tasks.filter(task => task.tasksList === status);
//             filteredTasks.forEach(task => {
//                 const card = createTaskElement(task);
//                 column.appendChild(card);
//             });
//             taskBoard.appendChild(column);
//         });
//     }
//
//     // Загрузить задачи при загрузке страницы
//     loadTasksFromServer();
// });