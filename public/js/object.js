var obj = {
    id:null,
	loader:function(e){
		var elem = document.createElement("div");
		elem.className = "showbox";
		var load = document.createElement("div");
		load.className = "loader";
		var svg = document.createElement("svg");
		svg.className = "circular";
		svg.setAttribute("viewBox","25 25 50 50");
		var circle = document.createElement("circle");
		circle.className = "path";
		circle.setAttribute("cx",50);
		circle.setAttribute("cy",50);
		circle.setAttribute("r",20);
		circle.setAttribute("fill","none");
		circle.setAttribute("stroke-width",2);
		circle.setAttribute("stroke-miterlimit",10);

		//apppennding
		svg.appendChild( circle );
		load.appendChild( svg );
		elem.appendChild( load );
		return elem;
	},
	loaded:null,
	showB:function(){
		hide( $(".showbox") );
	},
	dataB:function(){
		return document.querySelector("#main-data #deposit");
	},
    dir: function( elem, dis , dir , until ) {
        var matched = [],
            cur = elem[ dir ];
            var a = dis.split("#").pop();
            var inc = 0;
        while ( cur && cur.nodeType !== 9 && (until === undefined || cur.nodeType !== 1 || !jQuery( cur ).is( until )) ) {
            if ( cur.id === a ) {
                //matched.push( cur );
                matched = cur;
                inc++;
            }
            cur = cur[dir];
        }
            if( !inc ) return 0;
        return matched;
    },
	mainData:function( href ){
		var psy = $(".showbox");
		show( psy );
		act.sendRequest({page:href,o:this.dataB(),m:"GET"},1,2,function(res){
			document.querySelector("#main-data").style.backgroundImage = "none";
		});
	},
    prepareChat:function( bdy ){
        var ele = document.createElement("div");
        ele.id = "chatArea";
        var usersBox = document.createElement("div");
        usersBox.id = "dope";
        ele.appendChild( usersBox );
        var messageBox = document.createElement("div");
        messageBox.id = "mBox";
        ele.appendChild( messageBox );
        var options = document.createElement("div");
        options.id = "optionsDiv";
        ele.appendChild( options );
        bdy.appendChild( ele );
        var object = {u:usersBox,msg:messageBox,opt:options}
        this.addOptions( options );
        return object;
    },
    addOptions:function( optDiv ){
        var div = document.createElement("div");
        
        var h = document.createElement("h4");
        h.textContent = "Customize options on chat room";

        var ul = document.createElement("ul");
        var li1 = document.createElement("li");
        li1.textContent = "Change your chat colors";

        var li2 = document.createElement("li");
        li2.textContent = "All about Forums";

        var li3 = document.createElement("li");
        li3.textContent = "Delete Conversations";

        var dataring = document.createElement("div");
        dataring.id = "setData";
        div.appendChild( h );
        ul.appendChild( li1 );
        ul.appendChild( li2 );
        ul.appendChild( li3 );
        div.appendChild( ul );
        div.appendChild( dataring );
        optDiv.appendChild( div );
    },
    prepareUser:function( el , data , userData , def ){
        act.Clremove( data.u.querySelectorAll("*") , "acter");
        el.className = "acter";
        if( def === 1 ){
            var check = data.msg.querySelector("#forum"+userData.id);
        }else{
            var check = data.msg.querySelector("#user"+userData.id);
        }
        hide( data.msg.querySelectorAll(".mainB") );
        if( check ){
            show( check );
            check.querySelector("textarea").focus();
        }else{
            var chatBox = document.createElement("div");
            var deep = ( def === 1 ) ? "forum" : "user"; 
            chatBox.id = deep+userData.id;
            chatBox.className = "mainB";
            var dataDiv = document.createElement("div");
            dataDiv.id = "mainX";
            var frm = document.createElement("div");
            frm.id = "chatForm";
            var form = document.createElement("form");
            form.method = "POST";
            form.enctype = "multipart/form-data";
            ( def === 1 ) ? form.action = "/forum/send/" : form.action = "/send/message/";
            var text = document.createElement("textarea");
            text.name = "text";
            text.onkeyup = function(e){
                if( e.keyCode == 13 && this.value.length > 1 ){ 
                    obj.send(this.parentNode,dataDiv) 
                }else if( e.keyCode == 13 ){
                    this.value = "";
                }
            }
            var hideen = document.createElement("input");
            hideen.type = "hidden";
            if( def === 1 ){
                hideen.name = "forum";
                hideen.value = userData.forum.id;
            }else{
                hideen.name = "sendto";
                hideen.value = userData.id;
            }
            form.appendChild( hideen );

            if( def === 1 ){
                act.sendRequest({page:"forum/view/"+userData.forum.id,m:"GET"},1,2,function(res){
                    obj.receive2( dataDiv , res , userData.id );
                });
            }else{
                act.sendRequest({page:"view/messages/"+userData.id,m:"GET"},1,2,function(res){
                    obj.receive( dataDiv , res , userData.id );
                });
            }

            var send = document.createElement("button");
            send.innerHTML = "send";
            send.className = "button";
            send.type = "submit";
            form.onsubmit = function(){obj.send(this,dataDiv); return false;}
            
            if( def === 1)
                text.placeholder = "Type text in "+userData.forum.forumName + " forum";
            else
                text.placeholder = "Type msg to "+userData.username;
            
            form.appendChild( text );
            form.appendChild( send );
            frm.appendChild( form );
            chatBox.appendChild( dataDiv );
            chatBox.appendChild( frm );
        data.msg.appendChild( chatBox );
        text.focus();
        }
    },
    receive:function( bdy , result , ider ){
        var ob = JSON.parse( result );
        Array.prototype.forEach.call( ob , function( elem ){
            var div = document.createElement("div");
            var elx = document.createElement("div");
            if( elem.fromu.id == ider ){
                div.align = "left";
                elx.className = "tLabel";
            }else{
                div.align = "right";
                elx.className = "mLabel";
            }
            div.id = "holder";
            elx.textContent = elem.message;
            div.appendChild( elx );
            bdy.appendChild( div );
            bdy.scrollTop = bdy.scrollHeight;
        });
    },
    receive2:function( bdy , result , ider ){
        var ob = JSON.parse( result );
        Array.prototype.forEach.call( ob , function( elem ){
            var div = document.createElement("div");
            var elx = document.createElement("div");
            var hx = document.createElement("label");
            var elxp = document.createElement("div");
            if( elem.member.id != obj.id ){
                div.align = "left";
                elx.className = "tLabel";
            }else{
                div.align = "right";
                elx.className = "mLabel";
            }
            div.id = "holder";
            elxp.textContent = elem.content;
            hx.textContent = elem.member.username + " " + elem.member.firstName;
            elx.appendChild( hx );
            elx.appendChild( elxp );
            div.appendChild( elx );
            bdy.appendChild( div );
            bdy.scrollTop = bdy.scrollHeight;
        });
    },
    send:function( frm , data ){
        var text = frm.querySelector("textarea");
        var valid = true;
        valid = valid && act.checkLength( text , 1 , 100000000 , "");
        if( valid ){
            sendFile(frm.action,frm,"",function(res){
                var elx = document.createElement("div");
                elx.align = "right";
                elx.id = "holder";
                var dix = document.createElement("div");
                dix.className = "mLabel";
                dix.textContent = text.value;
                elx.appendChild( dix );
                data.appendChild( elx );
                data.scrollTop = data.scrollHeight;
            });
        }
    }
}


