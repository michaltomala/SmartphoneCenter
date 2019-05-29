document.addEventListener("DOMContentLoaded", function(){

    getBrands();
    addSwitchButtons();
    addDeleteEvent();
});

function getBrands(){

    let phoneBtn = document.getElementById("smartphones");
    phoneBtn.checked=false;

    let tr = document.getElementById("head section");
    getBrandHeaders(tr);

    $.ajax({
        url: "http://localhost:8080/api/brand/all",
        dataType: "json"
    })
        .done(function (brands) {
            let tbody = document.getElementById("records section");
            while (tbody.firstChild) tbody.removeChild(tbody.firstChild);
            brands.forEach(brand => addBrandRecordToList(tbody,brand));
        })

        // todo - check if there is no record but brand is no empty
        .always(function (brands) {
            if(brands.length === 0){
                let tbody = document.getElementById("records section");
                if(tbody.children.length===0) {
                    let info = document.createElement("td");
                    info.innerHTML = "Nie ma żadnych elementów w bazie";
                    tbody.appendChild(info);
                }
            }
        })
}

function addBrandRecordToList(tbody, brand) {
    let tr = document.createElement("tr");

    let number = document.createElement("td");
    number.innerHTML = tbody.children.length+1;

    let name = document.createElement("td");
    let nameLink = document.createElement("a");
    nameLink.href = "#";
    nameLink.innerHTML = brand.name;
    name.appendChild(nameLink);

    let smartphoneNumber = document.createElement("td");
    smartphoneNumber.innerHTML = brand.phones.length;

    let add = document.createElement("td");

    let edit = document.createElement("td");
    let editLink = document.createElement("a");
    editLink.href="/admin/brand/edit/"+brand.id;
    editLink.className = "btn btn-sm manage";
    editLink.innerHTML = "Edytuj";
    edit.appendChild(editLink);

    let deleteElem = document.createElement("td");
    let deleteInput = document.createElement("input");
    deleteInput.type = "radio";
    deleteInput.name = "options[]";
    deleteInput.value = brand.id;
    deleteInput.id = "deleteRadio";
    deleteElem.appendChild(deleteInput);

    addBrandDataToRecord(tbody,tr,number,name,smartphoneNumber,add,edit,deleteElem);
}

function addBrandDataToRecord(tbody,tr,number,name,smartphoneNumber,add,edit,deleteElem) {
    tr.appendChild(number);
    tr.appendChild(name);
    tr.appendChild(smartphoneNumber);
    tr.appendChild(add);
    tr.appendChild(edit);
    tr.appendChild(deleteElem);

    tbody.appendChild(tr);
}


function getPhones(){

    let phoneBtn = document.getElementById("brands");
    phoneBtn.checked=false;

    let tr = document.getElementById("head section");
    getPhoneHeaders(tr);

    $.ajax({
        url: "http://localhost:8080/api/phone/all",
        dataType: "json"
    })
        .done(function (phones) {
            let tbody = document.getElementById("records section");
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

    let brandName = document.createElement("td");
    let brandLink = document.createElement("a");
    brandLink.href = "#";
    brandLink.innerHTML = phone.brand.name;
    brandName.appendChild(brandLink);

    let phoneName = document.createElement("td");
    phoneName.innerHTML = phone.name;

    let price = document.createElement("td");
    price.innerHTML = phone.price;

    let add = document.createElement("td");

    let edit = document.createElement("td");
    let editLink = document.createElement("a");
    editLink.href="#";
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

    addPhoneDataToRecord(tbody,tr,number,brandName,phoneName,price,add,edit,deleteElem);
}

function addPhoneDataToRecord(tbody,tr,number,brandName,phoneName,price,add,edit,deleteElem){
    tr.appendChild(number);
    tr.appendChild(brandName);
    tr.appendChild(phoneName);
    tr.appendChild(price);
    tr.appendChild(add);
    tr.appendChild(edit);
    tr.appendChild(deleteElem);

    tbody.appendChild(tr);
}

function getBrandHeaders(tr) {

    let headers = tr.children;
    headers[1].innerHTML = "Nazwa";
    headers[2].innerHTML = "Liczba Smartphonów";
    if(headers[3].innerHTML==="Cena") tr.removeChild(headers[3]);

    let links = tr.getElementsByTagName("a");
    for (var i = 0; i < links.length; i++) {
        if(links[i].className === "btn btn-success") links[i].href = "/admin/brand/create";
        else if(links[i].className === "btn btn-danger") links[i].href = "/admin/brand/delete/";
    }

}

function getPhoneHeaders(tr){

    let headers = tr.children;
    headers[1].innerHTML = "Marka";
    headers[2].innerHTML = "Nazwa";
    if(headers[3].getElementsByTagName("a") !== null) {
        if(headers[3].innerHTML !== "Cena"){
            let th = document.createElement("th");
            th.innerHTML = "Cena";
            tr.insertBefore(th,headers[3])
        }

    }

    let links = tr.getElementsByTagName("a");
    for (var i = 0; i < links.length; i++) {
        if(links[i].className === "btn btn-success") links[i].href = "/admin/phone/create/firstStep";
        else if(links[i].className === "btn btn-danger") links[i].href = "/DeletePhone";
    }

}

function addSwitchButtons(){

    let smartphones = document.getElementById("smartphones");
    smartphones.addEventListener("click", e=>getPhones());

    let brands = document.getElementById("brands");
    brands.addEventListener("click",e=> getBrands());
}


function addDeleteEvent(){
    let deleteLink = document.getElementById("deleteLink");
    deleteLink.addEventListener("click", function () {
        let checkedRadioBtn = document.querySelector('input[name="options[]"]:checked');
        if(checkedRadioBtn==null)deleteLink.href = deleteLink.href+ "0";
        else deleteLink.href = deleteLink.href+ checkedRadioBtn.value;
    });
}

