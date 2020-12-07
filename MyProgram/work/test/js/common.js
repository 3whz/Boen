;(function(){
	
	function Rem(){
		var html=document.documentElement;
		var htmlW=html.clientWidth;
		var designW=750;
		
		if(htmlW>=designW){
			html.style.fontSize="100px";
		}
		html.style.fontSize=(htmlW/designW)*100+'px';
	}
	Rem()
	window.addEventListener("resize",Rem)
	
})()

