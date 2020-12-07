$(function () {
    console.log($.ajax())
    $.ajax({
        url: "http://localhost:8081/AdminSelect",
        //data: {"username":"aaa","age":22},//携带参数
        //data:"username=aaa&age=23",
        dataType: "json",
        type: "get",
        // cache: true,//true  缓存
        // async: true,// 异步  ， false 同步
        // contentType: "application/x-www/form-urlencoded",//application-json
        success: function (result, status) { //响应成功后回调
            if (status == "success" && result.length != 0) {
                var menu = "";
                result.forEach(function (item) {
                    //字符串模板 拼接左侧选项菜单
                    
                    menu += `<tr>
                    <th data-id="${item.id}">${item.id}</th>
                    <td>${item.account}</td>
                    <td>${item.email}</td>`
                    if(item.state==1){
                        menu += `<td><i class="ti-user"></i></td>`
                    }else {
                        menu += `<td><i class="ti-id-badge"></i></td>`
                    }
                    menu+=`                 
                    <td><i class="ti-marker-alt" onclick="openDialog()"></i>
                    <i class="ti-trash"   onclick="openDialog()"></i></td>	
                    </tr>			
                    `;
                })
                $("tbody").html(menu);
            } else {
                console.log("暂无数据")
            }
        },
        //fail
        error: function () {
            alert("出错了")
        }
    });
});
// 弹窗
$(function () {
})
function openDialog() {
    document.getElementById('light').style.display = 'block';
    document.getElementById('fade').style.display = 'block'
}
function closeDialog() {
    document.getElementById('light').style.display = 'none';
    document.getElementById('fade').style.display = 'none'
}

