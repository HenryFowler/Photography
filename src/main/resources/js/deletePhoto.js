const MongoClient = require("mongodb");

// Server running
const url = 'mongodb://localhost:27017/';

// Database name
const databasename = "GFG";

MongoClient.connect(url).then((client) => {

    // Connecting to the database
    const connect = client.db(databasename);

    // Database collection
    const collection = connect
        .collection("GFGcollections");

    // Delete single document
    collection.deleteOne({ "name": "aayush" });

    // Delete multiple documents having name GFG
    collection.deleteMany({ "class": "GFG" });

    console.log("Deletion Successful");
}).catch((err) => {

    // If error occured show the error message
    console.log(err.Message);
})