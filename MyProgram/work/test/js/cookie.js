// 设置cookie
//这个函数的的参数是：cookie 的名字（cname），cookie 的值（cvalue），以及知道 cookie 过期的天数（exdays）。
//通过把 cookie 名称、cookie 值和过期字符串相加，该函数就设置了 cookie。
function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}
//获取 cookie 的函数
// 把 cookie 作为参数（cname）。
// 创建变量（name）与要搜索的文本（CNAME”=”）。
// 解码 cookie 字符串，处理带有特殊字符的 cookie，例如 “$”。
// 用分号把 document.cookie 拆分到名为 ca（decodedCookie.split(';')）的数组中。
// 遍历 ca 数组（i = 0; i < ca.length; i++），然后读出每个值 c = ca[i]。
// 如果找到 cookie（c.indexOf(name) == 0），则返回该 cookie 的值（c.substring(name.length, c.length）。
// 如果未找到 cookie，则返回 ""。
function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
         }
        if (c.indexOf(name)  == 0) {
            return c.substring(name.length, c.length);
         }
    }
    return "";
}
//检测 cookie 的函数
// 最后，我们创建检查 cookie 是否设置的函数。
// 如果已设置 cookie，将显示一个问候。
// 如果未设置 cookie，会显示一个提示框，询问用户的名字，并存储用户名 cookie 365 天，通过调用 setCookie 函数：
function checkCookie() {
    var user = getCookie("username");
    if (user != "") {
        alert("Welcome again " + user);
    } else {
        user = prompt("Please enter your name:", "");
        if (user != "" && user != null) {
            setCookie("username", user, 365);
        }
    }
}