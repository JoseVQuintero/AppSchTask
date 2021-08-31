package com.joe.appschtask.presentation.form.users

import android.content.Context
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.joe.appschtask.presentation.domain.SignUp
import com.joe.appschtask.utils.Utils

class UserPresenter (
    private val context: Context,
    private val view: UserContract.View
): UserContract.Presenter {

    private val auth = FirebaseAuth.getInstance()
    private val cloud = FirebaseFirestore.getInstance()

    override fun validateEmail(email: String): Boolean {
        var status= false
        auth.fetchSignInMethodsForEmail(email).addOnCompleteListener {
            val emailExists = it.result!!.signInMethods!!.isEmpty()
            status =
                if(emailExists){
                    Log.e("TAG","Sorry, this user exist")
                    true
                }else{
                    Log.e("TAG","The email doesnt' exist")
                    false
                }
        }
        return status
    }

    override fun createUser(signUp: SignUp) {
        if (!Utils.isEmailValid(signUp.email)) {
            view.showError("Please type an a correct email")

        } else if (signUp.name.isEmpty()) {
            view.showError("Please type an name")

        } else if (signUp.lastName.isEmpty()) {
            view.showError("Please type a Last Name")

        } else if (signUp.password.isEmpty() || signUp.repeatPassword.isEmpty()) {
            view.showError("Please type a correct password")

        } else if (signUp.password != signUp.repeatPassword) {
            view.showError("The password don't match")

        } else {
            Log.e("TAG",signUp.toString())
            auth.createUserWithEmailAndPassword(signUp.email, signUp.password)
            .addOnCompleteListener {
                Log.e("TAG",it.isSuccessful.toString())
                if (it.isSuccessful) {
                    val userId = auth.currentUser!!.uid
                    signUp.userId = userId
                    cloud.collection("users").document(userId).set(signUp)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            view.userCreate("Create user success")
                        }
                    }.addOnFailureListener {
                        view.showError(it.message.toString())
                    }
                }
            }.addOnFailureListener {
                view.showError(it.message.toString())
            }
        }
    }
}