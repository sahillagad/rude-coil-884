async function findAllOperator() {

  try {
    let res = await fetch(`http://localhost:8888/adminController/operator`, {
      method: "GET",
      // body:JSON.stringify(obj),
      headers: {
        "Content-Type": "application/json",
      },
      // body:JSON.stringify(obj)
    });
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
    // alert("Connection failed");
  }
}

window.onload(findAllOperator())

function appendData(data) {
  data.map(function (el) {
    
    let tr = document.createElement("tr");

    // creating td to append tr
    let opid = document.createElement("td");
    opid.innerText = el.operatorId;

    let opratorName = document.createElement("td");
    opratorName.innerText = el.operatorName;

    let email = document.createElement("td");
    email.innerText = el.email;

    let mobile = document.createElement("td");
    mobile.innerText = el.mobile;

    let status = document.createElement("td");
    status.innerText = el.operatorStatus;

    // appending td to tr
    tr.append(opid,opratorName,email,mobile,status);

    //appending tr to tbody
    document.querySelector("#tbody").append(tr);


  });
}
