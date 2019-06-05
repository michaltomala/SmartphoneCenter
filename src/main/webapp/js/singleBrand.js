document.addEventListener("DOMContentLoaded", function(){

    changeCreateAndDeleteLink();
    getPhonesFromSingleBrand();
    addDeleteEvent();
});

function changeCreateAndDeleteLink() {

    let createLink = document.getElementById("createLink");
    let brandName= new URLSearchParams(window.location.search);
    brandName.get("brand");
    createLink.href = createLink.href + "/brand?"+brandName;

    let deleteLink =  document.getElementById("deleteLink");
    deleteLink.href = deleteLink.href + "/brand?"+brandName;
}


function getPhonesFromSingleBrand(){

    let brandName= new URLSearchParams(window.location.search);
    brandName.get("brand");

    $.ajax({
        url: "http://localhost:8080/api/brand/brand?"+brandName,
        dataType: "json"
    })
        .done(function (phones) {
            let tbody = document.getElementById("phones section");
            while (tbody.firstChild) tbody.removeChild(tbody.firstChild);
            phones.forEach(phone => addPhoneRecordToList(tbody,phone));
        })
        .always(function (phones) {
            if(phones.length === 0){
                let tbody = document.getElementById("records section");
                if(tbody.children.length===0) {
                    let info = document.createElement("td");
                    info.innerHTML = "Nie ma żadnych elementów w bazie";
                    tbody.appendChild(info);
                }
            }
        })
}


function addPhoneRecordToList(tbody,phone) {
    let tr = document.createElement("tr");

    let number = document.createElement("td");
    number.innerHTML = tbody.children.length+1;

    let phoneName = document.createElement("td");
    phoneName.innerHTML = phone.name;

    let price = document.createElement("td");
    price.innerHTML = phone.price;

    let add = document.createElement("td");

    let edit = document.createElement("td");
    let editLink = document.createElement("a");
    editLink.href="/admin/phone/edit/firstStep/"+phone.id;
    editLink.className = "btn btn-sm manage";
    editLink.innerHTML = "Edytuj";
    edit.appendChild(editLink);

    let deleteElem = document.createElement("td");
    let deleteInput = document.createElement("input");
    deleteInput.type = "radio";
    deleteInput.name = "options[]";
    deleteInput.id = "deleteRadio";
    deleteInput.value = phone.id;
    deleteElem.appendChild(deleteInput);

    addPhoneDataToRecord(tbody,tr,number,phoneName,price,add,edit,deleteElem);
}

function addPhoneDataToRecord(tbody,tr,number,phoneName,price,add,edit,deleteElem){
    tr.appendChild(number);
    tr.appendChild(phoneName);
    tr.appendChild(price);
    tr.appendChild(add);
    tr.appendChild(edit);
    tr.appendChild(deleteElem);

    tbody.appendChild(tr);
}


function addDeleteEvent(){
    let deleteLink = document.getElementById("deleteLink");
    deleteLink.addEventListener("click", function () {
        let checkedRadioBtn = document.querySelector('input[name="options[]"]:checked');
        if(checkedRadioBtn==null)deleteLink.href = deleteLink.href.substring(0,41)+ "0"+deleteLink.href.substring(41);
        else deleteLink.href = deleteLink.href.substring(0,41) + checkedRadioBtn.value+deleteLink.href.substring(41);
    });
}
