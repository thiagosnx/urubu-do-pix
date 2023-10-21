const url = "http://localhost:8080/users"

async function signup(){
    let username = document.getElementById("username").value
    let balance = document.getElementById("balance").value

    console.log(username, balance)

    const response=await fetch("http://localhost:8080/users", {
        method: "POST",
        headers: new Headers({
            "Content-Type": "application/json; charset=utf8",
            Accept: "application/json",
        }),
        body: JSON.stringify({
            username: username,
            balance: balance,
        }),
    });

    if(response.ok){
        showToast("#okToast");
    }else{
        showToast("#errorToast")
    }
}

function showToast(id) {
    var toastElList = [].slice.call(document.querySelectorAll(id));
    var toastList = toastElList.map(function (toastEl) {
      return new bootstrap.Toast(toastEl);
    });
    toastList.forEach((toast) => toast.show());
  }