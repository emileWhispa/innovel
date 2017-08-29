(function(){
	window.onload = function(){
		var allImg = document.querySelectorAll("img");
		for (var i = 0; i < allImg.length; i++) {
			allImg[i].ondragstart = function(){
				return false; 
			}
		};
			var he = $("#navHeader");
			var heip = (he.offsetTop);
		this.onscroll = function(){
			if( document.body.scrollTop >= heip )
				he.className += ' ' + "sticky";
			else
				he.classList.remove("sticky");
		}
		var close = $(".modal-close");
		close.onclick = function(){
			hide(this.parentNode);
		}
		var allLinks = document.querySelectorAll("#innerData a,#subMenu a,.absolute-link a");
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


function changer( elem ){
	if( elem.value === "nature" ){
		show( $("#exempted") );
		$("#PXP_Text").className = "form-input";
	}else{
		hide( $("#exempted") );
		$("#PXP_Text").className = "";
	}
}

function changing( elem ){
	if( elem.value === "other" ){
		show( $("#other_info") );
		$("#JP_Text").className = "form-input";
	}else{
		hide( $("#other_info") );
		$("#JP_Text").className = "";
	}
}

function arrange( list ) {
	var allA = list.querySelectorAll("a");
	Array.prototype.forEach.call(allA,function(elx) {
		new handleDrag( elx , allA , list );
	});
}
function removeZ (argument) {
	for (var i = 0; i < argument.length; i++) {
		argument[i].style.zIndex = 10;
	}
}

var handleDrag = function ( el , All , l ) {
	var elem = el;
	var draggable = false;
	var height = el.offsetHeight;
	var start = null;
	var active = 0; 
	var next = el.nextElementSibling;
	var reset = next;
	var offset = null;
	var intial = 0;
	var self = this;
	elem.onclick = function(){return false;}
	elem.onmousedown = function(e){
		e.preventDefault();
		start = el.offsetTop;
		offset = this.parentNode.getBoundingClientRect();
		draggable = true;
		removeZ( All );
			elem.style.position = "absolute";
			elem.style.zIndex = 500;
	}
	this.dragUp = function(hndl,det){
		draggable = false;
		hndl.style.top = null;
		hndl.style.position = "relative";
		if( det ) return false;
		l.insertBefore( hndl , next );
		next = hndl;
		active = 0;
		var a = l.querySelectorAll("a");
		save(a);
	}
	elem.onmouseup = function(){
		self.dragUp(this,false);
	}
	elem.onmouseleave = function(){
		self.dragUp(this,true);
	}
	elem.onmousemove = function(e){
		if(draggable){
			var y = e.pageY - offset.top;

				elem.style.top = ( y-20 )+ "px";
				
				var elex =	( (el.offsetTop-start)/height);
				var act = parseInt(elex);
				if( next ){
					if( act > active && active <= All.length ){
						if( intial < elex ){
							next = next.nextElementSibling;
							active = act;
						}else{
							//next = next.previousElementSibling;	
						}
						intial = elex;
					}
				}
		}
	}
}


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
			var lib = document.createElement("label");
			lib.textContent = v.username + " " + v.firstName;
			var sp = document.createElement("span");
			sp.id = "photo-wrapper";
			//sp.style.float = "left";
			var mag = source(v.photo);
			sp.appendChild( mag );
			li.onclick = function(e){
            act.sendRequest({page:"contact/developer/"+v.id,m:"GET"},1,2,function(res){
                if( res == 0 ) $("#santa").click();
                else contact( res , v.id );
            });
            return false;
        }
        	li.appendChild( sp );
        	li.appendChild( lib );
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
		var sp = document.createElement("span");
		sp.id = "photo-wrapper";
		sp.style.float = "left";
		var mag = source( v.fromu.photo );
		sp.appendChild( mag );
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
		a.appendChild( sp );
		a.appendChild( lbl );
		li.appendChild( a );
		$(".contentPlace").appendChild( li );
	});
}

function deleter ( button , ture ) {
	var conf = confirm("Are you sure to "+ ((ture) ? ture:"Delete") + " this");
	if( conf ){
		hide(button.parentNode.parentNode);
		act.sendRequest({page:button.value,m:"GET"});
	}
	return conf;
}

function update ( button ) {
	shop( $(".updateBox") );
	act.sendRequest({page:button.value,m:"GET",o:$(".updateData")},1,2,function(r){
		$(".updateData").style.backgroundImage = "none";
	});
}

function shop (argument) {
	show( argument );
	setTimeout(function(){
		argument.querySelector("#innerBox").style.top = "140px";
	},10);
}
function hip ( el ) {
	hide( el );
	el.querySelector("#innerBox").style.top = "0px";
	$(".updateData").innerHTML = "";
}

function read (but) {
	act.sendRequest({page:but.value,m:"GET"},1,2,function(res){
		hide($(".modal-2"));
                if( res == "ok" ) $("#santa").click();
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
							var li = document.createElement("div");
							
							li.textContent = elm.content;
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
				if( elem.status == "approved" )
					a.className = "complete";
				a.textContent = elem.subtask.subName;
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

function save(list) {
	var str = "";
	for (var i = 0; i < list.length; i++) {
		var diff = ( i == list.length - 1 ) ? "" : ":";
		str += list[i].getAttribute("href")+"="+i+diff;
	}
	act.sendRequest({page:"design/interchange/"+str,m:"GET"},1,2,function(res){
		//alert(res);
	});
}