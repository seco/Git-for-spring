$(function() {
	$(document).on("click","#dayReserve",function() {
		// alert($('[name = date]').text() + $('[name=]'));
		var prog_order_val = $('[name="checked"]').children().children().val(); // 선택된
																				// 프로그
		var dateVal = $('[name = date]').text(); // 선택된 날짜
		var day = $('[name^="on"]').text();// on 으로 시작하는 값 -> 날짜값 day
		var careMgr = $('[name="mgr_checked"]').children().children().val(); // 선택된
																				// 시술
		
		date = dateVal +"-"+ day;
		p = $('[name$="on"]').attr('name'); // on으로 끝나는 값 -> 시간값

		
		if(prog_order_val == undefined){
			alert("예약할 프로그램을 선택해주세요.");
			return;
		}
		if(day==""){
			alert("예약 날짜를  선택해주세요.");
			return;
		}
		
		if(p==undefined){
			alert("예약 시간을 선택해주세요.");
			return;
		}
		
		if(careMgr == undefined){
			alert("예약할 시술자를 선택해주세요.");
			return;
		}
		num = p.substr(0, p.length-2);
		
		
		
		
		// form hidden input setting
		$('[name="prog_order_no"]').val(prog_order_val);
		$('[name="time_unit"]').val(num);
		$('[name="reserve_date"]').val(date);
		$('[name="careManager_no"]').val(careMgr);
		
		// submit
		$('#reserve_frm').submit();
		
	});
});

// 취소 버튼
$(function(){
	$(document).on("click","[class^='rsvcancel_']",function(){	 // 변경 버튼 눌렀을
	  
	  if(confirm("정말 삭제하시겠습니까?")!=true) return;
	    
     
	  var className = $(this).attr("class");			
	  className = className.replace("rsvcancel_","");
	  
	  var time_reserve_no = $('[class=tno_'+ className+']').val();
	  var prog_order_no = $('[class=pon_'+className+']').val();
      $('#updateFrm').attr("action", "deleteRsv");
      $('[name="time_reserve_no"]').val(time_reserve_no);
      $('[name="prog_order_no"]').val(prog_order_no);

   	  $('#updateFrm').submit();
      
	})
});


// 변경 버
$(function(){
	$(document).on("click","[class^='rsvchange_']",function(){	 // 변경 버튼 눌렀을
	  if(confirm("정말 변경하시겠습니까?")!=true) return;
	   															// 경우
	  var className = $(this).attr("class");
      className = className.replace("rsvchange_","");
      
      var prog_order_no = $('[class=pon_'+ className+']').val();
      var time_unit = $('[class=tu_'+ className+']').val();
      var careManager_no = $('[class=cn_'+ className+']').val();
      var reserve_date = $('[class=rd_'+ className+']').val();
      var time_reserve_no = $('[class=tno_'+ className+']').val();
     // alert(careManager_no);
     // alert("test: " + reserve_date + " " + careManager_no + " " +
		// time_unit );
	 $('[name="time_reserve_no"]').val(time_reserve_no);
     $('[name="prog_order_no"]').val(prog_order_no);
// $('[name="time_unit"]').val(time_unit); // 시간 선택 후 설정
// $('[name="careManager_no"]').val(careManager_no); // 시술자 선택 후 설정
// $('[name="reserve_date"]').val(reserve_date); // 날짜 선택 후 설정
     
    // alert($('[name="rsv_date_clicked"]'));
     
     $('#updateFrm').submit();
	
	})
});

