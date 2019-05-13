document.addEventListener("DOMContentLoaded", function(){

    // getArticles();
    getSectionInShort();
}

function getSectionInShort() {
    $.ajax({
        url: "http://localhost:8080/api/article/komorkomania/section",
        // url: "http://localhost:8282/books",
        dataType: "json"
    })
        .done(function(articles){
            let listEl = document.getElementById("InShort");
            articles.forEach( articles => addBookToList(listEl, article) );
        })
}


