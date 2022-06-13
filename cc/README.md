# Cloud Computing

## High-level Architecture

![High-level Architecture](https://drive.google.com/uc?export=view&id=1umoOmmjY2fi5cFbGN8aBFPJ_tuD6HPrh)

Here’s the high-level architecture view of what technology that we use inside Firebase. The idea of using the Firebase is that we can use their Firebase SDK to directly communicate with the client.

He’re we have some of Firebase products. We deploy our custom model (in another words .tflite) to Firebase Machine Learning so that we can cut-off our installation size. Using Firebase ML allow us to swap the ML model without republishing our app.

We use the Firebase Authentication to authenticate users by integrating with federated identity providers. The Firebase Authentication SDK provides methods that allow users to sign in with their Google, Facebook, Twitter, and GitHub accounts.

We are also want to store the user data seamlessly using Firestore. The reason why we use Firestore inside of Firebase is that Cloud Firestore caches data that our app is actively using, so the app can write, read, listen to, and query data even if the device is offline. When the device comes back online, Cloud Firestore synchronizes any local changes back to Cloud Firestore.

The Cloud Function for Firebase also allow us to build private API using Firebase SDK to access the some Firebase resource such as Authentication and Firestore. This allows us to build an API product so the developers can access our resources as well as monetizing our API while the developer accessing our data. Our aim using Cloud Functions for API endpoints is to enable the hospital, and mental-wellness activist/organization to use our product as well.
