require.config({
    paths: {
        "index": "index/index.js",
        "html":  "index/index.html"
    },
    shim:{
        // "test":{
        //     exports:"test"
        // }

    }
});
require(["index","html"],function(index,html){
    index.sayHello();
    console.log(html);
})