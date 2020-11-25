// 문제 추가
var createExam = function() {
	str = "";
	str += '<div class="d5">                                                           ';
	str += '	<div class="d4"></div>                                                 ';
	str += '	<div class="d6">                                                       ';
	str += '		<label for="sel1"> 문제를 입력해주세요. </label> <br> <input       ';
	str += '			type="text" name="que_cont" class="form-control que" /> <br>   ';
	str += '		<label for="sel1"> 보기를 입력해주세요. </label>                   ';
	str += '		<div class="anw">                                                  ';
	str += '			<div class="overlay"></div>                                                  ';
	str += '			<input type="text" name="ans_cont" class="form-control radi"   ';
	str += '				placeholder="보기1"> <input type="checkbox" name="que_answer" ';
	str += '				value="1" class="chk" />                             ';
	str += '		</div>                                                             ';
	str += '		<div class="anw">                                                  ';
	str += '			<div class="overlay"></div>                                                  ';
	str += '			<input type="text" name="ans_cont" class="form-control radi"   ';
	str += '				placeholder="보기2"> <input type="checkbox" name="que_answer" ';
	str += '				value="2" class="chk" />                                               ';
	str += '		</div>                                                             ';
	str += '		<div class="anw">                                                  ';
	str += '			<div class="overlay"></div>                                                  ';
	str += '			<input type="text" name="ans_cont" class="form-control radi"   ';
	str += '				placeholder="보기3"> <input type="checkbox" name="que_answer" ';
	str += '				value="3" class="chk" />                                               ';
	str += '		</div>                                                             ';
	str += '		<div class="anw">                                                  ';
	str += '			<div class="overlay"></div>                                                  ';
	str += '			<input type="text" name="ans_cont" class="form-control radi"   ';
	str += '				placeholder="보기4"> <input type="checkbox" name="que_answer" ';
	str += '				value="4" class="chk" />                                               ';
	str += '		</div>                                                             ';
	str += '		<br> <label for="sel1"> 문제 해설을 입력해주세요. </label>         ';
	str += '		<div class="anw">                                                  ';
	str += '			<textarea class="form-control" rows="5" class="comment"           ';
	str += '				name="que_explain"></textarea>                             ';
	str += '		</div>                                                             ';
	str += '		<div class="btnd">                                                 ';
	str += '			<button type="button" class="btn btn-default plusBtn">문제';
	str += '				추가</button>                                              ';
	str += '		</div>                                                             ';
	str += '	</div>                                                                 ';
	str += '</div>';

	$('#d2').append(str);
};


// 출제한 시험 리스트 조회
var selectAllExam = function(es, ci, p){
	
	$.ajax({
		url : '/exam/selectAllExam',
		method : 'get',
		data : {
			exam_state : es,
			cur_id : ci,
			page : p
		},
		
		success : function(res){
			// 자식 요소로 추가
			$('#examList').html(res.split("fin")[0]); // 출제한 시험 리스트
			$('.pagination').html(res.split("fin")[1]); // 페이징 처리
		},
		error: function(xhr){
			alert("상태"+xhr.status);
		}
	})

};






















