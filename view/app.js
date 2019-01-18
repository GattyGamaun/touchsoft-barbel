const form = document.querySelector('#task-form');
const collection = document.querySelector('.collection');
const clearBtn = document.querySelector('.clear-tasks');
const platesInput = document.querySelector('#plates');
const weightInput = document.querySelector('#weight');

function removeWeight(e) {
  if (e.target.parentElement.classList.contains('delete-item')) {
    e.target.parentElement.parentElement.remove();
  }
}

function addWeight(e) {
  e.preventDefault();
  if (weightInput.value === '') {
    alert('add a weight');
  }
  else  {
    const li = document.createElement('li');
    li.className = 'collection-item';
    li.appendChild(document.createTextNode(weightInput.value));
    const link = document.createElement('a');
    link.className = 'delete-item secondary-content';
    link.innerHTML = '<i class="fa fa-remove"></i>';
    li.appendChild(link);
    collection.appendChild(li);
    weightInput.value = '';
  }
}

function loadEventListeners() {
  //add weight
  form.addEventListener('submit', addWeight);
  //delete weight from list
  collection.addEventListener('click', removeWeight);
}

//Load all event listeners
loadEventListeners();