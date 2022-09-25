package api.model

data class Customer(

    val id: String,

    val username: String? = null,

    val email: String? = null,

    val phoneNumber: String? = null,

    val postCode: String? = null,
) {
}