let updateOperator = async () => {

    let operatorId = document.querySelector("#operatorId").value;
    let operatorName = document.querySelector("#operatorName").value;
    let userName = document.querySelector("#userName").value;
    let email = document.querySelector("#email").value;
    let password = document.querySelector("#password").value;
    let mobile = document.querySelector("#mobile").value;
    let city = document.querySelector("#city").value;


    let operator = {};
    operator["operatorId"] = operatorId;
    operator["operatorName"] = operatorName;
    operator["userName"] = userName;
    operator["email"] = email;
    operator["password"] = password;
    operator["mobile"] = mobile;
    operator["city"] = city;
    
  
    try {

        let res = await fetch(`http://localhost:8888/adminController/operator`, {
            method: "PUT",
            body:JSON.stringify(operator),
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
            alert("operator updated successfuly")

        } else {

            let data = await res.json();
            let error = JSON.stringify(data)

            let msg = JSON.parse(error);

            console.log(msg)
            alert(msg.message)
        }

    } catch (error) {
        console.log(error)
        alert("operator updated successfuly")
       

    }
  
  
  };
  
  