// 날짜 인풋클릭시 달력 보
$(function(){
	$(document).on("click","#rsv_date",function(){	

		var check = $(this).attr("name");
		var className = $(this).attr("class"); // 1번 행 선택
		className = className.replace("rsvdate_", ""); 
	
		var check_ename =  $('[class=en_'+ className+']').attr("name"); // 1번 행의
																		// ename
																		// input
	  
		// 클릭 전 해제
		$('[name="rsv_date_clicked"]').css("background-color","white");
		$('[name="rsv_date_clicked"]').css("color","black");
		$('[name="rsv_date_clicked"]').attr("name",""); // 선택된 date input
		$('[name="rsv_ename_clicked"]').css("background-color","white");
		$('[name="rsv_ename_clicked"]').css("color","black");
		
		$('[name="rsv_ename_clicked"]').attr("name",""); // 선택된 date input
		
		
		// date switch
		if(check == "rsv_date_clicked"){  // 눌렸을 경우 끄기
			$(this).attr("name", ""); // num으로 설정 숫자(1..19)
			$(this).css("background-color","white");
			$(this).css("color","black");
		    $('[class=en_'+ className+']').attr("name", ""); // this행의 ename
		    $('[class=en_'+ className+']').css("background-color","white"); // this행의 ename																// input
		    $('[class=en_'+ className+']').css("color","black");
		} else { // 눌리지 않은 경우 켜기
			$(this).attr("name", "rsv_date_clicked"); // 숫자 +on (1on .. 19on)
			$(this).css("background-color","black");
			$(this).css("color","white");
			$('[class=en_'+ className+']').css("background-color","black"); // this행의 ename																// input
		    $('[class=en_'+ className+']').css("color","white");
			$('[class=en_'+ className+']').attr("name", "rsv_ename_clicked"); // this행의
																				// ename
																				// input
			funcNow();
		}
	})
});

// ### list.jsp

// 프로그램 선택 시
$(function() {
	$(document).on("click","#prog_row",function() {
		
		var prog_order_no = $(this).children().children().val();
		
		var check = $(this).attr("name");
		
		// 클릭 전 해제
		$('[name="checked"]').css({backgroundColor: 'white'})
		$('[name="checked"]').attr("name","");
	
		if(check == "checked"){  // 눌렸을 경우 끄기
			$(this).css({backgroundColor: 'white'}); // white
// $(this).attr("name", "click_off");
			$(this).attr("name", ""); // num으로 설정 숫자(1..19)
		} else { // 눌리지 않은 경우 켜기
			$(this).css({backgroundColor: 'silver'}); // silver
			$(this).attr("name", "checked"); // 숫자 +on (1on .. 19on)
			funcNow();
		}
	});
});
$(function() {
	$(document).on("click","#getDay",function() {
		var curTime = $(this).text(); // 누른 날짜
		var time = $('[name$="on"]').text();// 이미 눌린 시간 . on 으로 끝나는 시간값 -> 시간
		
		var input_clicked = $('[name="rsv_date_clicked"]');
		var time_avail = $(this).text();
		
		var p = $(this).attr("name"); // on비교 시 필요
		// input_cliked.val("");
		
		// 이미 누른 날짜가 있고, 그 날짜가 내가 누른날짜가 아니면 아무 일도 안함
		// 이미 누른 날짜가 있고, 그 날짜가 내가 누른 날짜면 off
		// 이미 누른 날짜 가 없으면 그 날짜 on
		
		var check = p.substr(p.length-2,2); // name 속성 뒤의두 자리(1 12 12on 1on)
		var num; // time_no만뽑기 위한 변수
		
		if (p.length <= 2){
			num = p; // 숫자만 있는 경우
		}else{
			num = p.substr(0, p.length-2); // 총 길이의 -2 자리 ( 4-2 or 3-2 )
		}
		
		// 클릭 전 해제
		$('[name$="on"]').css({backgroundColor: 'white'})
		$('[name$="on"]').attr("name", time.substr(0,p.length-2));
		
		if(check == "on"){  // 눌렸을 경우 끄기
			$(this).css({backgroundColor: 'white'}); // white
// $(this).attr("name", "click_off");
			$(this).attr("name", num); // num으로 설정 숫자(1..19)
		} else { // 눌리지 않은 경우 켜기
			$(this).css({backgroundColor: 'silver'}); // silver
			$(this).attr("name", num + "on"); // 숫자 +on (1on .. 19on)
			var day = $('[name^="on"]').text(); // on으로시작하는태그( 날짜값)
			var time_no = num;
			
			
			// input clicked value 변경
			var input_clicked_val = input_clicked.val();
			input_clicked_val = input_clicked_val.split(" ");
			input_clicked.val(input_clicked_val[0] +  " "+  time_avail);
			
			// time_no는 보낼 form 내 time_unit에 직접 입력
			$('[name$="time_unit"]').val(time_no);
			$('[name$="reserve_date"]').val(input_clicked_val[0])
			clickFunc_careMgr(day, time_no); // 누른날짜 가용 인력
		}
	});
});

