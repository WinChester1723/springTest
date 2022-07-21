$(document).ready(function (){
    $('#edit').click(function () {
        let name = $('#name').val()
        let surname = $('#surname').val()
        let age = $('#age').val()
        // let id = $('#id').val()

        let data = {}
        data.name = name
        data.surname = surname
        data.age = age

        var formData = new FormData();
        formData.append("name",name);
        formData.append("surname",surname);
        formData.append("age",age);

        $.ajax({
            url: window.location + '/main/customers/put/edit/{id}',
            type: 'PUT',
            data: JSON.stringify(formData),
            dataType: 'json',
            contentType: "application/json"
        });
    })
})