function addEmploymentInfo() {

    var formValues = $('#employmentInfoForm').serializeJSON();
    var jsonEmploymentInfoFormData = JSON.stringify(formValues);
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    console.log(jsonEmploymentInfoFormData);
        $.ajax({
            url: '/card/customer-info/employment-info/save',
            type: 'POST',
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            data: jsonEmploymentInfoFormData,
            beforeSend: function (xhr) {xhr.setRequestHeader(header, token);
            },
            success: function (data) {
                alert(data.successMsg);
                $('#employmentInfoMain').hide();
                $('#employmentInfoViewDiv').show();
                $('#empInfoId').val(data.employmentInfo.empInfoId);
                $('#professionV').text(data.employmentInfo.professionName);
                $('#companyNameV').text(data.employmentInfo.companyName);
                $('#departmentV').text(data.employmentInfo.department);
                $('#designationV').text(data.employmentInfo.designation);
                $('#businessNatureV').text(data.employmentInfo.businessNature);
            },
            error: function (err) {
                alert(err);
            }
        });
}

$('#employmentInfoCommitButton').click(function(event) {

    event.preventDefault();
    addEmploymentInfo();
});

$('#employmentInfoViewEditBtn').click(function(event) {
    event.preventDefault();
    $('#employmentInfoMain').show();
    $('#employmentInfoViewDiv').hide();
});
