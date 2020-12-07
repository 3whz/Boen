 $(function () {
     console.log($.ajax())
     $.ajax({
         url: "http://localhost:8081/GymClassSelect",
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
                     menu += `<div class="col-lg-4 col-md-6 mt-5">
                    <div class="card card-bordered">
                        <img class="card-img-top img-fluid" src="gym/images/${item.img}" alt="image">
                        <div class="card-body">
                            <h5 class="title">${item.name}</h5>
                            <p class="card-text">${item.text}
                            </p>
                            <a href="#" class="btn btn-primary" onclick="openDialog()">查看</a>
                        </div>
                    </div>
                </div>			
                    `;
                 })
                 $(".row").html(menu);
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
 $(function () {})

 function openDialog() {
     document.getElementById('light').style.display = 'block';
     document.getElementById('fade').style.display = 'block'
 }

 function closeDialog() {
     document.getElementById('light').style.display = 'none';
     document.getElementById('fade').style.display = 'none'
 }
 //图片上传
 //预览
 function imgPreview(fileDom) {
     //判断是否支持FileReader
     if (window.FileReader) {
         var reader = new FileReader();
     } else {
         alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
     }

     //获取文件
     var file = fileDom.files[0];
     var imageType = /^image\//;
     //是否是图片
     if (!imageType.test(file.type)) {
         alert("请选择图片！");
         return;
     }
     //读取完成
     reader.onload = function (e) {
         //获取图片dom
         var img = document.getElementById("preview");
         //图片路径设置为读取的图片
         img.src = e.target.result;
     };
     reader.readAsDataURL(file);
 }
 function add() {
     //关弹窗
     document.getElementById('light').style.display = 'none';
     document.getElementById('fade').style.display = 'none'
     //add内容
     var formData = new FormData($("#uploadForm")[0]); //用form 表单直接 构造formData 对象; 就不需要下面的append 方法来为表单进行赋值了。 
     var textarea = $('#textarea').val();
     formData.append('text', textarea);
     $.ajax({
         async: false, //要求同步 不是不需看你的需求
         url: "http://localhost:8081/GymClassInsert",
         type: 'POST',
         data: formData,
         processData: false, //必须false才会避开jQuery对 formdata 的默认处理   
         contentType: false, //必须false才会自动加上正确的Content-Type
         success: function (result) {
             if (result == 1) {
                 forward = true;
             } else {

                 $(".myModal-click").trigger("click");
                 forward = false;
             }
             //  自动刷新页面
             window.location.href = 'classlist.html';
         },
         error: function (result) {
             $(".myModal-click").trigger("click");
             forward = false;
             alert("图片太大")
         }
     });

 }

 // file上传按钮设置
 $("#file").change(function () {
     $("#text").html($("#file").val());
 })




 //搜索功能,手指离开键盘时触发
$("#select").keyup(function () {
    // // 显示取消键
    // $("#select_opacity").css("display", "block");
    search()
});
//搜索功能,提交ajax数据到后台
function search() {
    var menu = "";
    var key = $("#select").val()
    var datas = {
        'name': key
    };
    $.ajax({
        url: 'http://localhost:8081/GymClassSelecttest',
        data: datas,
        type: 'POST',
        dataType: 'json',
        success: function (result, status) {
            if (status == "success" && result.length != 0) {
                result.forEach(function (item) {
                    //字符串模板 拼接左侧选项菜单
                    menu += `<div class="col-lg-4 col-md-6 mt-5">
                   <div class="card card-bordered">
                       <img class="card-img-top img-fluid" src="gym/images/${item.img}" alt="image">
                       <div class="card-body">
                           <h5 class="title">${item.name}</h5>
                           <p class="card-text">${item.text}
                           </p>
                           <a href="#" class="btn btn-primary" onclick="openDialog()">查看</a>
                       </div>
                   </div>
               </div>			
                   `;
                })
                $(".row").html(menu);
            } else {
                console.log("暂无数据")
            }
        }
    });
}