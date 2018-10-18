function addCardSpouseInfo() {

    var formValues = $('#spouseInfoForm').serializeJSON();
    var spouseInfoFormData = JSON.stringify(formValues);
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    console.log(spouseInfoFormData);
    $.ajax({
        url: '/card/customer-info/spouse-info/save',
        type: 'POST',
        contentType: 'application/json',
        dataType: 'json',
        data: spouseInfoFormData,
        beforeSend: function (xhr) {xhr.setRequestHeader(header, token);
        },
        success: function (data) {
            alert(data.successMsg);
            $('#spouseInfoFormDiv').hide();
            $('#spouseInfoViewDiv').show();
            $('#spoInfId').val(data.spouseInfo.spoInfId);
            $('#NameID').text(data.spouseInfo.name);
            $('#DobID').text(data.spouseInfo.spouseDOB);
            $('#NID').text(data.spouseInfo.spouseNid);
            $('#fatherNameID').text(data.spouseInfo.spouseFatherName);
            $('#motherNameID').text(data.spouseInfo.spouseMotherName);
            $('#mobileNoID').text(data.spouseInfo.mobileNo);
            $('#companyNameID').text(data.spouseInfo.companyName);
            $('#designationID').text(data.spouseInfo.designation);
            $('#businessLenID').text(data.spouseInfo.businessLength);
            $('#monthlyIncomeID').text(data.spouseInfo.monthlyIncome);
            $('#assetID').text(data.spouseInfo.spouseAsset);
            $('#liabilityID').text(data.spouseInfo.spouseLiability);
            $('#netWorthID').text(data.spouseInfo.spouseNetWorth);
            $('#phoneNoID').text(data.spouseInfo.officePhoneNo);
            $('#addressID').text(data.spouseInfo.spouseAddress);

        },
        error: function (err) {
            alert(err);
        }
    });
}

$('#spouseInfoCommitBtn').click(function(event) {
    event.preventDefault();
    addCardSpouseInfo();
});


$('#spouseInfoViewEditBtn').click(function(event) {
    event.preventDefault();
    $('#spouseInfoFormDiv').show();
    $('#spouseInfoViewDiv').hide();
});




