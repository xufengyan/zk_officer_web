var lan
//轮播
function addBanner(callback) {
    let str = ""
    let i = 0
    $.ajax({
        url: "http://localhost:8089/html/management/list.html",
        type: "get",
        // contentType : 'application/json',
        // async: true,
        dataType: 'json',
        data: {lan: lan},
        success: function (res) {
            res.data.forEach(function (item,index) {
                if(item.imageType === 0 && i < 4){
                    console.log(document.getElementById('carousel'+i))
                    if(document.getElementById('carousel'+i)){
                        document.getElementById('carousel'+i).src = item.imageUrl;
                        i++;
                    }
                }
                else if(item.imageType === 1){
                    $("#collaborate").append("<div class=\"client-item wow fadeInLeft\">\n" +
                        "                        <img src=\""+item.imageUrl+"\" alt=\"\" />\n" +
                        "                    </div>")
                }

            })
            console.log(res)
            callback(res)
        },
        error: function (error) {
            alert(error);
        }
    });
}
function addParagraphList() {
    let iconList = ['icon-Users','icon-Settings','icon-Mail','icon-Cup'];
    let i = 0;
    let i2 = 0;

    $.ajax({
        url: "http://localhost:8089/html/paragraph/list.html",
        type: "get",
        // contentType : 'application/json',
        // async: true,
        dataType: 'json',
        data: {lan: lan},
        success: function (res) {
            console.log(res)
            res.data.forEach(function (item,index) {
                if(item.cType === 2 && i<4){
                    $("#paragraph").append("<div class=\"col-md-3 col-sm-6 wow fadeIn\">\n" +
                        "                        <article>\n" +
                        "                            <div class=\"feature-item \">\n" +
                        "                                <div class=\"wrap-feature-icon\">\n" +
                        "                                    <div class=\"feature-icon\">\n" +
                        "                                        <span class=\"icon "+iconList[i]+"\"></span>\n" +
                        "                                    </div>\n" +
                        "                                </div>\n" +
                        "                                <div class=\"title\" >"+item.name+"</div>\n" +
                        "                                <div class=\"text\" >\n"+item.content  +
                        "                                </div>\n" +
                        "                            </div>\n" +
                        "                        </article>\n" +
                        "                    </div>")
                    i++;
                }else if (item.cType === 1 && i2<3){
                    $("#paragraph2").append("<div>\n" +
                        "                                <p style=\"margin: 0 0 0.5em;font-weight: 900;font-size: 15px;\">"+item.name+"</p>\n" +
                        "                                <p>"+item.content+"</p>\n" +
                        "                            </div>")
                    i2++
                }



            })

        },
        error: function (error) {
            alert(error);
        }
    });
}
function addProductList() {
    let str = ""
    $.ajax({
        url: "http://localhost:8089/html/product/list.html",
        type: "get",
        // contentType : 'application/json',
        // async: true,
        dataType: 'json',
        data: {cType: 2,lan: lan},
        success: function (res) {
            console.log(res)
            res.data.forEach(function (item,index) {
                str += "<div class=\"scroll-content-item  \">\n" +
                    "                        <a href=\""+item.pImagePath+"\" class=\"fancybox\">\n" +
                    "                            <img src=\""+item.pImagePath+"\" alt=\"\" />\n" +
                    "                        </a>\n" +
                    "                        <div class=\"name\">dahls 160</div>\n" +
                    "                    </div>"
            })
            $("#productList").html(str)
        },
        error: function (error) {
            alert(error);
        }
    });
}
//网站基本信息
function addBasic(callback) {
    let str = ""
    $.ajax({
        url: "http://localhost:8089/html/basic/read/"+lan,
        type: "get",
        // contentType : 'application/json',
        // async: true,
        dataType: 'json',
        success: function (res) {
            //二维码
            document.getElementById("qrcode").src = res.data.owQrcodePath
            //备案号
            $("#owInternetcp").html(res.data.owInternetcp)
            //联系地址
            $("#house").append(res.data.owAddress)
            $("#tel").append(res.data.owTel)
            $("#phone").append(res.data.owPhone)
            $("#eMail").append(res.data.owMail)
            callback(res)
            //logo
            res.data.owLogo
        },
        error: function (error) {
            alert(error);
        }
    });
}
//产品系列
function addCategoryList() {
    var str = "";
    $.ajax({
        url: "http://localhost:8089/html/category/list.html",
        type: "get",
        // contentType : 'application/json',
        // async: true,
        dataType: 'json',
        data: {cType: 2,lan: lan},
        success: function (res) {
            res.data.list.forEach(function (item,index) {
                if (index<4) {
                    str += "<li><a href=\"#\">" + item.label + "</a></li>\n"
                }
            })
            $("#Category").html(str)
        },
        error: function (error) {
            alert(error);
        }
    });
}
function addSchemeList(callback) {
    var str = "";
    $.ajax({
        url: "http://localhost:8089/html/scheme/list.html",
        type: "get",
        // contentType : 'application/json',
        // async: true,
        dataType: 'json',
        data: {lan: lan},
        success: function (res) {
            callback(res)
            res.data.list.forEach(function (item,index) {
                if(index<4){
                    str += "<li><a href=\"#\">"+item.sName+"</a></li>\n"
                }
            })
            str += "<li><a href=\"#\">更多</a></li>\n"
            $("#scheme").html(str)
        },
        error: function (error) {
            alert(error);
        }
    });
}
function addDownloadList(callback) {
    var str = "";
    $.ajax({
        url: "http://localhost:8089/html/download/list.html",
        type: "get",
        // contentType : 'application/json',
        // async: true,
        dataType: 'json',
        data: {lan: lan},
        success: function (res) {
            res.data.list.forEach(function (item,index) {
                if(index<4){
                    str += "<li><a href=\"#\">"+item.dName+"</a></li>\n"
                }
            })
            str+="<li><a href=\"#\">更多</a></li>\n"
            $("#download").html(str)
            callback(res)
        },
        error: function (error) {
            alert(error);
        }
    });
}