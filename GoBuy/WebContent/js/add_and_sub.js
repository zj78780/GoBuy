function addNum(){
			var string=document.getElementById("num").value
			var n=parseInt(string)+1;
			document.getElementById("num").value=n;
			}

			function subNum(){
			var string=document.getElementById("num").value
			if(parseInt(string)>=1){
				var n=parseInt(string)-1;
				document.getElementById("num").value=n;
				}
				else{
				alert("不可少于0!");
				}
			}