requirejs.__importGlobal__({
	"jquery"	: "../lib/jquery/jquery-1.10.1.min.js",
	"css"  	 	: "../lib/core/cssLoader.js",
	"text" 		: "../lib/core/text.js",
	"store"		: "../lib/store.js",
	"socket_io"	: "../lib/socket.io/socket.io.js",
	"summernote": "../plugin/editor/summernote.min.js",
	"summernoteCss": "../css/summernote.min.css", 
	"mainCss" 	: "main.css",
	"bootStrap" : "../lib/bootstrap/bootstrap.min.js",
	"bootstrapCss" : "../css/bootstrap.css",
	"bootstrapThemeCss":"../css/bootstrap-theme.css"
}) 
require(requirejs.__autowired__([
	"jquery",
	"store",
	"socket_io",
	"bootStrap",
	"mainCss",
	"summernote",
	"summernoteCss",
	"bootstrapCss",
	"bootstrapThemeCss",
]),function($,store,socket_io){
	window.$store = store;
	let userid='user' + Math.floor((Math.random() * 1000) + 1);
	const url = "http://127.0.0.1:8089?userid="+userid;
	const socketio = socket_io.connect(url);
	let gid;
	let isActive="1";
	function output(message) {
	    let currentTime = "<span class='time'></span>";
	    let element = $("<div>" + currentTime + " " + message + "</div>");
	    $('#console').prepend(element);
	}
	function sendMsg() {
	    if(gid==null||""== gid || undefined==gid){
	        return ;
	    }
	    let  toChat = {
	        userId:userid,
	        groupId: gid,
	        msg:$("#summernote").summernote('code')
	    }
	    socketio.emit("group",toChat);
	}
	socketio.on('connect', function () {
	    output(`<span class="connect-msg">系统通知: 成功连接至websocket服务器</span>`);
	});
	socketio.on('disconnect', function () {
	    output(`<span class="disconnect-msg">系统通知: ${token}已从websocket服务器断开连接</span>`);
	});
	socketio.on('join', function (data) {
	    output(`<span class="sys-msg">${data.groupId} 群通知: 新人 ${data.userId} 请爆照</span>`);
	});
	socketio.on('group',function (data) {
	    output(`<span class="username-msg">${data.groupId} 群消息: ${data.userId} 说: ${data.msg}</span>`);
	
	});
	
	function  join() {
	     gid = $(this).attr("data-channel");
	     if(isActive==gid){return}
	     $(this).addClass("active");
	     $("a[data-channel='"+isActive+"']").removeClass("active");
	     $("#console").empty();
	     isActive=gid;
	     let joinRequest={
	        userId:userid,
	        groupId:gid
	    }
	    socketio.emit("join",joinRequest);
	}
	
	$().ready(function () {
	    $('#summernote').summernote({
	        height: 200,
	        tabsize: 2,
	        lang: 'zh-CN'});
	})
	/*绑定事件*/
	$(".list-group").on("click",".list-group-item",join);
	$("#send").click(sendMsg);
})

