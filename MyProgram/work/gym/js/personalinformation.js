$(function () {
    var usera = $.cookie('user');
    //反序列化对象数组
    var user = JSON.parse(usera);
    var a = ""
    var sex = "男"
    if (user != "") {
        a += `<div class="head_img">
                    <span>修改头像</span>
                    <div class="img__wrapper">
                        <img src="images/${user[0].img}"  alt="">                            
                    </div>
                    <svg class="icon"  aria-hidden="true">
                        <use xlink:href="#icon-arrow-right"></use>
                    </svg>       
                </div>
                <li><p>昵称</p>
                   <input type="text"  name="username" id="username" value="${user[0].username}">
                    <svg class="icon"  aria-hidden="true">
                        <use xlink:href="#icon-arrow-right"></use>
                    </svg></li>
                <li><p>邮箱</p>
                    <input type="text" name="email" id="email" value="${user[0].email}">
                    <svg class="icon"  aria-hidden="true">
                        <use xlink:href="#icon-arrow-right"></use>
                    </svg> </li>
                <li><p>性别</p>
                   `
        if (user[0].sex == 0) {
            sex = "女"
        }
        a += `
                        <button class="btn btn-primary btn-lg sex" data-toggle="modal" data-target="#myModal">${sex}</button>
                    <svg class="icon"  aria-hidden="true">
                        <use xlink:href="#icon-arrow-right"></use>
                    </svg> </li>
                <li style="display: none;">
                    <label >${user[0].coach}</label>     
                    <label id="id" >${user[0].id}</label> </li>
                    
                <li> 
                    <div class="outlogin" onclick="UserUpdate()">保存</div></li>
                   <div class="outlogin" onclick="personalcenter()">退出登录</div></li>
                    `
        $(".body_ul").html(a);
    } else {
        alert("没有");
    }
});

function personalcenter() {
    $.removeCookie('user', {
        path: '/'
    });
    top.location.href = "personalcenter.html"
}


//修改
function UserUpdate() {
    var usera = $.cookie('user');
    //反序列化对象数组
    var user = JSON.parse(usera);
    var id = $('#id').text()
    var a = $(".sex").text()
    var sex = 1
    if (a == "女") {
        sex = 0
    }
    var email = $('#email').val();
    var username = $('#username').val();
    user[0].sex = sex
    user[0].email = email
    user[0].username = username
    user = JSON.stringify(user)
    $.cookie('user', user, {
        expires: 7,
        path: '/'
    });
    $.ajax({
        url: "http://localhost:8081/UserUpdate",
        data: {
            "username": username,
            "sex": sex,
            "email": email,
            "id": id
        }, //携带参数
        //data:"username=aaa&age=23",
        dataType: "json",
        type: "get",
        // cache: true,//true  缓存
        // async: true,// 异步  ， false 同步
        // contentType: "application/x-www/form-urlencoded",//application-json
        success: function () { //响应成功后回调
            top.location.href = "personalcenter.html"
        },
        //fail
        error: function () {
            alert("出错了")
        }
    });
};
//选中
$("#modal_body").click(function (event) {
    var $target = $(event.target);
    $(".modal_body_li").removeClass("modal_body_li");
    $target.addClass("modal_body_li");
});


function update() {
    var a = $(".modal_body_li").text()
    $(".sex")[0].innerHTML = a
}