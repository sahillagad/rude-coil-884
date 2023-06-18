let deleteDepartment = async () => {

    let deptId = document.querySelector("#departmentId").value;
   
    console.log(deptId);
    let res = await fetch(`http://localhost:8888/adminController/department/${deptId}`, {
      method: "DELETE",
    //   body: JSON.stringify(department),
      headers: {
        "Content-Type": "application/json",
      },
    })
  
    // let data = await res.json();
    // return data;
    // console.log(res.json());
    alert("Department deleted successfuly")
    window.location.href = "./adminDashboard.html";
    return res;
  
  };
  
  