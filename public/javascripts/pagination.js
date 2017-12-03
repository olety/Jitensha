var products = document.querySelectorAll('div[id^="pcard_"]');
console.log(products);
var links = document.querySelectorAll('a[id^="pagination_"]');
console.log(links)

function showPages(pageNumber, productsPerPage){
    // var numberPages = Math.ceil(products.length / productsPerPage);

    console.log(pageNumber);
    var start = pageNumber*productsPerPage;
    var end = start + productsPerPage;
    console.log(products);
    console.log(start + "-" + end);
    for(var i=0; i<products.length; i++){
        if (i >= start && i < end) {
             console.log("marking " + i + "as visible");
             products[i].hidden=false;
        } else {
            console.log("marking " + i + "as hidden")
            products[i].hidden=true;
        }
    }
};

function showPagesHandler(){
    showPages(parseInt(this.id.split("_")[1]), 16);
}

links.forEach(function(node) {
    node.addEventListener("click", showPagesHandler);
});

console.log(links)
showPages(0, 16);
