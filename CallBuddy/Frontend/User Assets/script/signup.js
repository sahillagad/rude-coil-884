document.querySelector("form").addEventListener("submit",userSignup)


 function userSignup(event){

    event.preventDefault();
    console.log("working")

    let name =document.getElementById("name").value

    let userName = document.getElementById("userName").value

    let email = document.getElementById("email").value

    let password = document.getElementById("password").value

    let mobile = document.getElementById("mobile").value

    console.log(name);




    let obj={};
    let type = "CANLOGIN";

    obj["name"] = name
    obj["userName"]=userName
    obj["email"]= email
    obj["password"]=password
    obj["mobile"]=mobile
    obj["customerStatus"]=type;

    console.log(obj);
    userSignUpFun(obj)

}

async function userSignUpFun(obj){

    try {

        let res = await fetch(`http://localhost:8888/customerController/Customer`, {
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
            alert("customer created successfuly")
            

        } else {

            let data = await res.json();
            let error = JSON.stringify(data)

            let msg = JSON.parse(error);

            console.log(msg)
            alert(msg.message)
        }

    } catch (error) {
        console.log(error)
        alert("customer created successfuly")
        window.location.href = "/Frontend/User Assets/login.html";

    }


}
