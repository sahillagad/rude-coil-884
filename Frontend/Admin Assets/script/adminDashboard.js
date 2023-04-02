//  get vendor profile- get request

const sessionKey = localStorage.getItem("sessionKey");
console.log(sessionKey);

let adminLoggedin = async () => {
    try {
        const res = await fetch(
            `http://localhost:8888//adminController/singalAdmin/${sessionKey}`,
            {
                method: "GET",
                headers: {
                    "Content-Type": "application/json",
                },
            }
        );

        if (res.ok) {
            console.log("success");
            const data = await res.json();
            return data;
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

//   after calling I am appending data in html
let appendData = (data) => {
    // selecting from html and after that appending into it
    const dataContainer = document.querySelector("#dataContainer");
    const p1 = document.querySelector("#name");
    const p2 = document.querySelector("#userName");
    const p3 = document.querySelector("#email");
    const p4 = document.querySelector("#password");

    // creating span tag
    const name = document.createElement("span");
    const userName = document.createElement("span");
    const email = document.createElement("span");
    const password = document.createElement("span");

    name.innerText = data.adminName;
    userName.innerText = data.userName;
    email.innerText = data.email;
    password.innerText = data.password;

    // appending span tag in p tag and then p tag in div container

    p1.append(name);
    p2.append(userName);
    p3.append(email);
    p4.append(password);
    dataContainerContainer.append(p1,p2,p3,p4);
    console.log(data)
};

// calling  api for admin data after login
window.addEventListener("load", async () => {
    const adminData = await adminLoggedin();
    appendData(adminData);
});


