function fn_submit(){
	var fn = document.frm;
	if(fn.stid.value == ""){
		alert("학번이 입력되지 않았습니다.");
		fn.stid.focus();
		return false;
	}
	if(fn.scode.value == ""){
		alert("과목코드가 입력되지 않았습니다.");
		fn.scode.focus();
		return false;
	}
	if(fn.mid.value == ""){
		alert("중간(30%)(0~100)이 선택되지 않았습니다.");
		fn.mid.focus();
		return false;
	}
	if(fn.fin.value == ""){
		alert("기말(30%)(0~100)이 입력되지 않았습니다.");
		fn.fin.focus();
		return false;
	}
	if(fn.att.value == ""){
		alert("출석(20%)(0~100)이 입력되지 않았습니다.");
		fn.att.focus();
		return false;
	}
	if(fn.rep.value == ""){
		alert("레포트(10%)(0~100) 입력되지 않았습니다.");
		fn.voteloc.focus();
		return false;
	}
	if(fn.etc.value == ""){
		alert("기타(10%)(0~100) 입력되지 않았습니다.");
		fn.etc.focus();
		return false;
	}
	
	fn.submit();
}