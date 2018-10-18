$(document).ready(function() {

    $("#card-borrower-doc-submit-btnll").click(function(){
        console.log("Into the JS:");
        var form = $('#cardBorrowerDocUploadForm')[0];
        var data=new FormData(form);
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        console.log("formData:"+data);
        console.log("CustomerID:"+data.personalInfo.customerId);
        alert("Hittt!!!!!!!!!");
        $.ajax({
            url: '/card/document/uploadfile/create',
            type: "POST",
            data: data,
            enctype: 'multipart/form-data',
            processData: false,
            contentType: false,
            cache: false,
            beforeSend: function (xhr) {xhr.setRequestHeader(header, token);
            },
            success: function () {

                console.log("Succesfull added data:"+ data.toString());
                // Handle upload success
                // ...
            },
            error: function () {
                console.log("Error!!!!!!!!!!!");
                // Handle upload error
                // ...
            }
        });
    });
});
