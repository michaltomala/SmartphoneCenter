document.addEventListener("DOMContentLoaded", function(){

    getArticles();
    getSectionInShort();

})

function getArticles() {

    $.ajax({
        url: "http://localhost:8080/api/article/komorkomania",
        dataType: "json"
    })
        .done(function (articles) {
            let listEl = document.getElementById("articles");
            articles.forEach(article => addArticleToList(listEl,article));
        })
}

function addArticleToList(listEl , articleObj) {

    let parentDiv = document.createElement("div");
    parentDiv.className = "col-md-4";

    let div = document.createElement("div");
    div.className = "card mb-4 box-shadow";
    parentDiv.appendChild(div);

    let a = document.createElement("a");
    a.href = "http://localhost:8080/article?article=" + articleObj.url.substring(24)

    let img = document.createElement("img");
    img.className = "card-img-top";
    img.src = articleObj.image;
    img.width = 405;
    img.height = 385;

    let p = document.createElement("p");
    p.className ="card-text";
    p.innerText = articleObj.header;

    a.appendChild(img);
    a.appendChild(p);

    div.appendChild(a);
    listEl.appendChild(parentDiv);
}


function getSectionInShort() {
    $.ajax({
        url: "http://localhost:8080/api/article/komorkomania/section",
        dataType: "json"
    })
        .done(function(articles){
            let listEl = document.getElementById("InShort");
            articles.forEach( article => addSectionToList(listEl, article) );
        })
}

function addSectionToList(listEl, articleObj) {
    let newA = document.createElement("a");

    newA.href = "http://localhost:8080/article?article=" + articleObj.url.substring(24);
    newA.innerText = articleObj.header;
    newA.className="list-group-item list-group-item-action";

    listEl.appendChild(newA);

}