$(function() {
	$(document).on("click","#dayCheck",function() {
	
		var p = $(this).attr("name"); 
		  
		var curDay = $(this).text(); // 누른 날짜
		var day = $('[name^="on"]').text();// 이미 눌린 날짜 . on 으로 시작하는 값 -> 날짜값
											// day
		
		
		// 이미 누른 날짜가 있고, 그 날짜가 내가 누른날짜가 아니면 아무 일도 안함
		// 이미 누른 날짜가 있고, 그 날짜가 내가 누른 날짜면 off
		// 이미 누른 날짜 가 없으면 그 날짜 on
		
		// if(day != "" && curDay != day) return;
		
		// 이미 눌린 버튼들 전부 해제
		$('[name^="on"]').css({backgroundColor: 'white'})
		$('[name^="on"]').attr("name", "off_click");
	
		clickFunc(curDay); // 누른 날짜의 시간 테이블 생성
		
		if(p == "on_click"){
			$(this).css({backgroundColor: 'white'});
			$(this).attr("name", "off_click");
		} else {
			$(this).css({backgroundColor: 'silver'});
			$(this).attr("name", "on_click");
			var day = $('[name^="on"]').text(); // on으로시작하는태그( 날짜값)
			var yearMonth = $("#date").text()
			
			var curDate = $('[name="rsv_date_clicked"]').val();
			curDate = curDate.split(" ");
			var curDay_2 = curDate[0];
			var curTime_2 = curDate[1];
			
			var date = yearMonth + "-"+ curDay +" " + curTime_2; // 년월 + 클릭된
																	// day + 기존
																	// 시
			
			$('[name="rsv_date_clicked"]').val(date); // input 날짜변경
		}
	});
});

// 시술자 선택
$(function() {
	$(document).on("click","#getMgr",function() {
		
		var careMgr = $(this).children().children().val();
		
		var td = $(this).children();
		
		var emp_name = td.text();
		var emp_no = td.attr("name");
		
		var check = $(this).attr("name");
		
		// 클릭 전 해제
		$('[name="mgr_checked"]').css({backgroundColor: 'white'})
		$('[name="mgr_checked"]').attr("name","");
	
		if(check == "mgr_checked"){  // 눌렸을 경우 끄기
			$(this).css({backgroundColor: 'white'}); // white
// $(this).attr("name", "click_off");
			$(this).attr("name", ""); // num으로 설정 숫자(1..19)
		} else { // 눌리지 않은 경우 켜기
			$(this).css({backgroundColor: 'silver'}); // silver
			$(this).attr("name", "mgr_checked"); // 숫자 +on (1on .. 19on)
	
			$('[name="rsv_ename_clicked"]').val(emp_name); // 선택된 행의 ename변경
			$('[name="careManager_no"]').val(emp_no); // 제출 form 내 input에 직접 매
		}
		
	});
});

