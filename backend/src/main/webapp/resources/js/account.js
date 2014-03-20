function setGravatar(username){
    $.ajax({
        type: "GET",
        url: "/account/md5",
        contentType: "application/json; charset=utf-8",
        dataType: "text",
        cache: false,
        success: function (data) {
            $('#gravatar').attr('src', 'http://www.gravatar.com/avatar/' + data);
        },
        failure: function (msg) {
            console.log('failure');
        },
        error: function (error) {
            console.log(error);
        }
    });

}

