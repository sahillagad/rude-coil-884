async function findOperatorById() {

    let opid = document.querySelector("#operatorId").value;

    try {

        let res = await fetch(`http://localhost:8888/adminController/operator/${opid}`, {
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
            appendData(d)

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

    let opId = document.querySelector("#opId");
    opId.innerText = el.operatorId;

    let opName = document.querySelector("#opName");
    opName.innerText = el.operatorName;

    let opCity = document.querySelector("#opCity");
    opCity.innerText = el.operatorCity;

    let email = document.querySelector("#email");
    email.innerText = el.email;

    let status = document.querySelector("#status");
    status.innerText = el.operatorStatus;
    
    

    });

    }

  
  