$(function() {
	$(document).on("click","#dayReserve",function() {
		// alert($('[name = date]').text() + $('[name=]'));
		var prog_order_val = $('[name="checked"]').children().children().val(); // 선택된
																				// 프로그
		var dateVal = $('[name = date]').text(); // 선택된 날짜
		var day = $('[name^="on"]').text();// on 으로 시작하는 값 -> 날짜값 day
		var careMgr = $('[name="mgr_checked"]').children().children().val(); // 선택된
																				// 시술
		
		date = dateVal +"-"+ day;
		p = $('[name$="on"]').attr('name'); // on으로 끝나는 값 -> 시간값

		
		if(prog_order_val == undefined){
			alert("예약할 프로그램을 선택해주세요.");
			return;
		}
		if(day==""){
			alert("예약 날짜를  선택해주세요.");
			return;
		}
		
		if(p==undefined){
			alert("예약 시간을 선택해주세요.");
			return;
		}
		
		if(careMgr == undefined){
			alert("예약할 시술자를 선택해주세요.");
			return;
		}
		num = p.substr(0, p.length-2);
		
		
		
		
		// form hidden input setting
		$('[name="prog_order_no"]').val(prog_order_val);
		$('[name="time_unit"]').val(num);
		$('[name="reserve_date"]').val(date);
		$('[name="careManager_no"]').val(careMgr);
		
		// submit
		$('#reserve_frm').submit();
		
	});
});


var now = new Date();			// Date 생성
var year = now.getFullYear();	// 년
var month = now.getMonth();		// 월
var day = now.getDate();		// 일
var str = "결과";
var xhr;
var time;

/*
 * function start() { xhr = new XMLHttpRequest(); xhr.open("get", "datas/") }
 */
	
function func() {
	// ("ab");
	
	// alert(year + " " + (month + 1) + " " + day);
	
	// 해당월의 1일은 무슨 요일?
	var setDate = new Date(year, month, 1);
	// alert(setDate.getDate());
	var firstDay = setDate.getDate();
	// alert(firstDay);
	var yoil = setDate.getDay();	// 일:0 ~ 토:6
	// alert(yoil);
	var nalsu = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
	if(year % 4 === 0 && year % 100 !== 0 || year % 400 === 0){
		nalsu[1] = 29;
	}
	makeCal(yoil, nalsu[month], year, month+1, day);
	document.getElementById("disp").innerHTML = str;
}

function funcNow() {
	document.getElementById("etc").style.display="";
	func();
}

function Pmonth() {
	month -= 1;
	if(month < 0){
		month = 11;
		year -= 1;
	}
	func();
}

function Nmonth() {
	month += 1;
	if(month > 11){
		month = 0;
		year += 1;
	}
	func();
}

function Pyear() {
	year -= 1;
	func();
}

function Nyear() {
	year += 1;
	func();
}

// 선택날짜에 예약 시간 가져오기
function clickFunc(day) {

	// $("#time_avail").css('display','inline');
	yearMonth = $("#date").text()
	dateVal = yearMonth + '-' + day;
	// reserve = dateVal + $("#")

	// alert(day);
		
// alert(yearMonth);
	
	$.ajax({
	      type : "post",
	      url : "timeList",
	      data : {
	         dateKey : dateVal
	      },
	      success : function(data) {
	    	  
	         var list = data.datas; // json 의 대표명
	         // alert(list);
	         var str = "<table style='margin: auto; padding: 30px;'>";
	         $(list).each(function(index, obj) {
	        	 if(index % 10 == 0){
	        		 str += "<tr>";
	        		
	        	 }
	        	 str += "<td id='getDay' style='border: 1px solid grey;' name=" + obj["time_no"] + ">" + obj["time_avail"] + "</td>";
	        	 timeid = obj["time_unit"];
	        	 /*
					 * if(timeid != null){ // str += "<td style='background-color:red'>" +
					 * obj["time_no"] + "</td>"; str += "<td style='background-color:red' name=" + obj["time_no"] + ">" +
					 * obj["time_avail"] + "</td>"; }else{ // str += "<td>" +
					 * obj["time_no"] + "</td>"; str += "<td id='getDay' name=" + obj["time_no"] + ">" +
					 * obj["time_avail"] + "</td>"; }
					 */

	        	 if((index+1) % 10 == 0){
	        		 str += "</tr>";
	        	 }
	         });
	         str += "</table>";
// <tr><td colspan='10'><button type='button' id='dayReserve'
// style='margin:0;border:none; width:100%; padding:0;
// height:20px;'>예약</button></td></tr>
	         $("#timeList").html(str);
	      },error : function() {
	         alert("err")
	      }
	   });
}

