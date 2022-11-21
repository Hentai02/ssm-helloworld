const H = {};

// @RequestBody {key: value}
H.rest = function (url,data,success) {
    if (data == null)data = {}             // 若data为null,则发送一个默认JSON{}
    $.ajax({
        url:url,
        method:'POST',
        contentType: 'application/json' ,  // HTTP请求中的 Content-Type
        data: JSON.stringify(data) ,      // HTTP请求正文
        processData: false,
        dataType: 'json',                  // HTTP应答按JSON处理
        success: function (ret,textStatus,jqXHR) {
            // app.$message.success(ret.reason);
            success(ret)
        },
        error: function (jqXHR,textStatus,errorThrown) {
            app.$message.error(errorThrown);
            // error(errorThrown)
        }
    })
}

// @RequestParam 表单数据
H.form = function (url,data,success) {
    if (data == null)data = {}
    $.ajax({
        url:url,
        method:'POST',
        data: data,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        dataType: 'json',
        success: function (ret,textStatus,jqXHR) {
            // app.$message.success(ret.reason);
            success(ret)
        },
        error: function (jqXHR,textStatus,errorThrown) {
            app.$message.error(textStatus);
            // error(errorThrown)
        }
    })
}

