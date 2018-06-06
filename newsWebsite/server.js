var express = require('express');
var app = express();
var fs = require('fs');
var newsContent;

app.set('view engine' , 'ejs');
app.get('/' ,function (req , res) {
   // var content = fs.createReadStream(__dirname + "/news.html" , 'utf8');
  var contentFile =  fs.readFileSync(__dirname + '/content.json','utf8');
  var content = JSON.parse(contentFile.trim());
  //console.log(content.count)
  //var count  = content.count
  //var con = {content1: "contents from other news sites"}
  //var content1 = content.content1;
  //var content2 = content.content2;
  //var content3 = content.content3;
  res.render('newsPage' , {news1:content.content1 , news2:content.content2 , news3:content.content3} );
    
} )
app.get('/postnews' ,function(req , res){
    //console.log(req.query['content2'] !==undefined)
    //newsContent = req.query['content1'];
    //console.log(newsContent);
    if(req.query['content1'] !==undefined ){
        newsContent = req.query['content1'];
        var contentFile =  fs.readFileSync(__dirname + '/content.json','utf8');
        var content = JSON.parse(contentFile.trim());
        content['content1'] =newsContent;
        var writeStream = fs.createWriteStream(__dirname +"\\content.json");
 	    writeStream.write(JSON.stringify(content));  
        console.log("content1 updated");
    } 
    else if(req.query['content2'] !== undefined){
       newsContent = req.query['content2'];
       var contentFile =  fs.readFileSync(__dirname + '/content.json','utf8');
       var content = JSON.parse(contentFile.trim());
       content['content2'] =newsContent; 
       var writeStream = fs.createWriteStream(__dirname +"\\content.json");
 	   writeStream.write(JSON.stringify(content));
    
       console.log("content2 updated");
    }
    else if(req.query['content3'] !== undefined){
       newsContent = req.query['content3'];
       var contentFile =  fs.readFileSync(__dirname + '/content.json','utf8');
       var content = JSON.parse(contentFile.trim());
       content['content3'] =newsContent; 
       var writeStream = fs.createWriteStream(__dirname +"\\content.json");
 	   writeStream.write(JSON.stringify(content));
    
       console.log("content3 updated");
          
    }
    
        res.status(200);
    res.set({'Content-type': 'text/plain'});
    res.send("news updated") ;       
       
 	//res.status(200);
 	//res.set({'Content-Type':'text/html'});
 	//res.send(fs.readFileSync('./addWord.html' ,'utf8'));
});
app.get('/postPage', function (req , res){
        
   res.sendFile(__dirname + '/postPage.html');
} )







console.log("server started");
app.listen(3000);