

function getGoods(gscid,success) {
    $.ajax({
        url:'goods/queryGoods.do',
        method:'post',
        data: {gscid:gscid},
        dataType: 'json',
        success:success
    })
}

function likeGoods(sussess) {
    $.ajax({
        url:'goods/queryLikeGoods.do',
        method:'post',
        dataType: 'json',
        success:sussess
    })
}

