(function(){
	window.onload = function(){
			var he = $("#navHeader");
			var heip = (he.offsetTop);
		this.onscroll = function(){
			if( document.body.scrollTop >= heip )
				he.className += ' ' + "sticky";
			else
				he.classList.remove("sticky");
		}
		var allLinks = document.querySelectorAll("#innerData a,#subMenu a");
		for (var i = 0; i < allLinks.length; i++) {
			allLinks[i].onclick = function(e){
				if( this.getAttribute("onsignout") )
					return confirm("Are you sure to Logout?");
				

				act.Clremove(allLinks,"active");
				this.className += ' ' + "active";

				var href = this.getAttribute("href");

				if( href != "" && href != "#" && href != "?" ) obj.mainData( href );
		
					return false;
			}

			if( allLinks[i].className === "active" ) allLinks[i].click();
		};
		var compose = $("#compose_button");
		if( compose ){
		compose.onclick = function(){
			activate( this , true );
			var data = this.querySelector("#compose_data");
			if( data ){
				if( act.style(data,"display") != "none" )
					hide( data )
				else
					show( data );
			}else{
				var elem = document.createElement("div");
				elem.id = "compose_data";
				var search = document.createElement("input");
				search.type = "text";
				search.onclick = function(e){e.stopPropagation()}
				search.placeholder = "Search user to contact";
				var depo = document.createElement("div");
				depo.id = "depo";

				elem.appendChild( search );
				elem.appendChild( depo );	
				this.appendChild( elem );
				search.onkeyup = function(){ if(this.value) myData( depo , this.value );}
				myData( depo , false );
			}
		}

		fetcher();
	}
	}
})();


function runPro ( img ) {
	var pr = img.parentNode;
	var inp = pr.querySelector("input");
	inp.click();
	if( !inp.onchange )
		inp.onchange = function(e){
			if( this && act.checkImage( this.value ) ){
	            readURL( this , img );
	            sendFile(this.parentNode.action,this.parentNode,"",function(rip){
	            	//alert(rip);
	            });
	        }	
		}
}

function forum ( liElem ) {
	activate( liElem , true );
	var dx = liElem.querySelector("#my-data");
	if( dx ){
		if( act.style(dx,"display") != "none" )
			hide( dx );
		else
			show( dx );
		dx.querySelector("input").focus();
	}else{
		var elp = document.createElement("div");
		elp.id = "my-data";
		var form = document.createElement("form");
		form.action = "/action/forumCreate/";
		form.method = "POST";
		var input = document.createElement("input");
		input.type = "text";
		input.name = "name";
		input.onclick = function(e){e.stopPropagation()}
		input.placeholder = "Create Forum";
		var but = document.createElement("button");
		var doc = document.createElement("div");
		//doc.id = "depo";
		but.type = "submit";
		but.innerHTML = "X";
		form.appendChild( input );
		form.appendChild( but );
		elp.appendChild( form ); 
		elp.appendChild( doc );

		liElem.appendChild( elp );

			input.focus();
		form.onsubmit = function(){
			var valid = true;
			valid = valid && act.checkLength( input , 1 , 200 , "d");
			if( valid ){
				sendFile( this.action , this , "" , function(result){
					var forumId = (result);
					act.sendRequest({page:"/contact/developer/1",m:"GET"},1,2,function(res){
						var elx = JSON.parse( res );
						Array.prototype.forEach.call(elx,function(v,k){
							var li = document.createElement("span");
							li.textContent = v.username + " " + v.firstName;
							var btx = document.createElement("button");
							btx.innerHTML = "Add member";
							btx.value = "add/member/"+v.id+"/forum?forum="+forumId;
							btx.onclick = function(){
								this.disabled = true;
								var bto = this;
								act.sendRequest({page:this.value,m:"GET"},1,2,function(rep){
									bto.innerHTML = "Added";
								});
							}
							li.appendChild( btx ); 
							doc.appendChild( li );
						})
					});
				});
			};
			return false;
		}
	}
}

function myData ( pos , value ) {
	act.sendRequest({page:"/view/usersList/"+value,m:"GET"},1,2,function(res){
		pos.innerHTML = "";
		var obc = JSON.parse( res );
		Array.prototype.forEach.call(obc,function(v,k){
			var li = document.createElement("li");
			li.textContent = v.username + " " + v.firstName;
			li.onclick = function(e){
            act.sendRequest({page:"contact/developer/"+v.id,m:"GET"},1,2,function(res){
                if( res == 0 ) $("#santa").click();
                else contact( res , v.id );
            });
            return false;
        }
			pos.appendChild( li );
		});			
	});
}

var inc = 0;
function changeColors ( elem ) {
	var colors = new Array("blue","red","green","orange","purple");
	$(".boxhead").style.backgroundColor = colors[inc];
	inc++;
	if( inc == colors.length ) inc = 0;
}

