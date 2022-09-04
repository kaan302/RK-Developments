const express = require("express");
const mongoose = require("mongoose");
const app = express();

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

app.listen(8000, () => {
    console.log("Server started on port 8000")
})