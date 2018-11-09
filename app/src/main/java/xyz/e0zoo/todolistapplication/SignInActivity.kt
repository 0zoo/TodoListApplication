package xyz.e0zoo.todolistapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_in.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import xyz.e0zoo.todolistapplication.api.*
import xyz.e0zoo.todolistapplication.api.model.SignInUserBody
import xyz.e0zoo.todolistapplication.utils.enqueue

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        getUserEmail(this)?.let { email ->
            getUserPassword(this)?.let { password ->
                signIn(email, password)
            }
        }

        //"1ezoo94@gmail.com", "AAaa12345!"

        signInButton.setOnClickListener { _ ->
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            signIn(email, password)
        }
    }

    private fun signIn(email: String, password: String){
        val body = SignInUserBody(email, password)
        val call = authApi.getAccessToken(body)
        call.enqueue({ response ->
            response.body()?.let { auth ->

                updateToken(this, auth.token)
                updateUserEmailPassword(this, email, password)

                startActivity<MainActivity>()
            }

        }, {
            toast(it.message.toString())
        })
    }
}
