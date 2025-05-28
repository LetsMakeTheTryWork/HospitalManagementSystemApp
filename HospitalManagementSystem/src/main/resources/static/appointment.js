<script>
  const toggleBtn = document.getElementById("toggleFormBtn");
  const addSection = document.getElementById("addAppointmentSection");
  const cancelBtn = document.getElementById("cancelAppointment");
  const form = document.getElementById("appointmentForm");
  const tableBody = document.getElementById("appointmentsTableBody");

  const statusClasses = {
    Confirmed: "bg-green-100 text-green-800",
    Pending: "bg-yellow-100 text-yellow-800",
    Cancelled: "bg-red-100 text-red-800"
  };

  // Toggle add form
  toggleBtn.addEventListener("click", () => {
    addSection.classList.toggle("hidden");
    if (!addSection.classList.contains("hidden")) {
      addSection.scrollIntoView({ behavior: "smooth", block: "center" });
    }
  });

  // Cancel form
  cancelBtn.addEventListener("click", () => {
    form.reset();
    addSection.classList.add("hidden");
    toggleBtn.focus();
  });

  // Submit form to backend
  form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const patient = document.getElementById("patientName").value.trim();
    const doctor = document.getElementById("doctorName").value.trim();
    const date = document.getElementById("appointmentDate").value;
    const time = document.getElementById("appointmentTime").value;
    const status = document.getElementById("appointmentStatus").value;

    if (!patient || !doctor || !date || !time) {
      alert("Please fill all fields");
      return;
    }

    const newAppointment = {
      patientName: patient,
      doctorName: doctor,
      date: date,
      time: time,
      status: status
    };

    try {
      const response = await fetch('http://localhost:8080/api/appointments', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(newAppointment)
      });

      if (!response.ok) {
        throw new Error('Failed to save appointment');
      }

      const savedAppointment = await response.json();
      addAppointmentToTable(savedAppointment); // update UI
      form.reset();
      addSection.classList.add("hidden");
      toggleBtn.focus();
    } catch (error) {
      console.error("Error creating appointment:", error);
      alert("Error creating appointment. Check console for details.");
    }
  });

  // Fetch appointments on page load
  async function fetchAppointments() {
    try {
      const response = await fetch('http://localhost:8080/api/appointments');
      if (!response.ok) {
        throw new Error('Network error: ' + response.statusText);
      }

      const appointments = await response.json();
      appointments.forEach(addAppointmentToTable);
    } catch (error) {
      console.error("Error fetching appointments:", error);
    }
  }

  // Add one row to the table
  function addAppointmentToTable(appointment) {
    const tr = document.createElement("tr");
    tr.className = "hover:bg-gray-100";
    tr.innerHTML = `
      <td class="border border-gray-300 px-4 py-2">${appointment.id}</td>
      <td class="border border-gray-300 px-4 py-2">${appointment.patientName}</td>
      <td class="border border-gray-300 px-4 py-2">${appointment.doctorName}</td>
      <td class="border border-gray-300 px-4 py-2">${appointment.date}</td>
      <td class="border border-gray-300 px-4 py-2">${appointment.time}</td>
      <td class="border border-gray-300 px-4 py-2">
        <span class="px-3 py-1 rounded-full text-xs font-semibold ${statusClasses[appointment.status] || ''}">
          ${appointment.status}
        </span>
      </td>
      <td class="border border-gray-300 px-4 py-2 space-x-3">
        <button class="text-blue-600 hover:underline" onclick="alert('Edit not implemented')">Edit</button>
        <button class="text-red-600 hover:underline" onclick="this.closest('tr').remove()">Delete</button>
      </td>
    `;
    tableBody.appendChild(tr);
  }

  // Load appointments when the page loads
  document.addEventListener("DOMContentLoaded", fetchAppointments);
</script>
