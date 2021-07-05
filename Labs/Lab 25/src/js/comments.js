function getCommentForReference(id){
    fetch('/Lab_25/Comment?id='+id, {
        method: 'GET'
    }).then(res => res.json()).then(res => {
        let data = `<table>
                    <tr><td>
                        <h3>--UWSR comments/${id}--</h3>
                        <input type="button" onclick="insertCommentData(${id})" value="insert">
                        <input type="button" onclick="clearContent(${id})" value="cansel">
                        <div id="insert-comment${id}"></div>
                    </td></tr>
                </table>`
        if (res) {
            res.forEach(elem => {
                let comments = `<table class="reference-table"><tr><td><p>${elem.stamp}</p>`;
                if (signIn === true)
                    comments += `<p id="button-comment${elem.id}"><input type="button" value="delete" onclick="deleteComment(${elem.id},${elem.wsrefId})">
                                <input type="button" value="update" onclick="updateComment(${elem.id},${elem.wsrefId})"></p>
                                <textarea id="txt${elem.id}">${elem.comtext}</textarea></td></tr></table>`;
                else
                    comments += `<textarea readonly id="txt${elem.id}">${elem.comtext}</textarea></td></tr></table>`;
                data += comments;
            })
        }
        document.getElementById(id).innerHTML = data;
    })
}

function insertCommentData(id){
    let form = `<input type="text" id="comment"><br>
                <p>
                    <input type="button" onclick="addComment(${id})" value="add"><input type="button" value="cancel" onclick="clearContent('insertComment${id}')">
                </p>`
    document.getElementById("insert-comment"+id).innerHTML = form;
}

function addComment(id){
    fetch("/Lab_25/Comment",{
        method:"POST",
        body:JSON.stringify({
            wsrefId:id,
            sessionId:sessionId,
            comtext:document.getElementById("comment").value
        })
    }).then(()=>{
        getReferences();
    })
}

function updateComment(id,refId){
    fetch("/Lab_25/Comment",{
        method:"PUT",
        body:JSON.stringify({
            id:id,
            comtext:document.getElementById("txt"+id).value
        })
    }).then(()=>{
        //getCommentForReference(refId);
        document.getElementById("button-comment"+id).innerHTML="update";
    })
}

function deleteComment(id,refId){
    fetch("/Lab_25/Comment",{
        method:"DELETE",
        body:JSON.stringify({
            id:id
        })
    }).then(()=>{
        //getCommentForReference(refId);
        document.getElementById("button-comment"+id).innerHTML="delete";
    })
}