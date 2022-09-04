const express = require("express");
const mongoose = require("mongoose");
const bodyParser = require("body-parser");
const app = express();

app.use(bodyParser.urlencoded({extended: true}));

const url = "mongodb+srv://RKDevelopments:Hooggeleid2022@rkdevelopments.ymjfajd.mongodb.net/?retryWrites=true&w=majority"

async function connect() {
    try{
        await mongoose.connect(url);
        console.log("Connected to Mongodb")
    }catch (error){
        console.error(error);
    }
}

connect();

const feedbackScheme = {
    feedback: String
}

const Raiting = mongoose.model("Raiting", feedbackScheme);

// app.get("/", function (req, res){
//     res.sendFile(__dirname + "/pricing.html")
// })


app.post('/post-feedback', function (req, res) {
    let newFeedback = new Raiting({
        feedback: req.body.feedback
    })
    newFeedback.save();
    res.redirect('/pricing.html')
});

app.listen(8000, () => {
    console.log("Server started on port 8000")
})