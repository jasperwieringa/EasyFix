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

  // Clear the dialogs on open
  $("div[id^='new'].modal").on("shown.bs.modal", () => {
    $("input").val("");
    $("textarea").val("");
  })
})

