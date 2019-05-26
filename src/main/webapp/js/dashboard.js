document.addEventListener("DOMContentLoaded", function(){

    getBrands();

});

function getBrands(){

    let tr = document.getElementById("head section");
    getBrandHeaders(tr);

    // $.ajax({
    //     url: "http://localhost:8080/api/brand/all",
    //     dataType: "json"
    // })
    //     .done(function (brands) {
    //         let tbody = document.getElementsByTagName("tbody");
    //         brands.forEach(brand => addArticleToList(tbody,brand));
    //     })

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
        if(links[i].className === "btn btn-success") links[i].href = "/AddBrand";
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
        if(links[i].className === "btn btn-success") links[i].href = "/AddPhone";
        else if(links[i].className === "btn btn-danger") links[i].href = "/DeletePhone";
    }

}
    // brand



    //         <tbody>
    //         <tr data-status="active">
    //     <td>1</td>
    //     <td><a href="#">loremvallis.com</a></td>
    // <td>Buenos Aires</td>
    // <td></td>
    // <td><a href="#" class="btn btn-sm manage">Edytuj</a></td>
    // <td>
    // <input type="checkbox" name="options[]" value="1">
    //     </td>
    //     </tr>
//         </tbody>




// smartphone


    //         <thead>
    //         <tr>
    //         <th>#</th>
    // <th>Marka</th>
    // <th>Nazwa</th>
    // <th>Cena</th>
    // <th>
    // <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons"></i> <span>Dodaj</span></a>
    // </th>
    // <th>Edycja</th>
    // <th><a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons"></i> <span>Usuń</span></a>
    // </th>
    // </tr>
    // </thead>



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