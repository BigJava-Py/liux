$(document).ready(function() {
	reload();
	 //为动态添加的元素绑定事件
	$("tbody").on("mouseover", "tr", function() {
		$(this).addClass('tr_hover'); // 通过jQuery控制实现鼠标悬停上的背景色
	});
	$("tbody").on("mouseout", "tr", function() {
		$(this).removeClass('tr_hover'); // 通过jQuery控制实现鼠标悬停上的背景色
	});
	// tbody中的复选框绑定click事件
	$("tbody").on("click", " tr input:checkbox", function() {
		if (this.checked == true) {
			$(this).parents("tr").addClass('tr_select');
		} else {
			$(this).parents("tr").removeClass('tr_select');
		}
	});
	
	//绑定标题栏的复选框单击事件
    $("#ckAll").click(function() {
        if (this.checked == true) { //判断是否被选择
            $("tbody tr input:checkbox").prop("checked", true);
            $("tbody tr").addClass('tr_select');
        } else {
            $("tbody tr input:checkbox").prop("checked", false);
            $("tbody tr").removeClass('tr_select');
        }
    });
    //增加
    $("#btAdd").click(function() {
    	var rowData = $('tbody tr input:checkbox:checked').parents("tr").attr("data");
    })
})

function reload() {
	$.ajax({
		type : "post",
		url : "queryScore.do",
		data : "",
		dataType : "json",
		success : function(response) {
			var rows = response.rows;
			$("tbody").empty();
			$.each(rows, function(index, row) {
				var s = JSON.stringify(row);

				var str = "<tr data='" + s + "'>";
				str = str + '<td><input type="checkbox" value=' + row.cid + ' /></td>';
				str = str + '<td>' +row.cid+ '</td>';
				str = str + '<td>' + row.courseName + '</td>';
				str = str + '<td>' + row.score + '</td>';
				str = str + '<td>' + row.time + '</td>';
				str = str + '<td>' + row.teacher + '</td>';
				str = str + ' </tr>';

				$("tbody").append(str);
			});
			// 通过jQuery控制表格隔行换色，并鼠标悬停变色
			$('tbody tr:even').addClass('tr_even'); // 默认偶数行背景色
			$('tbody tr:odd').addClass('tr_odd'); // 默认奇数数行背景色
		}
	});
}