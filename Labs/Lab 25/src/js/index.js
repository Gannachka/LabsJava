var signIn;
var sessionId;

function authorization() {
    let passwordP = document.getElementById('password')
    fetch("/Lab_25/Authorization", {
        method: 'POST',
        body:JSON.stringify({
            password:passwordP.value
        })
    }).then(res=>res.json()).then(res=>{
        alert(res);
        if(res!=="error") {
            signIn=true;
            visibilityAuthorization("hidden");
            getReferences();
        }
    });
}

function logOff(){
    signIn=false;
    visibilityAuthorization("visible");
    getReferences();
}

function visibilityInsertForm(){
    let form=document.getElementById("insert-form");
    if(form.innerHTML==="") {
        form.innerHTML = `<p>url:<input type="text" id="url"></p>
            <p>description:<input type="text" id="description"></p>
            <p>
                <input type="button" onclick="addReference()" value="add"><input type="button" onclick="clearContent('insert-form')" value="Cancel">
            </p>`;
    }
    else {
        form.innerText="";
    }
}

function visibilityFilterForm() {
    let form = document.getElementById("filter-form");
    if (form.innerHTML === "") {
        form.innerHTML = `<input type="text" id="filterDescription">
                <p>
                    <input type="button" onclick="getReferences(document.getElementById('filterDescription').value)" value="filter"><input type="button" onclick="clearContent('filter-form')" value="Cancel">
                </p>`;
    } else {
        form.innerText = "";
    }
}

function clearContent(id) {
    document.getElementById(id).innerHTML = "";
}

function visibilityAuthorization(visible) {
    if (visible === "hidden") {
        document.getElementById("password").classList.add("display-no");
        document.getElementById("set").classList.add("display-no");
        document.getElementById("reset").classList.remove("display-no");
        document.getElementById("insert").classList.remove("display-no");
    } else {
        document.getElementById("password").classList.remove("display-no");
        document.getElementById("set").classList.remove("display-no");
        document.getElementById("reset").classList.add("display-no");
        document.getElementById("insert").classList.add("display-no");
    }
}