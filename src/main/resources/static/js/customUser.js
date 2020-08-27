$.fn.serializeIncludeDisabled = function () {
    let disabled = this.find(":input:disabled").removeAttr("disabled");
    let serialized = this.serialize();
    disabled.attr("disabled", "disabled");
    return serialized;
};

$.fn.serializeObject = function() {
	  "use strict"
	  var result = {}
	  var extend = function(i, element) {
	    var node = result[element.name]
	    if ("undefined" !== typeof node && node !== null) {
	      if ($.isArray(node)) {
	        node.push(element.value)
	      } else {
	        result[element.name] = [node, element.value]
	      }
	    } else {
	      result[element.name] = element.value
	    }
	  }

	  $.each(this.serializeArray(), extend)
	  return result
	}

let refreshBean = function (){
	$.ajax({
		type : 'post', 
		url : '/actuator/refresh',
		data : '', 
		dataType : 'text', 
		error: function(xhr, status, error) {
			console.log("???what?error");
		},
		success : function(json){
			console.log(json);
		}
	});
}

let modalMessage = function (type, message) {
	
	console.log(message);
	
	//type = 1 성공
	if(type == 1) {
		message = message === "" ? "정상적으로 처리 되엇습니다." : typeof message === "undefined" ? "정상적으로 처리 되었습니다." : message;
		$("#succModalMessageTitle").html("success");
		$("#succModalMessage").html(message);
		$('#succModal').modal('toggle');
	} else {
		message = message === "" ? "실패  되엇습니다.관리자에게 문의하세요." : typeof message === "undefined" ? "실패  되엇습니다.관리자에게 문의하세요." : message;
		$("#succModalMessageTitle").html("fail");
		$("#succModalMessage").html(message);
		$('#succModal').modal('toggle');
	}
}