// 선택된 날짜, 시간에 예약 가능한 관리사  가져오기
function clickFunc_careMgr(curDay, time_no) {  // time_no : 1~19
	yearMonth = $("#date").text()
	date_val = yearMonth + '-' + curDay; // 2018-11-11
	
	
	$.ajax({
	      type : "post",
	      url : "careMgrList",
	      data : {
	         dateKey : date_val,
	         timeKey : time_no
	      },
	      success : function(data) {
	         var list = data.datas; // json 의 대표명
	         
	         var str = "<table style='margin: auto;'>";
	         $(list).each(function(index, obj) {
	        	
	        	 timeid = obj["time_unit"];
	        	 
	        	 // alert(timeid);
	        	 
	        	 if(timeid != null){ // 시술자의 일정이 있는 경우
	        		 str += "<tr name=" + obj["emp_no"] +" style='background-color:red'><td>" + obj["emp_name"] + "</td><td><img src=resources/images/" + obj["emp_img"]+ "></td></tr>";
	        	 }else{ // 시술자의 일정이 없는 경우
	        		 // str += "<td>" + obj["time_no"] + "</td>";
	        		 str += "<tr id='getMgr'><td name=" + obj["emp_no"] + "><input type=hidden value="+ obj["emp_no"]+">" + obj["emp_name"] + "</td><td><img src=resources/images/" + obj["emp_img"]+ "></td><tr>";
	        	 }
	        	 
	        	
	        	// $('[name = date]').text()
	        	 // str += "<td id='getDay' name=" + obj["time_no"] + ">" +
					// obj["time_avail"] + "</td></tr>";
	        	 	
	        	 // $("#"+timeid).css('color','red');

	         });
	         str += "</table>";
// <tr><td colspan='10'><button type='button' id='dayReserve'
// style='margin:0;border:none; width:100%; padding:0;
// height:20px;'>수</button></td></tr>
	         $("#mgrList").html(str);
	      },error : function() {
	         alert("err")
	      }
	   });
}

function makeCal(yoil, nalsu, year, month, day) {
	str = "<table style='margin: auto;'>";
	str += "<tr><th id='date' name='date' colspan='7' width='250'>" + year + "-" + month + "</th></tr>";
	str += "<tr>";
	var weeks = new Array("일","월","화","수","목","금","토");
	for(var i = 0; i < weeks.length; i++) {
		str += "<th>" + weeks[i] + "</th>";
	}
	str += "</tr>";
	
	// 날 수 채우기
	var no = 1;
	var currentCell = 0;
	var ju = Math.ceil((nalsu + yoil) / 7);		// Math.ceil: 무조건 큰 값을 취함.
												// Math.flow: 무조건 작은 값 취함
	// alert("이번 달은 몇 주?" + ju);
	for(var r = 0; r < ju; r++){	// 주(행)
		str += "<tr style='text-align:center'>";
		for(var col=0; col < 7; col++){	// 열
			if(currentCell < yoil || no > nalsu){
				str += "<td>&nbsp;</td>";
				currentCell++;
			}else{
				if(no === day){
					// str += "<td style='color:blue'>" + no + "</td>";
					// str += "<a href=\"javascript:func('"datas[i]"')\">"
					// datas[i] + "</a><br>";
// str += "<td id='dayCheck'><a style='color:blue' href='javascript:clickFunc("
// + no + ")'>" + no + "</a></td>";
					str += "<td id='dayCheck'><a style='color:blue; text-decoration:none;'>" + no + "</a></td>";
				}else{
					// str += "<td>" + no + "</td>";
// str += "<td id='dayCheck'><a style='color:black' href='javascript:clickFunc("
// + no + ")'>" + no + "</a></td>";
					str += "<td id='dayCheck'><a style='color:black' text-decoration:none'>" + no + "</a></td>";
				}
				no++;
			}
		}
		str += "</tr>";
	}
	str += "</table>";
}


