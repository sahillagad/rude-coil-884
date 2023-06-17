

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

  try {
    const StoringData = await userSignUpFun(loginData);
    // localStorage.setItem('sessionKey', StoringData.sessionkey);
    // localStorage.setItem('userId', StoringData.userId); 
    alert("admin login successfully");
    window.location.href = "./addDepartment.html";
  } catch (error) {
    console.error(error);
    alert("Error: " + error.message);
  }

}

let userSignUpFun = async (obj) => {

  try {
    const res = await fetch("http://localhost:8888/loginController/login", {
      method: "POST",
      body: JSON.stringify(obj),
      headers: {
        "Content-Type": "application/json",
      },
    });

    if (res.ok) {
      console.log("success");
      const data = await res.json();
      return data

    } else {

      const data = await res.json();
      const error = JSON.stringify(data);
      const msg = JSON.parse(error);
      console.log(msg);
      throw new Error(msg.message);

    }
  } catch (error) {
    console.log(error);
    throw new Error(error);
  }

};