function draw ( elem ) {
	var sel = elem.querySelector(".rece");
	if( sel ){
		show( sel );
	}else{
		var e = document.createElement("div");
		e.className = "rece";
		act.sendRequest({page:elem.href,m:"GET"},1,2,function(res){
			e.innerHTML = res;
		});
		elem.appendChild( e );
		if( !elem.onmouseleave )
			elem.onmouseleave = function(){
				hide( e );
			}
	}
}

function fetcher () {
	
		setTimeout(function(){
			act.sendRequest({page:"view/unread/",m:"GET"},1,2,function(res){
				$(".contentPlace").innerHTML = "";
				var d = JSON.parse( res );
				if( d.length > 0 ){
					activate( d , true );
					receive( d );
					$("#number").style.display = "inline-block";
					$("#number").innerHTML = d.length;
				}else{
					hide( $("#number") );
				}
				fetcher();
			});
		},4000);
}


function receive ( data ) {
	Array.prototype.forEach.call(data,function(v,k){
		var li = document.createElement("li");
		var a = document.createElement("a");
		a.href = "contact/developer/"+v.fromu.id;
		var lbl = document.createElement("label");
		lbl.textContent = v.message;
		a.onclick = function(e){
            act.sendRequest({page:this.href,m:"GET"},1,2,function(res){
                if( res == 0 ) $("#santa").click();
                else contact( res , v.fromu.id );
            });
            return false;
        }
		a.textContent = (k+1)+ "." + v.fromu.username + " " + v.fromu.firstName ;
		a.appendChild( lbl );
		li.appendChild( a );
		$(".contentPlace").appendChild( li );
	});
}

function deleter ( button ) {
	var conf = confirm("Are you sure to Delete this");
	if( conf ){
		hide(button.parentNode.parentNode);
		act.sendRequest({page:button.value,m:"GET"});
	}
	return conf;
}

function update ( button ) {
	show( $(".updateBox") );
	act.sendRequest({page:button.value,m:"GET"},1,2,function(res){
		$(".updateData").innerHTML = res;
	});
}

function read (but) {
	act.sendRequest({page:but.value,m:"GET"},1,2,function(res){
                if( res == 0 ) $("#santa").click();
                else contact( res , but.id );
            });
}

function getData ( elem ) {
	act.sendRequest({page:elem.href,m:"GET"},1,2,function(res){
		var dataPos = $("#myData");
		dataPos.innerHTML = "";
		elx = JSON.parse( res );
		Array.prototype.forEach.call(elx,function(el,k){
			var li = document.createElement("li");
			li.textContent = el.subName+"["+el.subDetail+"]";
			if( el.complete == "0" ){
			var button = document.createElement("button");
			button.innerHTML = "";
			button.value = el.id;
			button.title = "Mark Complete";
			button.onclick = function(e){
				act.sendRequest({page:"update/complete/"+this.value,m:"GET"},1,2,function(res){
					alert(res);
				});
			}
			li.appendChild( button );
			}
			dataPos.appendChild( li );
		});
	});
	return false;
}


function design (page ,elems) {
						act.sendRequest({page:page,m:"GET"},1,2,function(res){
						var obc = JSON.parse(res);
						var pos = elems;
						pos.style.backgroundImage = "none";
						Array.prototype.forEach.call(obc,function(elm){
							var li = document.createElement("li");
							var a = document.createElement("a");
							a.href = "#";
							a.textContent = elm.name +" : "+elm.content;
							li.appendChild( a );
							pos.appendChild( li );
						});
					});
}



function subTasks ( link ) {
	var elm = link.querySelector(".absolute");
	if( !elm ){
		var data = document.createElement("div");
		data.className = "absolute taskDet";
		data.onmouseleave = function(){hide(this)}
		link.onmouseleave = function(){hide(data)}
		data.innerHTML = "Loading subTasks ....";
		link.appendChild( data );
		act.sendRequest({page:link.href,m:"GET"},1,2,function(res){
			data.innerHTML = "";
			var obc = JSON.parse(res);
			Array.prototype.forEach.call(obc,function(elem){
				var li = document.createElement("li");
				var a = document.createElement("a");
				if( elem.complete == "1" )
					a.className = "complete";
				a.textContent = elem.subName;
				li.appendChild( a );
				data.appendChild( li );
			});
			if( !obc.length ) data.appendChild( act.no() );
		});
	}else{
		show( elm );
	}
}


function percent ( sum , len ) {
	return parseInt((sum*100)/(len*100))+"%";
}
function activate( aL , t ) {
	var parent = $("#chatter");
	var body = parent.querySelector(".contentPlace");
	if( t )
		body.style.height = 380+"px";
	else
		body.style.height = "0px";
}