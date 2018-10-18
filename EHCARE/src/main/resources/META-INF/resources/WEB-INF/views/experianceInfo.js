function addPreviousExperianceInfo() {

    var formValues = $('#prevExperianceInfoForm').serializeJSON();
    var jsonExperianceInfoFormData = JSON.stringify(formValues);
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    console.log(jsonExperianceInfoFormData);
        $.ajax({
            url: '/card/customer-info/experiance-info/save',
            type: 'POST',
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            data: jsonExperianceInfoFormData,
            beforeSend: function (xhr) {xhr.setRequestHeader(header, token);
            },
            success: function (data) {
                // $('#customerInfoCreditFacilityModal').modal('hide');
                alert(data.successMsg);
                //$('#employmentInfoMain').show();
                $('#Previous-Experiance-Modal').modal('hide');
                $("#expInfoId").val(data.experianceInfo.expInfoId);
                if (data.experianceInfo != null) {
                    var str = "<tr>" +
                        "<td>" + data.experianceInfo.expProfession + "</td>" +
                        "<td>" + data.experianceInfo.expCompName + "</td>" +
                        "<td>" + data.experianceInfo.expDepartment + "</td>" +
                        "<td>" + data.experianceInfo.expDesignation + "</td>" +
                        "<td>" + data.experianceInfo.expBusinessNature + "</td>" +
                        "<td>" +
                        " <button class='btn-info' value='${expInfoId}' onclick=\"prevExperianceEditBtn()\">Edit</button> "+
                        "</td>" +
                        "</tr>";
                    $('#pExperianceInfo_tBody').append(str);
                }
            },
            error: function (err) {
                alert(err);
            }
        });
}

$('#prevExperianceSaveButton').click(function(event) {

    event.preventDefault();
    addPreviousExperianceInfo();
});

function prevExperianceEditBtn(){
    $('#Previous-Experiance-Modal').show();
}

