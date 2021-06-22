$(function () {
  // Bootstrap tooltips
  $("[data-toggle='tooltip']").tooltip()

  // Bootstrap form validation
  window.addEventListener("load", function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    const forms = document.getElementsByClassName("needs-validation");
    // Loop over them and prevent submission
    const validation = Array.prototype.filter.call(forms, form => {
      form.addEventListener("submit", event => {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add("was-validated");
      }, false);
    });
  }, false);

  // Attach a datepicker to an input element.
  const pickerButton = $("#pickerButton");
  const picker = datepicker(document.getElementById("datepicker"), {
    noWeekends: true,
  });

  if (!picker || !pickerButton) {
    return;
  }

  pickerButton.on("click", e => {
    e.stopPropagation()

    const isHidden = picker.calendarContainer.classList.contains("qs-hidden")
    picker[isHidden ? "show" : "hide"]()
  })

  // Clear the dialogs on open
  $("#newAppointmentModal, #newCustomerModal, #newEmployeeModal").on("shown.bs.modal", () => {
    $("input").val("");
    $("textarea").val("");
  })
})

