const modal = document.getElementById('md01');

function open_modal(doc) {
    console.log('open moda');
    modal.style.display = 'flex';
};

function save_close_modal(doc) {
    var form = document.getElementById("fm01");
    var formData = new FormData(form);
    var formDataObject = {};

    formData.forEach(function(value, key) {
        console.log(key + ': ' + value);
        formDataObject[key] = value;
    });

    var requestOptions = {
        method: 'POST',
        mode: 'cors', // permitir acesso a um domínio diferente
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(formDataObject)
    };

    var responseClone;
    fetch('/food', requestOptions)
    .then(function (response) {
        responseClone = response.clone();
        return response.json()
    })
    .then(data => {
        console.log(data);
//        alert(data);
        conclude_with_modal()
    })
    .catch(err => {
        console.log("Error parsing JSON from response: ", err, responseClone);
        responseClone.text()
        .then(bodyText => {
            console.log('Received the following instead of valid JSON: ', bodyText);
        })
    });
    // form.requestSubmit();
};

function conclude_with_modal() {
    location.reload();
    modal.style.display = 'none';
};