function change(elem){
    var image = elem.value;
        if( image && act.checkImage( image ) ){
            var sp = elem.parentNode.querySelector("span");
            sp.innerHTML = "";
            var img = document.createElement("img");
            sp.appendChild( img );
            readURL( elem , img );
        }
        
}

function mark ( button ) {
    act.sendRequest({page:button.value,m:"GET",o:button});
}
function source( pic ){
    var img = document.createElement("img");
    ( pic == "" ) ? url = "assets/images/boys.jpg" : url = "assets/upload/"+pic;
    img.src = url;
    img.ondragstart = function(){return false}
    return img;
}

function contact ( res , id ) {
    obj.dataB().innerHTML = "";
    var elem = JSON.parse( res );
    var data = obj.prepareChat( obj.dataB() );
    Array.prototype.forEach.call(elem,function(v){
        var li = document.createElement("li");
        var aL = document.createElement("a");
        var xL = document.createElement("label");
        xL.textContent = v.username + " "+v.firstName;
        var span = document.createElement("span");
        span.id = "photo-wrapper";
        var profile = source(v.photo);
        aL.onclick = function(){ obj.prepareUser( this , data , v );return false};
        ( id == v.id ) ? aL.click() : 1;
        aL.href = id;
        span.appendChild( profile );
        aL.appendChild( span );
        aL.appendChild( xL );
        li.appendChild( aL );
        data.u.appendChild( li );
    });
    var differ = document.createElement("div");
    differ.style.color = "#ec871e";
    differ.textContent = "Group Conversations";
    differ.id = "differ";
    data.u.appendChild( differ );
    act.sendRequest({page:"view/forums",m:"GET"},1,2,function(six){
        obc = JSON.parse(six);
        Array.prototype.forEach.call(obc,function(v){
            var li = document.createElement("li");
            var aL = document.createElement("a");
            var xL = document.createElement("label");
            xL.textContent = v.forum.forumName;
            var span = document.createElement("span");
            span.id = "photo-wrapper";
            var profile = source("");
            aL.onclick = function(){ obj.prepareUser( this , data , v , 1 );return false};
            //( id == v.id ) ? aL.click() : 1;
            aL.href = id;
            span.appendChild( profile );
            aL.appendChild( span );
            aL.appendChild( xL );
            li.appendChild( aL );
            data.u.appendChild( li );
    });
    });
}

