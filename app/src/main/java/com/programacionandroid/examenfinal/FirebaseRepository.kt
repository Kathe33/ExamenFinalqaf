package com.programacionandroid.examenfinal

import com.programacionandroid.examenfinal.Item
import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

class FirebaseRepository {

    val db = Firebase.firestore

    // Method to read data from Firebase Firestore
    fun getItems(): List<Item> {
        db.collection("item")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
        // TODO: Implementar logica para leer datos de Firestore
        return emptyList()
    }

    // Method to add a new item to Firebase Firestore
    fun addItem(item: Item) {

        db.collection("users")
            .add(item.id)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
        // TODO: Implementar logica para agregar un nuevo item a Firestore
    }
}