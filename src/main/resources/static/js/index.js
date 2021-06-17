$(function () {
  // Bootstrap tooltips
  $('[data-toggle="tooltip"]').tooltip()

  // Clear the dialogs on open
  $("#newEmployeeModal, #newCustomerModal").on("shown.bs.modal", () => {
    $("input").val("");
  })
})