function submiter ( form , dynamic ) {
    form.onsubmit = function(e){
    e.preventDefault();
    var valid = true;
    var allInput = form.querySelectorAll(".form-input,.super-input,.checking");
    Array.prototype.forEach.call( allInput , function(el){
        valid = valid && act.checkLength( el , 1 , 2000 , "");
    });
    if(valid) {
        show( $(".showbox") );
        sendFile(this.action,this,"",function(result){
            hide( $(".showbox") );
           // if( result === "ok" )
                //window.location.reload();
            if( typeof dynamic === "function" ) dynamic( result , allInput );
        });
    }
}
}

function submit2 ( form , dynamic ) {
    var ao = form.querySelectorAll(".checkbox");
    for (var i = 0; i < ao.length; i++) {
        ao[i].onchange = function(){
            var eli = this.parentNode.querySelector("select");
            if( this.checked ){
               eli.disabled = null;
            }else{
                eli.disabled = "1";
            }
        }
    };
    form.onsubmit = function(e){
    //e.preventDefault();
    var valid = true;
    var allInput = form.querySelectorAll(".checking");
    var vax = false;
    Array.prototype.forEach.call( allInput , function(el){
        if( el.type == "checkbox" && el.checked ){
        valid = valid && act.checkLength( el.parentNode.querySelector("select") , 1 , 2000 , "");
        vax = true;
        }
    });
    if(valid) {
        if( !vax ){
            alert("choose at least one subtask");
            return;
        }
        show( $(".showbox") );
        sendFile(this.action,this,"",function(result){
            hide( $(".showbox") );
           // if( result === "ok" )
                //window.location.reload();
            if( typeof dynamic === "function" ) dynamic( result , allInput );
        });
    }
    return valid;
}
}

function blurer ( allInput ) {
    
for (var i = 0; i < allInput.length; i++) {
    allInput[i].autocomplete = "off";
    allInput[i].onblur = function (e) {
        var par = this.parentNode;
        var label = par.querySelector(".animated-label");
        if(this.value.length>0) label.className += ' ' + "not-empty";
        else label.classList.remove("not-empty");
    }
}
}
function readURL(input, imager ) {

    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            imager.src = e.target.result;
        }

        reader.readAsDataURL(input.files[0]);
    }
}
/**
 * Created by Dhevil on 7/29/2017.
 */
