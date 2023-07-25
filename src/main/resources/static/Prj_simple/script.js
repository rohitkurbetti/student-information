// Custom JavaScript for form submission and dynamic employee list (Dummy data used)
const employeeForm = document.getElementById('employeeForm');
const employeeList = document.querySelector('tbody');

employeeForm.addEventListener('submit', function (e) {
  e.preventDefault();
  const name = document.getElementById('name').value;
  const email = document.getElementById('email').value;
  const department = document.getElementById('department').value;

  // Create a new row for the employee list
  const newRow = document.createElement('tr');
  newRow.innerHTML = `
    <td>${Math.floor(Math.random() * 1000)}</td>
    <td>${name}</td>
    <td>${email}</td>
    <td>${department}</td>
  `;

  // Add the new row to the employee list
  employeeList.appendChild(newRow);

  // Reset the form fields
  employeeForm.reset();
});
