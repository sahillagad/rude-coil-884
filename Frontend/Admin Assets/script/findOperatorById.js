async function findOperatorById() {
  let opid = document.querySelector("#operatorId").value;

  try {
    let res = await fetch(
      `http://localhost:8888/adminController/operator/${opid}`,
      {
        method: "GET",
        // body:JSON.stringify(obj),
        headers: {
          "Content-Type": "application/json",
        },
        // body:JSON.stringify(obj)
      }
    );
    console.log(res);
    if (res.ok) {
      console.log("sucesss");
      let data = await res.json();

      // To get data from response   // user data
      // let userData=JSON.stringify(data)
      let d = JSON.stringify(data);

      console.log(d);
      appendData(data);
    } else {
      let data = await res.json();
      let error = JSON.stringify(data);

      let msg = JSON.parse(error);

      console.log(msg);
      alert(msg.message);
    }
  } catch (error) {
    console.log(error);
    alert("Connection failed");
  }
}

function appendData(data) {
  
    let opId = document.querySelector("#opId");
    opId.innerText = data.operatorId;

    let opName = document.querySelector("#opName");
    opName.innerText = data.operatorName;

    let opCity = document.querySelector("#userName");
    opCity.innerText = data.userName;

    let password = document.querySelector("#password");
    password.innerText = data.password;

    let email = document.querySelector("#email");
    email.innerText = data.email;

    let city = document.querySelector("#opCity");
    city.innerText = data.city;

    let phone = document.querySelector("#phone");
    phone.innerText = data.mobile;

    let status = document.querySelector("#status");
    status.innerText = data.operatorStatus;

}