$ = function( q ){
    return document.querySelector(q);
}
function hide( elem ){
    if( elem.length === undefined )
        elem.style.display = "none";
    else{
        for (var i = 0; i < elem.length; i++) {
            elem[i].style.display = "none";
        };
    }
    return true;
}
function show( elem ){
    if( elem.length === undefined )
        elem.style.display = "block";
    else{
        for (var i = 0; i < elem.length; i++) {
            elem[i].style.display = "block";
        };
    }
    return true;
}
function sendFile( page , form , output , messenger , append ) {

    if( typeof output == 'object' ) output.textContent = "";//clear previous server response

    var url = page;
    var formData = new FormData(form);
    xhr = new XMLHttpRequest();

    xhr.open("POST", url, true);

    //xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); //no longer necessary here

    xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
    xhr.onerror = function(res){
        alert(res);
    }
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4 && xhr.status == 200)
        {
            if( typeof output == 'object' )  {
                output.innerHTML = xhr.responseText;
                var myScripts = output.getElementsByTagName("script");
                if ( myScripts.length > 0 ) {
                    eval(myScripts[0].innerHTML);
                }
            }
            if ( messenger != undefined ) messenger(xhr.responseText);

            form.reset();
        }
    }

    xhr.send(formData); //Send to server
    //hUploadSpeed = setInterval(UploadSpeed, 1000); //per seconds

}
function jsfadeIn(el) {
    el.style.display = 'block';
    el.style.opacity = 0;

    var last = +new Date();
    var tick = function() {
        el.style.opacity = +el.style.opacity + (new Date() - last) / 600;
        last = +new Date();

        if (+el.style.opacity < 1) {
            (window.requestAnimationFrame && requestAnimationFrame(tick)) || setTimeout(tick, 16);
        }
    };

    tick();
}
 rude = function(el){
     var elem = el.parentNode.querySelector(".direc");
     jsfadeIn( elem );
 }
