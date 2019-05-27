document.addEventListener("DOMContentLoaded", function(){

    getBrands();

});

function getBrands(){

    let tr = document.getElementById("head section");
    getBrandHeaders(tr);

    $.ajax({
        url: "http://localhost:8080/api/brand/all",
        dataType: "json"
    })
        .done(function (brands) {
            let tbody = document.getElementById("records section");
            brands.forEach(brand => addRecordToList(tbody,brand));
        })
        .always(function (brands) {
            if(brands.length === 0){
                let tbody = document.getElementById("records section");
                let info = document.createElement("td");
                info.innerHTML = "Nie ma żadnych elementów w bazie";
                tbody.appendChild(info);
            }
        })
}

function addRecordToList(tbody, brand) {
    let tr = document.createElement("tr");

    let id = document.createElement("td");
    id.innerHTML = tbody.children.length+1;

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
    editLink.href="#";
    editLink.className = "btn btn-sm manage";
    editLink.innerHTML = "Edytuj";
    edit.appendChild(editLink);

    let deleteElem = document.createElement("td");
    let deleteInput = document.createElement("input");
    deleteInput.type = "checkbox";
    deleteInput.name = "options[]";
    deleteInput.value = brand.id;
    deleteElem.appendChild(deleteInput);

    addBrandDataToRecord(tbody,tr,id,name,smartphoneNumber,add,edit,deleteElem);
}

function addBrandDataToRecord(tbody,tr,id,name,smartphoneNumber,add,edit,deleteElem) {
    tr.appendChild(id);
    tr.appendChild(name);
    tr.appendChild(smartphoneNumber);
    tr.appendChild(add);
    tr.appendChild(edit);
    tr.appendChild(deleteElem);

    tbody.appendChild(tr);
}


function getPhones(){

    let tr = document.getElementById("head section");
    getPhoneHeaders(tr);

    // $.ajax({
    //     url: "http://localhost:8080/api/brand/all",
    //     dataType: "json"
    // })
    //     .done(function (brands) {
    //         let tbody = document.getElementsByTagName("tbody");
    //         brands.forEach(brand => addArticleToList(tbody,brand));
    //     })

}

function getBrandHeaders(tr) {

    let headers = tr.children;
    headers[1].innerHTML = "Nazwa";
    headers[2].innerHTML = "Liczba Smartphonów";
    if(headers[3].innerHTML==="Cena") tr.removeChild(headers[3]);

    let links = tr.getElementsByTagName("a");
    for (var i = 0; i < links.length; i++) {
        if(links[i].className === "btn btn-success") links[i].href = "/admin/brand/create";
        else if(links[i].className === "btn btn-danger") links[i].href = "/DeleteBrand";
    }

}

function getPhoneHeaders(tr){

    let headers = tr.children;
    headers[1].innerHTML = "Marka";
    headers[2].innerHTML = "Nazwa";
    if(headers[3].getElementsByTagName("a") !== null) {
        let th = document.createElement("th");
        th.innerHTML = "Cena";
        tr.insertBefore(th,headers[3])
    }

    let links = tr.getElementsByTagName("a");
    for (var i = 0; i < links.length; i++) {
        if(links[i].className === "btn btn-success") links[i].href = "/admin/phone/create";
        else if(links[i].className === "btn btn-danger") links[i].href = "/DeletePhone";
    }

}



// smartphone


    //         <tr data-status="active">
    //     <td>3</td>
    //     <td><a href="#">convallissed.com</a></td>
    // <td><a href="#">convallissed.com</a></td>
    // <td>United Kingdom</td>
    // <td></td>
    // <td><a href="#" class="btn btn-sm manage">Edytuj</a></td>
    // <td>
    // <input type="checkbox" name="options[]" value="3">
    //     </td>
    //     </tr>