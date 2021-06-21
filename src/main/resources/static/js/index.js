$(function () {
  // Bootstrap tooltips
  $('[data-toggle="tooltip"]').tooltip()

  // Clear the dialogs on open
  $(".modal").on("shown.bs.modal", () => {
    $("input").val("");
  })

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
})

