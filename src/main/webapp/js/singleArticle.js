document.addEventListener("DOMContentLoaded", function() {

    getArticle();

})

function getArticle() {

    let articleParam= new URLSearchParams(window.location.search);
    articleParam.get("article");

    $.ajax({
        url: "http://localhost:8080/api/article/"+articleParam,
        dataType: "json"
    })
        .done(function(article){
            let listEl = document.getElementById("InShort");
            articles.forEach( article => takeArticle(listEl, article));
        })
}


function takeArticle(listEl, article) {

}
