

document.querySelector("form").addEventListener("submit", userSignin);

async function userSignin(e) {
  e.preventDefault();
  console.log("working");

  let userName = document.getElementById("userName").value;
  let password = document.getElementById("password").value;
  let userType = document.getElementById("userType").value;
  let type = userType.toUpperCase();

  const loginData = {
    userName: userName,
    password: password,
    userType: type,
  };

  userLoginFun(loginData);

}

let userLoginFun = async (obj) => {

  try {
    let res = await fetch("http://localhost:8888/loginController/login", {
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
    alert("admin logout successfuly");
    window.location.href = "./adminDashboard.html";
  }
};
