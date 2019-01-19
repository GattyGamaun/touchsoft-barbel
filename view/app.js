const form = document.querySelector('#task-form');
const collection = document.querySelector('.collection');
const clearBtn = document.querySelector('.clear-tasks');
const weightInput = document.querySelector('#weight');
const leftBtn = document.querySelector('#left');
const rightBtn = document.querySelector('#right');
const middleBtn = document.querySelector('#middle');
const weightsLeft = [];
const weightsRight = [];
let sumWeightsLeft;
let sumWeightsRight;

function createElements(value) {
  const li = document.createElement('li');
  li.className = 'collection-item';
  li.appendChild(document.createTextNode(value));
  const link = document.createElement('a');
  const disk = document.createElement('a');
  link.className = 'delete-item secondary-content';
  link.innerHTML = '<i class="fa fa-remove"></i>';
  disk.className = 'move-plate secondary-content left';
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
    //clear input
    weightInput.value = '';
  }
}

function removeWeight(e) {
  if (e.target.parentElement.classList.contains('delete-item')) {
    e.target.parentElement.parentElement.remove();
  }
}

function removeList() {
  while (collection.firstChild) {
    collection.removeChild(collection.firstChild);
  }
}

function movePlateLeft(e) {
  if (e.target.parentElement) {
    e.preventDefault();
    weightsLeft.push(JSON.parse(e.target.innerText));
    sumWeightsLeft = weightsLeft.reduce((a, b) => a + b);
    leftBtn.innerText = sumWeightsLeft;
    e.target.remove();
    //barbell is ready
    isReady();
  }
}

function movePlateRight(e) {
  if (e.target.parentElement) {
    e.preventDefault();
    weightsRight.push(JSON.parse(e.target.innerText));
    sumWeightsRight = weightsRight.reduce((a, b) => a + b);
    rightBtn.innerText = sumWeightsRight;
    e.target.remove();
    //barbell is ready
    isReady();
  }
}

function isReady() {
  if (sumWeightsRight === sumWeightsLeft) {
    middleBtn.className = 'waves-effect waves-light btn teal darken-1';
    middleBtn.innerText = 'Barbell is ready';
  }
  else {
    middleBtn.className = 'waves-effect waves-light btn pink lighten-2';
    middleBtn.innerText = '------------------';
  }
}

function movePlateBackFromLeft(e) {
  e.preventDefault();
  if (weightsLeft.length > 0) {
    let deletedWeight = weightsLeft.pop();
    createElements(deletedWeight);
    if (weightsLeft.length > 0) {
      sumWeightsLeft = weightsLeft.reduce((a, b) => a + b);
      leftBtn.innerText = sumWeightsLeft;
      //barbell is ready
      isReady();
    } else {
      leftBtn.innerText = 'Left';
    }
  }
}

function movePlateBackFromRight(e) {
  e.preventDefault();
  if (weightsRight.length > 0) {
    let deletedWeight = weightsRight.pop();
    createElements(deletedWeight);
    if (weightsRight.length > 0) {
      sumWeightsRight = weightsRight.reduce((a, b) => a + b);
      rightBtn.innerText = sumWeightsRight;
      //barbell is ready
      isReady();
    } else {
      rightBtn.innerText = 'Left';
    }
  }
}

function loadEventListeners() {
  //add weight
  form.addEventListener('submit', addWeight);
  //delete weight from list
  collection.addEventListener('click', removeWeight);
  //delete list of plates
  clearBtn.addEventListener('click', removeList);
  //move plate to left
  collection.addEventListener('click', movePlateLeft);
  //move plate to right
  collection.addEventListener('contextmenu', movePlateRight);
  //move plate from left back to list
  leftBtn.addEventListener('click', movePlateBackFromLeft);
  //move plate from right back to list
  rightBtn.addEventListener('click', movePlateBackFromRight);
}

//Load all event listeners
loadEventListeners();


