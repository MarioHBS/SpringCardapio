const modal = document.getElementById('md01');

function open_modal(doc) {
    console.log('open moda');
    modal.style.display = 'flex';
};

function save_close_modal(doc) {
    // const title = document.getElementById('in_title').value;
    // console.log('nome: ' + title);
    // const price = document.getElementById('in_price').value;
    // const img = document.getElementById('in_img').value;

    var form = document.getElementById("fm01");
    var formData = new FormData(form);
    var formDataObject = {};

    formData.forEach(function(value, key) {
        console.log(key + ': ' + value);
        formDataObject[key] = value;
    });

    var jsonData = JSON.stringify(formDataObject);
    // Configurar o cabeçalho
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');

    var requestOptions = {
        method: 'POST',
        headers: headers,
        body: jsonData
    };

    fetch('/food', requestOptions)
    .then(response => response.json())
    .then(data => {
        console.log(data);
        location.reload();
//        modal.style.display = 'none';
    })
    .catch(err => {
        console.error(err);
    });
    // form.requestSubmit();
};

function teste(doc) {
    alert('teste')
};
