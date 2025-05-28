document.addEventListener("DOMContentLoaded", () => {
  const modal = document.getElementById("patientModal");
  const addPatientBtn = document.getElementById("addPatientBtn");
  const closeModalBtn = document.getElementById("closeModalBtn");
  const cancelBtn = document.getElementById("cancelBtn");
  const patientForm = document.getElementById("patientForm");
  const patientTableBody = document.getElementById("patientTableBody");

  let patientIdCounter = 1;

  // Open modal
  addPatientBtn.addEventListener("click", () => {
    modal.classList.remove("hidden");
    document.getElementById("modalTitle").textContent = "Add Patient";
    patientForm.reset();
  });

  // Close modal
  closeModalBtn.addEventListener("click", () => {
    modal.classList.add("hidden");
  });

  cancelBtn.addEventListener("click", () => {
    modal.classList.add("hidden");
  });

  // Handle form submission
  patientForm.addEventListener("submit", (e) => {
    e.preventDefault();

    const name = document.getElementById("patientName").value;
    const email = document.getElementById("patientEmail").value;
    const phone = document.getElementById("patientPhone").value;
    const dob = document.getElementById("patientDOB").value;

    // Add to table
    const row = document.createElement("tr");
    row.classList.add("hover:bg-gray-50");

    row.innerHTML = `
      <td class="px-6 py-4 whitespace-nowrap">${patientIdCounter++}</td>
      <td class="px-6 py-4">${name}</td>
      <td class="px-6 py-4">${email}</td>
      <td class="px-6 py-4">${phone}</td>
      <td class="px-6 py-4">${dob}</td>
      <td class="px-6 py-4 text-right">
        <button class="text-red-600 hover:text-red-800" onclick="this.closest('tr').remove()">Delete</button>
      </td>
    `;

    patientTableBody.appendChild(row);

    // Close modal
    modal.classList.add("hidden");
    patientForm.reset();
  });

    <script>
  // Function to fetch patients from backend and display them
  function loadPatients() {
    fetch('/api/patients')
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not OK');
        }
        return response.json();
      })
      .then(patients => {
        const container = document.getElementById('patients-list');
        container.innerHTML = '';  // clear previous content

        patients.forEach(patient => {
          // Create a simple div for each patient
          const patientDiv = document.createElement('div');
          patientDiv.textContent = `${patient.id}: ${patient.name} - ${patient.email}`;
          container.appendChild(patientDiv);
        });
      })
      .catch(error => {
        console.error('Error fetching patients:', error);
      });
  }

  // Call loadPatients() when page loads
  window.onload = loadPatients;
</script>