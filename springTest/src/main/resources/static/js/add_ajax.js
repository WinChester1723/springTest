$('#save').click(function () {
    let name = $('#name').val()
    let surname = $('#surname').val()
    let age = $('#age').val()

    let data = {}

    data.name = name
    data.surname = surname
    data.age = age

    $.ajax({
        url: '/main/customers/create',
        type: 'POST',
        data: JSON.stringify(data),
        dataType: 'json',
        contentType: "application/json"
    });
})