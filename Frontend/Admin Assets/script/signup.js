document.querySelector("form").addEventListener("submit",adminSignup)


 function adminSignup(event){

    event.preventDefault();
    console.log("working")

    let name =document.getElementById("name").value
    let userName = document.getElementById("userName").value
    let email = document.getElementById("email").value
    let password = document.getElementById("password").value

    const adminObj = {
        adminName: name,
        email:email,
        userName:userName,
        password:password
      };

    userSignUpFun(adminObj)

}

// now I am sending data

let userSignUpFun = async (obj) => {

    try {
      let res = await fetch("http://localhost:8888/adminController/admin", {
        method: "POST",
        body: JSON.stringify(obj),
        headers: {
          "Content-Type": "application/json",
        },
      });
  
      if (res.ok) {
        console.log("sucesss");
        let data = await res.json();
  
        // To get data from response   // user data
        // let userData=JSON.stringify(data)
        let d = JSON.stringify(data);
        
      } else {
        let data = await res.json();
        let error = JSON.stringify(data);
  
        let msg = JSON.parse(error);
  
        console.log(msg);
        alert(msg.message);
      }
  
    } catch (error) {
      console.log(error);
      alert("admin created successfuly");
      window.location.href = "./login.html";
    }
  };
