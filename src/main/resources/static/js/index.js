$(function () {
  // Bootstrap tooltips
  $('[data-toggle="tooltip"]').tooltip()

  // Clear the dialogs on open
  $(".modal").on("shown.bs.modal", () => {
    $("input").val("");
  })
})

