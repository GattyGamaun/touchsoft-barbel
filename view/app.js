const form = document.querySelector('#task-form');
const collection = document.querySelector('.collection');
const clearBtn = document.querySelector('.clear-tasks');
const weightInput = document.querySelector('#weight');

function createElements(value) {
  const li = document.createElement('li');
  li.className = 'collection-item';
  li.appendChild(document.createTextNode(value));
  const link = document.createElement('a');
  const disk = document.createElement('a');
  link.className = 'delete-item secondary-content';
  link.innerHTML = '<i class="fa fa-remove"></i>';
  disk.className = 'move-plate secondary-content';
  disk.innerHTML = '<i class="fas fa-compact-disc"></i>';
  li.appendChild(link);
  li.appendChild(disk);
  collection.appendChild(li);
}

function addWeight(e) {
  e.preventDefault();
  if (weightInput.value === '') {
    alert('add a weight');
  }
  else {
    createElements(weightInput.value);
    //store in local storage
    storeWeightInLocalStorage(weightInput.value);
    //clear input
    weightInput.value = '';
  }
}

function removeWeight(e) {
  if (e.target.parentElement.classList.contains('delete-item')) {
    e.target.parentElement.parentElement.remove();
    //remove from local storage
    removeFromLocalStorage(e.target.parentElement.parentElement);
  }
}

function removeFromLocalStorage(item) {
  let weights;
  if (localStorage.getItem('weights') === null) {
    weights = [];
  } else {
    weights = JSON.parse(localStorage.getItem('weights'));
  }

  weights.forEach((weight, index) => {
    if(item.textContent === weight) {
      weights.splice(index, 1);
    }
  });

  localStorage.setItem('weights', JSON.stringify(weights));
}

function removeList() {
  while (collection.firstChild) {
    collection.removeChild(collection.firstChild);
  }
  //clear from local storage
  localStorage.clear();
}

function storeWeightInLocalStorage(value) {
  let weights;
  if (localStorage.getItem('weights') === null) {
    weights = [];
  } else {
    weights = JSON.parse(localStorage.getItem('weights'));
  }

  weights.push(value);

  localStorage.setItem('weights', JSON.stringify(weights));
}

function getWeights() {
  let weights;
  if (localStorage.getItem('weights') === null) {
    weights = [];
  } else {
    weights = JSON.parse(localStorage.getItem('weights'));
  }

  weights.forEach((weight) => {
    createElements(weight);
  });
}

function movePlate(e) {
  // if (e.target.parentElement.classList.contains('move-plate')) {
  if (e.target.parentElement) {
    e.preventDefault();
    console.log(e.target.innerText);
  }
}

function loadEventListeners() {
  //DOM load event
  document.addEventListener('DOMContentLoaded', getWeights);
  //add weight
  form.addEventListener('submit', addWeight);
  //delete weight from list
  collection.addEventListener('click', removeWeight);
  //delete list of plates
  clearBtn.addEventListener('click', removeList);
  //move plate to left
  collection.addEventListener('click', movePlate);
  //move plate to right
  collection.addEventListener('contextmenu', movePlate);
}

//Load all event listeners
loadEventListeners();