  async function findDepartmentById() {

    let deptId = document.querySelector("#departmentId").value;

    try {

        let res = await fetch(`http://localhost:8888/adminController/department/${deptId}`, {
            method: "GET",
            // body:JSON.stringify(obj),
            headers: {
                "Content-Type": "application/json"
            }
            // body:JSON.stringify(obj)
        })
        console.log(res)
        if (res.ok) {
            console.log("sucesss")
            let data = await res.json();

            // To get data from response   // user data
            // let userData=JSON.stringify(data)
            let d = JSON.stringify(data)


            console.log(d);
            appendData(data)

        } else {

            let data = await res.json();
            let error = JSON.stringify(data)

            let msg = JSON.parse(error);

            console.log(msg)
            alert(msg.message)
        }

    } catch (error) {
        console.log(error)
        alert("Connection failed")
       

    }


}


function appendData(data) {

    data.map(function (el) {

    // let tr = document.createElement("tr");
    // let routeId = document.createElement("td");
    // routeId.innerText=el.routeId

    let deptId = document.querySelector("#deptId");
    deptId.innerText = el.departmentId;

    let deptName = document.querySelector("#deptName");
    deptName.innerText = el.departmentName;

    let deptState = document.querySelector("#deptState");
    deptState.innerText = el.departmentState;

    let deptCity = document.querySelector("#deptCity");
    deptCity.innerText = el.departmentCity;

    let deptPincode = document.querySelector("#deptPincode");
    deptPincode.innerText = el.pincode;
    
    

    });

    }

  
  