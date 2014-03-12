function validateForm() {
    var firstName = document.forms["account"]["firstName"].value;
    if (firstName == null || firstName == "") {
        alert("First name must be filled in");
        return false;
    }
    var lastName = document.forms["account"]["lastName"].value;
    if (lastName == null || lastName == "") {
        alert("last name must be filled in");
        return false;
    }
    var username = document.forms["account"]["username"].value;
    if (username == null || username == "") {
        alert("username must be filled in");
        return false;
    }
    if(!validateEmail(username)){
        alert("username needs to be an email address");
        return false;
    }

    var password = document.forms["account"]["password"].value;
    if (password == null || password == "") {
        alert("Password must be filled in");
        return false;
    }else{
        var password2 = document.forms["account"]["passwordAgain"].value;
        if(password !== password2){
            alert("The passwords are not the same!");
            return false;
        }
    }
    function validateEmail(email) {
        var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test(email);
    }
    return true;
}