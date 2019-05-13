document.addEventListener("DOMContentLoaded", function(){

    // getArticles();
    getSectionInShort();

})

function getSectionInShort() {
    $.ajax({
        url: "http://localhost:8080/api/article/komorkomania/section",
        dataType: "json"
    })
        .done(function(articles){
            let listEl = document.getElementById("InShort");
            articles.forEach( article => addArticleToList(listEl, article) );
        })
}

function addArticleToList(listEl, articleObj) {
    let newA = document.createElement("a");

    newA.href = "http://localhost:8080/article?article=" + articleObj.url.substring(24);
    newA.innerText = articleObj.header;
    newA.className="list-group-item list-group-item-action";

    listEl.appendChild(newA);

}


