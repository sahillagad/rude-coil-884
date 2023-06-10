let removeOperator = async () => {

    let opid = document.querySelector("#operatorId").value;
   
    console.log(opid);
    let res = await fetch(`http://localhost:8888/adminController/operator/${opid}`, {
      method: "DELETE",
    //   body: JSON.stringify(department),
      headers: {
        "Content-Type": "application/json",
      },
    })
  
    // let data = await res.json();
    // return data;
    // console.log(res.json());
    alert("Department deleted successfuly with the Id " +opid)
    return res;
  
  };
  
  