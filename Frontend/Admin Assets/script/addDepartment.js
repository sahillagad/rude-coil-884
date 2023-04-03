let addDepartment = async () => {
  let departmentName = document.querySelector("#departmentName").value;
  let departmentState = document.querySelector("#departmentState").value;
  let departmentCity = document.querySelector("#departmentCity").value;
  let pincode = document.querySelector("#pincode").value;
  let department = {};
  department["departmentName"] = departmentName;
  department["departmentState"] = departmentState;
  department["departmentCity"] = departmentCity;
  department["pincode"] = pincode;

  


  let res = await fetch("http://localhost:8888/adminController/department", {
    method: "POST",
    body: JSON.stringify(department),
    headers: {
      "Content-Type": "application/json",
    },
  })

  alert("Department added successfuly")
  window.location.href = "./adminDashboard.html";
  return res;


};

