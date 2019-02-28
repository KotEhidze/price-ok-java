package com.priceok.demo.data.cloud

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient

@Component
class FirestoreDatabase @Autowired constructor(props: FirestoreProperties) {

    private lateinit var db: Firestore

    init {
        val options = FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(props.credentialsStream))
                .setProjectId(props.projectId)
                .build().apply {
                    FirebaseApp.initializeApp(this)
                }
        db = FirestoreClient.getFirestore()
    }

    final fun collection(name: String) = db.collection(name)

    final fun insertData(collectionName: String, map: MutableMap<String, Any>)
            = db.collection(collectionName).document().set(map).get()

    final fun updateData(collectionName: String, documentName: String, map: MutableMap<String, Any>)
            = db.collection(collectionName).document(documentName).set(map)

    final fun getData(collectionName: String, documentName: String)
            = db.collection(collectionName).document(documentName).get().get()

    final fun deleteData(collectionName: String, documentName: String)
            = db.collection(collectionName).document(documentName).delete().get()
}