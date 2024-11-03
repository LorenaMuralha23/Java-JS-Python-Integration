const form = document.getElementById("contactForm");

form.addEventListener("submit", function (event) {
  event.preventDefault();

  const name = document.getElementById("name").value;
  const profession = document.getElementById("profession").value;

  const formData = {
    name: name,
    profession: profession,
  };

  fetch("http://localhost:8080/test/send", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(formData),
  })
    .then((response) => response.json())
    .then((data) => {
      console.log("Success:", data);
      alert("Data successfully sent to the server!");
    })
    .catch((error) => {
      console.error("Error:", error);
      alert("Failed to send data.");
    });
});