var act = {
    no:function(){
        var div = document.createElement("div");
        div.align = "center";
        div.textContent = "no sub tasks found";
        return div;
    },
    updateTips:function( obj , title ){
        var p = obj.parentNode.querySelector("#max");
        if( !title ){
            hide(p);
            return false;
        }
        show( p );
        p.textContent = title;
        setTimeout(function(){p.style.width = "300px"},200);

    },
    mover:function( el , indx , nex ){
        //for (var i = 0; i < nex.length; i++) {
            hide( nex );
            show( nex[indx+1] );
        //};
        return true;
    },
    data2:function( elm ){
        var par = document.createElement("div");
        par.id = "parser";
        var aL = document.createElement("a");
        aL.id = "ha";
        aL.href = "/view/indetails/"+elm.id;
        aL.textContent = elm.projectName;
        var div = document.createElement("div");
        var img = document.createElement("img");
        img.src = "/assets/upload/"+elm.projectLogo;
        var ls = document.createElement("a");
        ls.textContent = elm.projectDetails;
        ls.id = "labeler";
        ls.href = elm.projectLink;
        ls.target = "_blank";
        var sp = document.createElement("button");
        sp.value = "view/myPro/14/var?var="+elm.id;
        sp.id = "miner";
        sp.className = "button";
        sp.textContent = "Read More";
        sp.onclick = function(e){
            act.sendRequest({page:this.value,m:"GET",o:$(".modal-inner")},1,2,function(res){
                if( res == "ok" ) $("#santa").click();
                else{
                    show( $(".modal-2") );
                    $(".modal-inner").style.backgroundImage = "none";
                }
            });
            return false;}

        aL.onclick = function(){ sp.click();return false; }
        div.appendChild( img );
        par.appendChild( aL );
        par.appendChild( div );
        par.appendChild( ls );
        par.appendChild( sp );
        return par;
    },
    data3:function( elm ){
        var par = document.createElement("div");
        par.id = "parserB";
        var inner = document.createElement("div");
        inner.id = "sticker";
        var aL = document.createElement("a");
        aL.id = "ha";
        //aL.href = "/view/indetails/"+elm.id;
        //aL.onclick = function(){ return true;act.data(this) }
        var ot = document.createElement("div");
        ot.id = "other";
        aL.textContent = elm.project.projectName;
        var label = document.createElement("label");
        label.textContent = elm.name + " : "+elm.content;
        var dap = document.createElement("div");
        dap.id = "fang";
        var img = document.createElement("img");
        img.src = "/assets/upload/"+elm.project.depart.departmentLogo;
        dap.appendChild( img );
        inner.appendChild( aL );
        inner.appendChild( dap );
        par.appendChild( inner );
        ot.appendChild( label );
        par.appendChild( ot );
        return par;
    },
    addOther:function( elm , elem ){
        var label = document.createElement("label");
        label.textContent = elm.name + " : "+elm.content;
        elem.querySelector("#other").appendChild( label );
    },
    fetch:function( el , indx ){
        var next = document.querySelectorAll(".boxer");
        act.sendRequest({page:el.href,m:"GET"},1,2,function(result){
            var js = JSON.parse( result );
            var indice = null;
            Array.prototype.forEach.call(js,function( elm , k ){
                if((indx+1) === 1)
                    var par = act.data2( elm );
                else if((indx+1) === 2 && !k ){
                    var par = act.data3( elm );
                    indice = par;
                }else if((indx+1) === 2 ){
                    act.addOther( elm , indice );
                    return false;
                }

                else
                    return false;

                next[indx+1].appendChild( par );

            });
            if( js.length <= 0 ) next[indx+1].appendChild( act.error("project"));
            act.mover( el , indx , next );
        });
    },
    error:function( elpi ){
        var div = document.createElement("div");
        div.className = "notFound";
        var lap = document.createElement("label");
        lap.textContent = "!";
        var p = document.createElement("p");
        p.textContent = "nothing found wait for adding";

        div.appendChild( lap );
        div.appendChild( p );
        return div;
    },
    data:function( elem ){
        var intM = this.getIndexOfNode(elem.parentNode.parentNode);
        show( $(".showbox") );
            this.fetch( elem , intM );
        //return false to stop default reactions
        return false;
    },
    checkImage:function( image ){
        fileName = image.toLowerCase();
        var a = fileName.split('.').pop();
        if( a == 'gif' || a == 'jpg' || a == 'jpeg' || a == 'bmp' || a == 'png' || a == 'ico' ){
        return true;
          }else{
        return false;
        }
    },
    linker:function(el,links,glb,cst){
        var allData = document.querySelectorAll(".pana");
        hide(allData);
        allData[glb].style.display = "inline-block";
        act.Clremove(links,"active");
        links[glb].className = "active";
        if(cst)
            return cst;
        if( el.id == "bNext" && glb > 0 ) glb--;
        else if( el.id == "bBack" && glb < links.length-1 ) glb++;
        return glb;
    },
    getIndexOfNode: function(node){
        var parent = node.parentNode;
        return index = Array.prototype.indexOf.call(parent.children, node );
    },
    Clremove:function( el , className ){
        for( var i= 0 ; i < el.length ; i++ ){
            if (el[i].classList)
                el[i].classList.remove(className);
            else
                el[i].className = el[i].className.replace(new RegExp('(^|\\b)' + className.split(' ').join('|') + '(\\b|S)', 'gi'), ' ');
        }
    },
    style:function( elem , prop ){
        return document.defaultView.getComputedStyle(elem,null).getPropertyValue( prop );
    },
    checkLength:function( o , min , max , title ){
        if ( (o.value.length < min || o.value.length > max) || (o.type == "checkbox" && !o.checked ) ) {
            //document.querySelector(pos).innerHTML = title;
            o.focus();
           // this.updateTips( o , title );
            return false;
        }else{
           // this.updateTips(o,false);
            return true;
        }
    },
    sendRequest:function( req , first , second , fn , error , superFunc ){
		var request = new XMLHttpRequest();
		var params = "first="+encodeURIComponent(first)+"&second="+encodeURIComponent(second);
		if( req.m == "GET" ) diez = "GET";
		else diez = "POST";
        request.open(diez, req.page , true);
        request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
        request.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
       request.onload = function(errors) {
       	hide( $(".showbox") );
       if (request.status >= 200 && request.status < 400) {
          // Success!
         var resp = request.responseText;
        if( typeof req.o === 'object'){
        	if( req.type == 'prepend' )
        		req.o.insertAdjacentHTML('afterBegin', resp );
        	else if( req.type == 'append' )
        		req.o.insertAdjacentHTML('afterEnd', resp );
        	else
         req.o.innerHTML = resp;

         var myScripts = req.o.getElementsByTagName("script");
        if (myScripts.length > 0) {
        	for (var i = 0; i < myScripts.length; i++) {
        		eval( myScripts[i].innerHTML );
        	};
         }
       }
      ( fn === undefined ) ? 1 : fn( request.responseText );  
        } else {
         // We reached our target server, but it returned an error
                	if( typeof superFunc == "function" ) superFunc(errors);  
      }
       };

       request.onerror = function(errors) {
       	errors.preventDefault();
       	if( error && fn != undefined ) fn();
       	if( typeof superFunc == "function" ) superFunc(errors);
    };
    data = params;
     request.send( data );
	},
    sendFile:function( form ){
        //fdfd
        return true;
    },
}
