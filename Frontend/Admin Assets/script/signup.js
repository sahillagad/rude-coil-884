document.querySelector("form").addEventListener("submit",adminSignup)


 function adminSignup(event){

    event.preventDefault();
    console.log("working")

    let name =document.getElementById("name").value

    let userName = document.getElementById("userName").value

    let email = document.getElementById("email").value

    let password = document.getElementById("password").value

    let deptName = document.getElementById("departmentName").value

    let deptState = document.getElementById("departmentState").value

    let deptCity = document.getElementById("departmentCity").value

    let deptpincode = document.getElementById("pincode").value

    console.log(name);



    let department = {};

    department["departmentId"]
    department["departmentName"] = deptName;
    department["departmentState"] = deptState
    department["departmentCity"] = deptCity
    department["pincode"] = deptpincode


    let obj={};

    obj["adminName"] = name
    obj["userName"]=userName
    obj["email"]= email
    obj["password"]=password
    obj["department"] = [department]

    console.log(obj);
    userSignUpFun(obj)

}

async function userSignUpFun(obj){

    try {

        let res = await fetch(`http://localhost:8888/adminController/admin`, {
            method: "POST",
            body:JSON.stringify(obj),
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
            alert("admin created successfuly")
            

        } else {

            let data = await res.json();
            let error = JSON.stringify(data)

            let msg = JSON.parse(error);

            console.log(msg)
            alert(msg.message)
        }

    } catch (error) {
        console.log(error)
        alert("admin created successfuly")
        window.location.href = "/Frontend/Admin Assets/login.html";

    }


}
