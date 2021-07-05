function Fill_JSON(req){
    var  xx = eval('('+req.responseText+')');
    var rc = "";
    for (var i = 0; i < xx.X.length; i++){
        rc += (xx.X[i].rand +" ");
    }
    return (rc);
};

function OnClick_JSON(n, s){
    var patern = new RegExp(/^[1-9]+[0-9]*$/);
    console.log(n);
    if (patern.test(n)){
        if (req){
            req=new XMLHttpRequest();
            req.open("POST","http://localhost:8080/Lab_21/Sss_JSON", false);
            req.setRequestHeader("XRand-N",  n);
            req.onreadystatechange = function(){
                if (req.readyState == 4){
                    if (req.status == 200){
                        s.firstChild.data = Fill_JSON(req);
                        s.className ="h1";
                    }else alert("status = "+
                        req.status +"\n"+req.statusText);
                };
            };

            req.send("null");
        };
    }else alert ("error");
};


function OnClick_JSON_sync(n, s){
    var req = new XMLHttpRequest();
    var patern = new RegExp(/^[1-9]+[0-9]*$/);
    if (patern.test(n.value)){
        if (req){
            req.open("POST", "http://localhost:8080/Lab_21/Sss_JSON_sync", true);
            req.setRequestHeader("XRand-N", n.value);
            req.onreadystatechange = function(){
                if (req.readyState == 4){
                    if (req.status == 200){
                        s.firstChild.data = Fill_JSON(req);
                        s.className ="h1";
                    }else {alert("status = "+
                        req.status +"\n"+req.statusText);
                        alert("JSON Error");}
                };
            };

            req.send("null");
        };
    }else alert ("error in JSON");
};