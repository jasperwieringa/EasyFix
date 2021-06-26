$(function () {
  // Bootstrap tooltips
  $("[data-toggle='tooltip']").tooltip()

  // Bootstrap custom tables
  $(".table").bootstrapTable()

  // Bootstrap custom modal tables
  $(".modal").on("shown.bs.modal", function () {
    $(".table").bootstrapTable('resetView')
  })

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
    $("input").val("");-
    $("textarea").val("");
  })

  // Handle the newUsedPartForm
  const newUsedPartForm = $("#newUsedPartForm");
  $(newUsedPartForm).on("submit", e => {
    e.preventDefault();
    const data = $("#newUsedPartForm :input").serializeArray();
    const customerId = $(newUsedPartForm).data("id");
    const filteredData = data.filter(input => !!input.value)
    const usedParts = filteredData.map(item => {
      return {
        part: parseInt(item.name),
        quantity: parseInt(item.value)
      }
    })

    $.ajax({
      type: "POST",
      contentType: "application/json",
      url: `/customer/${customerId}/appointment/add_part`,
      data: JSON.stringify(usedParts),
      dataType: 'json',
      cache: false,
      timeout: 600000
    }).done(resp => {
      if (resp["msg"] === "Success") {
        location.reload();
      }
    })
  });
})

