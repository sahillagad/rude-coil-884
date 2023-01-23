let loginButton = async () => {

  event.preventDefault();


  let username = document.querySelector("#username").value;
  let password = document.querySelector("#password").value;
  let userType = document.querySelector("#userType").value;

  let login = {};
  login["username"] = username;
  login["password"] = password;
  login["userType"] = userType;

  console.log(login);

  let res = await fetch("http://localhost:8888/loginController/login", {
    method: "POST",
    body: JSON.stringify(login),
    headers: {
      "Content-Type": "application/json",
    },
  });

  // let data = await res.json();
  // return data;
  // console.log(res.json());
  alert(`${username} is login Successfully`);
  return res;
};
