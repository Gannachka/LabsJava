
function addReference() {
    let url = document.getElementById("url");
    let description = document.getElementById("description");
    if (url.value !== "" && description.value !== "") {
        fetch("/Lab_25/Reference", {
            method: "POST",
            body: JSON.stringify({
                url: url.value,
                description: description.value
            })
        }).then(() => {
            getReferences();
        });
    }
}

function getReferences(filter) {
    let reference = document.getElementById("reference-models");
    reference.innerHTML = "";
    let queryString;
    if(filter==null)
        queryString="/Lab_25/Reference";
    else
        queryString="/Lab_25/Reference?filter="+filter;

    fetch(queryString, {
        method: "GET"
    }).then(res=>{
        sessionId=res.headers.get("sessionId");
        return res.json();
    }).then(res => {
        if (res) {
            res.forEach(elem => {
                let input="";
                if(signIn)
                    input=`<input type="button" value="delete" onclick="deleteReferenceData(${elem.id},'${elem.description}')">
                                 <input type="button" value="update" onclick="updateReferenceData('${elem.id}','${elem.url}','${elem.description}')">`;

                reference.innerHTML += `<table class="reference-table"><tr><td>${input}
                                 <input type="button" value="+${elem.plus}" onclick="updateReference('${elem.id}','plus', '${elem.plus}','${elem.minus}','${elem.url}','${elem.description}')">
                             <input type="button" value="-${elem.minus}" onclick="updateReference('${elem.id}','minus', '${elem.plus}','${elem.minus}','${elem.url}','${elem.description}')">
                             <input type="button" value="comments" onclick="getCommentForReference(${elem.id})">
                             [${elem.id}]
                             <a href="${elem.url}">${elem.description}</a>
                             </td></tr>
                             <tr><td id="${elem.id}"></td>
                             </table>`;
            })
        }
    })
}

function updateReferenceData(id,url,description) {
    document.getElementById(id).innerHTML =
        `<table class="reference-table">
              <tr><td>
                  <p>url:<input type="text" id="new-url" value="${url}" ></p>
                  <p>description:<input type="text" id="new-description" value="${description}"></p>
                  <p>
                      <input type="button" onclick="updateReference(${id})" value="update"><input type="button" value="cancel" onclick="clearContent(${id})">
                  </p>
              </td></tr>
         </table>`;
}

function deleteReferenceData(id,description) {
    document.getElementById(id).innerHTML =`<table class="reference-table">
                        <tr><td>
                        <p>
                            <span>${id}</span>
                            <span>${description}</span>
                        </p>
                            <input type="button" value="delete" onclick="deleteReference(${id})">
                            <input type="button" value="cancel" onclick="clearContent(${id})">
                        </td></tr>
                     </table>`;
}

function updateReference(id,recent,plus,minus,url,description){
    let plusN=Number(plus);
    let minusN=Number(minus);
    if(document.getElementById("new-url")!=null)
        url=document.getElementById("new-url").value;
    if(document.getElementById("new-url")!=null)
        description=document.getElementById("new-description").value;
    if(recent==="plus")
        plusN+=1;
    else if(recent==="minus")
        minusN+=1;
    fetch("/Lab_25/Reference",{
        method:"PUT",
        body:JSON.stringify({
            id:id,
            url:url,
            description:description,
            plus:plusN,
            minus:minusN
        })
    }).then(()=>{
       getReferences();
    });
}

function deleteReference(id){
    fetch("/Lab_25/Reference",{
        method:"DELETE",
        body:JSON.stringify({
            id:id
        })
    }).then(()=>{
        getReferences();
    })
}


