const functions = require("firebase-functions");
const Firestore = require("@google-cloud/firestore");
const admin = require("firebase-admin");
const express = require("express");
const cors = require("cors");

const db = new Firestore();

const app = express();
app.use(cors({origin: true}));

// Retrieve user data test result based on user id
app.get("/v1/diagnostics/result/:id", async (req, res) => {
  const id = req.params.id;
  const query = db.collection("results").where("id", "==", id);
  const querySnapshot = await query.get();
  if (querySnapshot.size > 0) {
    res.json(querySnapshot.docs[0].data());
  } else {
    res.json({status: "Not found."}).status(200);
  }
});


// Upload test user data into Firestore based on user id
app.post("/v1/diagnostics/", async (req, res) => {
  const data = {
    timesamp: admin.firestore.Timestamp,
    id: req.body.id, // Firebase Auth UID
    level: req.body.level, // low, mid, high, very_high
    type: req.body.type, // type of test: anxiety, stress, depression
  };

  // Check if uid exist in Firebase Authentication
  const query = db.collection("users");
  const snapshot = await query.where("id", "==", data.id);
  if (!snapshot.exists) {
    await db.collection("results").doc().set(data);
    res.json({status: "success", data: {result: data}}).status(200);
  } else {
    res.json({status: "UID not found."}).status(404);
  }
});

// Export the API into Firebase Functions
exports.app = functions.https.onRequest(app);
