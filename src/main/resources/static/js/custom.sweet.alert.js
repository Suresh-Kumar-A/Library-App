function showTopSuccessNotificationWithMessage(message) {
    const Toast = Swal.mixin({
        toast: true,
        position: 'top',
        showConfirmButton: false,
        showCloseButton: true,
        allowOutsideClick: true,
        timerProgressBar: true,
        onOpen: (toast) => {
            toast.addEventListener('mouseenter', Swal.stopTimer)
            toast.addEventListener('mouseleave', Swal.resumeTimer)
        }
    })

    Toast.fire({
        icon: 'success',
        title: message
    })
}

function showTopSuccessNotificationWithMessageAndAutoReload(message) {
    const Toast = Swal.mixin({
        toast: true,
        position: 'top',
        showConfirmButton: false,
        timer: 5000,
        timerProgressBar: true,
        onOpen: (toast) => {
            toast.addEventListener('mouseenter', Swal.stopTimer)
            toast.addEventListener('mouseleave', Swal.resumeTimer)
        }
    })

    Toast.fire({
        icon: 'success',
        title: message
    }).then(() => {
        location.reload();
    });
}

function showTopInfoNotificationWithMessage(message) {
    const Toast = Swal.mixin({
        toast: true,
        position: 'top',
        showConfirmButton: false,
        timer: 5000,
        timerProgressBar: true,
        onOpen: (toast) => {
            toast.addEventListener('mouseenter', Swal.stopTimer)
            toast.addEventListener('mouseleave', Swal.resumeTimer)
        }
    })

    Toast.fire({
        icon: 'info',
        title: message
    })
}

function showTopWarningNotificationWithMessage(message) {
    const Toast = Swal.mixin({
        toast: true,
        position: 'top',
        showConfirmButton: false,
        timer: 3500,
        timerProgressBar: true,
        onOpen: (toast) => {
            toast.addEventListener('mouseenter', Swal.stopTimer)
            toast.addEventListener('mouseleave', Swal.resumeTimer)
        }
    })

    Toast.fire({
        icon: 'warning',
        title: message
    })
}

function showTopErrorNotificationWithMessage(message) {
    const Toast = Swal.mixin({
        toast: true,
        position: 'top',
        showConfirmButton: false,
        timer: 3500,
        timerProgressBar: true,
        onOpen: (toast) => {
            toast.addEventListener('mouseenter', Swal.stopTimer)
            toast.addEventListener('mouseleave', Swal.resumeTimer)
        }
    })

    Toast.fire({
        icon: 'error',
        title: message
    })
}

function showTopErrorNotificationWithMessageAndAutoReload(message) {
    const Toast = Swal.mixin({
        toast: true,
        position: 'top',
        showConfirmButton: false,
        timer: 3500,
        timerProgressBar: true,
        onOpen: (toast) => {
            toast.addEventListener('mouseenter', Swal.stopTimer)
            toast.addEventListener('mouseleave', Swal.resumeTimer)
        }
    })

    Toast.fire({
        icon: 'error',
        title: message
    }).then(() => {
        location.reload();
    });
}


function resendOtpConfirmationPopup() {
    const Toast = Swal.mixin({
        customClass: {
            confirmButton: 'btn resend-otp-btn-primary',
            cancelButton: 'btn resend-otp-btn-secondary'
        },
        buttonsStyling: false
    })

    Toast.fire({
        title: 'Resend OTP',
        text: "To where do you want to resend OTP",
        icon: 'info',
        showCancelButton: true,
        confirmButtonText: 'Mail',
        cancelButtonText: 'Phone',
        reverseButtons: true
    }).then((result) => {
        if (result.value) {
            showTopInfoNotificationWithMessage("Connecting to EzMFA Server");
            //send otp to mail
            sendOtp(1);
        } else if (result.dismiss === Swal.DismissReason.cancel) {
            showTopInfoNotificationWithMessage("Connecting to EzMFA Server");
            //send otp to mobile
            sendOtp(2);
        }
    })
}

function backupCodePopupForm() {
    var backupCode;
    const Toast = Swal.mixin({
        customClass: {
            confirmButton: 'btn resend-otp-btn-primary',
            cancelButton: 'btn resend-otp-btn-secondary'
        },
        buttonsStyling: false
    })
    Toast.fire({
        title: 'Enter Backup Code',
        html: '<input class="swal2-input" placeholder="" id="backup-code" type="number" autofocus>',
        showCancelButton: true,
        reverseButtons: true,
        confirmButtonText: 'Verify',
        cancelButtonText: 'Cancel',
        allowOutsideClick: false,
        preConfirm: () => {
            backupCode = document.getElementById("backup-code").value;
        }
    }).then((result) => {
        if (result.value) {
            showTopInfoNotificationWithMessage("Verifying Backup Code in CloudAuth");
            verifyBackupCode(backupCode);
        }
    })
}

function securityQuestionPopupForm(order, questions, choice) {
    Swal.mixin({
        input: 'text',
        confirmButtonText: 'Next &rarr;',
        showCancelButton: true,
        allowOutsideClick: false,
        progressSteps: ['1', '2', '3']
    }).queue([{
        text: questions[0],
        title: 'Security Questions'
    },
    questions[1],
    questions[2]
    ]).then((result) => {
        if (result.value) {
            verifyRandomSecurityQuestions(order, result.value, choice);
        } else {
            showTopErrorNotificationWithMessage("Access Denied. Can't process your request");
        }
    })
}

function resendGoolgeAuthKeyConfirmationPopup() {
    const Toast = Swal.mixin({
        customClass: {
            confirmButton: 'btn resend-otp-btn-primary',
            cancelButton: 'btn resend-otp-btn-secondary'
        },
        buttonsStyling: false
    })

    Toast.fire({
        title: 'Resend Google Auth Key',
        text: "To where do you want to resend the Key",
        icon: 'info',
        showCancelButton: true,
        confirmButtonText: 'Mail',
        cancelButtonText: 'Phone',
        reverseButtons: true
    }).then((result) => {
        if (result.value) {
            showTopInfoNotificationWithMessage("Connecting to EzMFA Server");
            //send google auth key to mail
            sendGoogleAuthKey(1);
        } else if (result.dismiss === Swal.DismissReason.cancel) {
            showTopInfoNotificationWithMessage("Connecting to EzMFA Server");
            //send goolge auth key to mobile
            sendGoogleAuthKey(2);
        }
    })
}

function resendTapAppBindingLinkPopup() {
    const Toast = Swal.mixin({
        customClass: {
            confirmButton: 'btn resend-otp-btn-primary',
            cancelButton: 'btn resend-otp-btn-secondary'
        },
        buttonsStyling: false
    })

    Toast.fire({
        title: 'Resend App Binding Link',
        text: "To where do you want to resend the link",
        icon: 'info',
        showCancelButton: true,
        confirmButtonText: 'Mail',
        cancelButtonText: 'Phone',
        reverseButtons: true
    }).then((result) => {
        if (result.value) {
            showTopInfoNotificationWithMessage("Connecting to EzMFA Server");
            //send in mail
            requestApplicationRegistration(1);
        } else if (result.dismiss === Swal.DismissReason.cancel) {
            showTopInfoNotificationWithMessage("Connecting to EzMFA Server");
            //send in sms
            requestApplicationRegistration(2);
        }
    })
}

function getMobileNumberPopupInUpdatePassword() {
    document.getElementById("update-password").disabled = true; // disable update password button

    const postRequestOptions = {
        method: 'POST'
    };

    const ezmfaApiServerUrl = location.protocol + "//" + location.host + "/api";

    Swal.queue([{
        title: 'Please enter your mobile number for Identity Validation',
        text: 'Enter your mobile number with your country code',
        imageUrl: 'images/mobile-sms.png',
        imageWidth: 60,
        imageHeight: 60,
        imageAlt: 'Custom image',
        inputPlaceholder: 'Eg: +919876543210',
        input: 'number',
        allowEscapeKey: false,
        inputAttributes: {
            autocapitalize: 'off'
        },
        showCancelButton: false,
        allowOutsideClick: false,
        confirmButtonText: 'Send OTP',
        showLoaderOnConfirm: true,
        inputAutoTrim: true,
        preConfirm: () => {
            const phoneNo = document.getElementsByClassName("swal2-input")[0].value
            const param = "?phone-number=" + phoneNo;
            return fetch(ezmfaApiServerUrl + "/send-sms-otp" + param, postRequestOptions)
                .then(response => response.json())
                .then((data) => {
                    if (data.status) {
                        showTopSuccessNotificationWithMessage(data.message);
                        verifyOtpCodePopupInUpdatePassword(data.refid, phoneNo);
                    } else {
                        showTopErrorNotificationWithMessage("Unable to send OTP")
                    }
                })
                .catch(() => {
                    showTopErrorNotificationWithMessage("Unable to reach server")
                })
        }
    }])

}

function verifyOtpCodePopupInUpdatePassword(refid, phoneNo) {
    const postRequestOptions = {
        method: 'POST'
    };

    const ezmfaApiServerUrl = location.protocol + "//" + location.host + "/api";
    const lastFourDigits = phoneNo.substr(-4);
    Swal.queue([{
        title: 'Mobile Number Validation',
        text: 'OTP has been sent to you on your mobile number. Please enter it below',
        imageUrl: 'images/mobile-sms.png',
        imageWidth: 60,
        imageHeight: 60,
        imageAlt: 'Custom image',
        inputPlaceholder: 'Eg: 203145',
        input: 'number',
        allowEscapeKey: false,
        inputAttributes: {
            autocapitalize: 'off'
        },
        showCancelButton: false,
        allowOutsideClick: false,
        confirmButtonText: 'Verify',
        showLoaderOnConfirm: true,
        inputAutoTrim: true,
        preConfirm: () => {
            const param = "?refid=" + refid + "&phone-number=" + phoneNo + "&otp=" + document.getElementsByClassName("swal2-input")[0].value;
            return fetch(ezmfaApiServerUrl + "/verify-sms-otp" + param, postRequestOptions)
                .then(response => response.json())
                .then((data) => {
                    if (data.status) {
                        showTopSuccessNotificationWithMessage(data.message);
                        document.getElementById("update-password").disabled = false; //enable update password button
                    } else {
                        showTopErrorNotificationWithMessage("Unable to Verify OTP")
                    }
                })
                .catch(() => {
                    showTopErrorNotificationWithMessage("Unable to reach server")
                })
        }
    }])

}

function getMobileNumberPopupInUpdateUserPassword() {
    const postRequestOptions = {
        method: 'POST'
    };
    const ezmfaApiServerUrl = location.protocol + "//" + location.host + "/api";
    const phoneNo = document.getElementById("phoneno").value;
    const param = "?phone-number=" + phoneNo + "&userid=" + document.getElementById("userid").value + "&orgid=" + document.getElementById("orgid").value;
    return fetch(ezmfaApiServerUrl + "/send-user-sms-otp" + param, postRequestOptions)
        .then(response => response.json())
        .then((data) => {
            if (data.status) {
                showTopSuccessNotificationWithMessage(data.message);
                verifyOtpCodePopupInUpdatePassword(data.refid, phoneNo);
            } else {
                showTopErrorNotificationWithMessage("Unable to send OTP")
            }
        })
        .catch(() => {
            showTopErrorNotificationWithMessage("Unable to reach server")
        })
}

function verifyOtpCodePopupInUpdateUserPassword(l, phoneNo) {
    const postRequestOptions = {
        method: 'POST'
    };

    const ezmfaApiServerUrl = location.protocol + "//" + location.host + "/api";

    Swal.queue([{
        title: 'Verify Mobile Number',
        text: 'Enter your OTP sent to your number',
        imageUrl: 'images/mobile-sms.png',
        imageWidth: 60,
        imageHeight: 60,
        imageAlt: 'Custom image',
        inputPlaceholder: 'Eg: 203145',
        input: 'number',
        allowEscapeKey: false,
        inputAttributes: {
            autocapitalize: 'off'
        },
        showCancelButton: false,
        allowOutsideClick: false,
        confirmButtonText: 'Verify',
        showLoaderOnConfirm: true,
        inputAutoTrim: true,
        preConfirm: () => {
            const param = "?refid=" + refid + "&phone-number=" + phoneNo + "&otp=" + document.getElementsByClassName("swal2-input")[0].value + "&orgid=" + document.getElementById("orgid").value;
            return fetch(ezmfaApiServerUrl + "/verify-user-sms-otp" + param, postRequestOptions)
                .then(response => response.json())
                .then((data) => {
                    if (data.status) {
                        showTopSuccessNotificationWithMessage(data.message);
                        document.getElementById("update-password").disabled = false; //enable update password button
                    } else {
                        showTopErrorNotificationWithMessage("Unable to Verify OTP")
                    }
                })
                .catch(() => {
                    showTopErrorNotificationWithMessage("Unable to reach server")
                })
        }
    }])
}

function showMailRedirectMessage(email) {
    Swal.fire({
        title: 'Thanks for signing up',
        text: 'To complete the registration process you must first confirm your account. An email has been sent to ' + email,
        imageUrl: 'images/mailSent.png',
        imageWidth: 150,
        imageHeight: 150,
        timer: 5000,
        showConfirmButton: false,
        footer: 'To confirm and activate your account please check your inbox and click on the link found in the email we just sent you',
        allowEscapeKey: false,
        allowOutsideClick: false
    }).then(() => {
        location.reload()
    })
}

function showMailPasswordResetMessage(email) {
    Swal.fire({
        title: 'Password Reset Mail Triggered',
        text: 'To complete the password reset process you must first confirm your account. An email has been sent to ' + email,
        imageUrl: 'images/mailSent.png',
        imageWidth: 150,
        imageHeight: 150,
        timer: 5000,
        showConfirmButton: false,
        footer: 'To reset the password, please check your inbox and click on the link found in the email we just sent you',
        allowEscapeKey: false,
        allowOutsideClick: false
    }).then(() => {
        location.reload()
    })
}

function showPasswordlessMailMessage(email) {
    Email = email;
    Swal.fire({
        title: 'Password Reset Mail Triggered',
        text: 'Click the Login link sent to your email address : ' + Email,
        imageUrl: '/images/mailSent.png',
        imageWidth: 150,
        imageHeight: 150,
        timer: 5000,
        showConfirmButton: false,
        allowEscapeKey: false,
        allowOutsideClick: false
    }).then((result) => {
        location.reload()
    })
}

function showBackupCodes() {

    var limit = document.getElementById("backup-code-limit").value;
    var int = parseInt(limit, 10);
    const ezmfaApiServerUrl = location.protocol + "//" + location.host + "/secure/api";
    const queryParam = '?token=' + document.getElementById("token").value + '&limit=' + document.getElementById("backup-code-limit").value;
    console.log(typeof int);

    if (int > 10 || int < 1) {
        showTopWarningNotificationWithMessage('Back Up code limit must be 10 or below');
    } else {
        Swal.queue([{
            confirmButtonText: 'Continue &rarr;',
            text: 'Fetching backup codes',
            showLoaderOnConfirm: true,
            preConfirm: () => {
                const requestOptions = {
                    method: 'GET'
                };
                return fetch(ezmfaApiServerUrl + "/get-backup-codes" + queryParam, requestOptions)
                    .then(response => response.json())
                    .then((data) => {
                        if (data.codes) {
                            var backupCodes = data.codes;
                            var backupCodesHtml = '<html><body><table class="table table-bordered"><tr><th>#</th><th>Codes</th></tr><tr>';

                            backupCodes.forEach(function (item, index, array) {
                                backupCodesHtml += '<td>' + (index + 1) + '</td><td><strong>' + item + '</strong></td></tr>';
                            })
                            backupCodesHtml += '</table><button onclick="export2csv()" class="btn btn-info">Download</button>';

                            Swal.fire({
                                html: backupCodesHtml,
                                showCloseButton: true,
                                showCancelButton: false,
                                showConfirmButton: false,
                                allowOutsideClick: false,
                                focusConfirm: false
                            })
                        } else {
                            Swal.fire({
                                icon: 'error',
                                title: 'Unable to Obtain Backup codes',
                                showConfirmButton: false,
                                timer: 1000
                            })
                        }
                    })
                    .catch(() => {
                        Swal.fire({
                            icon: 'error',
                            title: 'Unable to Obtain Backup codes!',
                            showConfirmButton: false,
                            timer: 1000
                        })
                    })
            }
        }])
    }
}

function export2csv() {
    let data = "";
    const tableData = [];
    const rows = document.querySelectorAll("table tr");
    for (const row of rows) {
        const rowData = [];
        for (const [index, column] of row.querySelectorAll("th, td").entries()) {
            if ((index + 1) % 3 === 0) {
                rowData.push('"' + column.innerText + '"');
            } else {
                rowData.push(column.innerText);
            }
        }
        tableData.push(rowData.join(","));
    }
    data += tableData.join("\n");
    const a = document.createElement("a");
    a.href = URL.createObjectURL(new Blob([data], {
        type: "text/csv"
    }));
    a.setAttribute("download", "backupcodes.csv");
    document.body.appendChild(a);
    a.click();
    document.body.removeChild(a);
}

// Update Phone Number Popup
function updateNewMobileNumberPopup(mobile) {
    Swal.queue([{
        title: 'Update Mobile Number',
        text: 'Enter New mobile number with the country code',
        imageUrl: '../images/mobile-sms.png',
        imageWidth: 60,
        imageHeight: 60,
        imageAlt: 'Custom image',
        html: '<form method="POST" action="#"><div class="form-group "><label for="Mobile">MobileNo</label><input id="phone" name="phone" type="tel"></div></form>',
        allowEscapeKey: false,
        showCancelButton: false,
        showCloseButton : true,
        allowOutsideClick: false,
        confirmButtonText: 'Send OTP',
        footer: 'Note: OTP will be sent to verify this new number',
        showLoaderOnConfirm: true,
        inputAutoTrim: true,
        customClass: {
            closeButton: 'bg-danger text-white'
        },
        onOpen: function() {
            var input = document.querySelector("#phone");
            window.intlTelInput(input, {
            utilsScript: "../js/utils.js",
            formatOnDisplay: true,
            });
            var iti = window.intlTelInputGlobals.getInstance(input);
            iti.setNumber('+'+mobile)
            
        },
        preConfirm: () => {
            var input = document.querySelector("#phone");
            var iti = window.intlTelInputGlobals.getInstance(input);
            console.log(iti.isValidNumber())
            if(iti.isValidNumber()){
                const phoneNo = iti.getNumber().replace("+","");
                const param = "?phone-number=" + phoneNo;
                // write this function def in the HTML page
                return updatePhoneNumberRequest(param);
            } else {
                    Swal.showValidationMessage(
                        'Valid Phone Number is Required'
                    )
                
            }
        }
    }])
}

function verifyNewMobileNumberPopup(refId) {
    Swal.queue([{
        title: 'Update Mobile Number',
        text: 'Enter the OTP sent to your number',
        imageUrl: '../images/mobile-sms.png',
        imageWidth: 60,
        imageHeight: 60,
        imageAlt: 'Custom image',
        inputPlaceholder: 'Eg: 203145',
        input: 'number',
        allowEscapeKey: false,
        inputAttributes: {
            autocapitalize: 'off'
        },
        showCancelButton: false,
        showCloseButton : true,
        allowOutsideClick: false,
        confirmButtonText: 'Verify',
        showLoaderOnConfirm: true,
        inputAutoTrim: true,
        preConfirm: () => {
            const param = "?refid=" + refId + "&otp=" + document.getElementsByClassName("swal2-input")[0].value;
            // write this function def in the HTML page
            return verifyPhoneNumberRequest(param);
        }
    }])
}

// Update Email Popup
function updateNewEmailPopup() {
    // Notifying the user of the behaviour and getting consent to contiue
    Swal.fire({
        icon: 'warning',
        title: 'Session Logout Warning',
        text: 'For Security reasons changing your current email will force you to Logout immediately',
        footer: '<i class="fa fa-info-circle" aria-hidden="true"></i> Make sure you are updating an Accessible Email',
        confirmButtonText:
            'Continue <i class="fa fa-arrow-right" aria-hidden="true"></i>',
        confirmButtonAriaLabel: 'Continue',
        showCloseButton : true,
        customClass: {
            closeButton: 'bg-danger text-white'
        }
    }).then((result) => {
        if (result.value) {
            // User gives consent to continue the update process
            Swal.queue([{
                title: 'Update Email Address',
                text: 'Enter your new Email Address',
                imageUrl: '../images/mailSent.png',
                imageWidth: 60,
                imageHeight: 60,
                imageAlt: 'Custom image',
                inputPlaceholder: 'Eg: mfauser@8kmiles.com',
                input: 'text',
                allowEscapeKey: false,
                inputAttributes: {
                    autocapitalize: 'off'
                },
                showCancelButton: false,
                showCloseButton : true,
                allowOutsideClick: false,
                confirmButtonText: 'Send OTP',
                footer: 'Note: OTP will be sent to verify your email',
                showLoaderOnConfirm: true,
                inputAutoTrim: true,
                customClass: {
                    validationMessage: 'my-validation-message'
                  },
                preConfirm: (value) => {
                    if(!value){
                        Swal.showValidationMessage(
                            'Your Email is required'
                          )
                    }else{
                        var validate = validateEmail(value);
                       if(validate){
                            const param = "?email=" +value;
                            return updateEmailRequest(param);
                       }else{
                            Swal.showValidationMessage(
                                'Invalid Email address'
                                )  
                       }
                    }
                }
            }])
        }
    });
}

function verifyNewEmailPopup(refId) {
    Swal.queue([{
        title: 'Update Email Address',
        text: 'Enter the OTP sent to your mail',
        imageUrl: '../images/mailSent.png',
        imageWidth: 60,
        imageHeight: 60,
        imageAlt: 'Custom image',
        inputPlaceholder: 'Eg: 203145',
        input: 'number',
        allowEscapeKey: false,
        inputAttributes: {
            autocapitalize: 'off'
        },
        showCancelButton: false,
        allowOutsideClick: false,
        showCloseButton : true,
        confirmButtonText: 'Verify',
        showLoaderOnConfirm: true,
        inputAutoTrim: true,
        preConfirm: () => {
            const param = "?refid=" + refId + "&otp=" + document.getElementsByClassName("swal2-input")[0].value;
            return verifyEmailRequest(param);
        }
    }])
}

function showPasswordPolicyError() {
    Swal.fire({
        html: "<html><body><ul>The password does not meet the password policy requirements	<li><small>The password must be minimum of 8 and maximum of 15 characters long</small></li><li><small>The password must have at least one lower-case and upper-case characters</small></li><li><small>The password must have at least one numeric and a special character</small></li></ul></body></html>",
        showCloseButton: false,
        showCancelButton: false,
        allowOutsideClick: true,
        focusConfirm: false,
        position: 'top',
        showConfirmButton: false,

        timerProgressBar: true
    })
}

function showSyncedDirectoryUsersPopup(response) {
    var data = "";
    var index = 1;
    response.forEach(element => {
        data += '<tr><th scope="row">' + (index++) + '</th><td>' + element[0] + '</td><td>' + element[1] + '</td><td>' + element[2] + '</td><td>' + element[3] + '</td></tr>';
    });
    Swal.fire({
        titleText: 'Directory Users Preview',
        html: '<html><body><table class="table table-striped table-bordered">' +
            '<thead><tr><th scope="col">#</th><th scope="col">User-Id</th><th scope="col">First Name</th><th scope="col">Last Name</th><th scope="col">Email</th></tr></thead>' +
            '<tbody>' + data + '</tbody></table></body></html>',
        showCancelButton: false,
        showCloseButton: true,
        showConfirmButton: false,
        width: '50rem'
    })
}
function showDirectoryUsersInPopup(groupName) {

    const postRequestOptions = {
        method: 'POST'
    };
    const ezmfaApiServerUrl = location.protocol + "//" + location.host;
    const param = "?groupName=" + groupName;

    fetch(ezmfaApiServerUrl + "/admin/ezmfa-directory-groupUsers" + param, postRequestOptions)
        .then(response => response.json())
        .then((data) => {
            if (data.status) {

                var response = data.users;
                var data = "";
                var index = 1;
                response.forEach(element => {
                    var userid = element.userId;
                    var email = element.email;
                    data += '<tr><th scope="row">' + (index++) + '</th><td>' + userid + '</td><td>' + email + '</td></tr>';
                });
                Swal.fire({
                    title: 'Directory Group-Users Preview',
                    html: '<html><body><table class="table table-striped table-bordered">' +
                        '<thead><tr><th scope="col">#</th><th scope="col">User-Id</th><th scope="col">Email</th></tr></thead>' +
                        '<tbody>' + data + '</tbody></table></body></html>',
                    showCancelButton: false,
                    showConfirmButton: false,
                    showCloseButton : true,
                    width: '40rem'
                })
            } else {
                showTopErrorNotificationWithMessage("User Revoked failed!");
            }
        })
        .catch(() => {
            showTopErrorNotificationWithMessage("Unable to reach server")
        })

}

function showGroupUsersInPopup(groupId) {

    const postRequestOptions = {
        method: 'POST'
    };
    const ezmfaApiServerUrl = location.protocol + "//" + location.host;
    const param = "?groupId=" + groupId;

    fetch(ezmfaApiServerUrl + "/admin/get-group-users" + param, postRequestOptions)
        .then(response => response.json())
        .then((data) => {
            if (data.status) {

                var response = data.GroupUsers;
                var data = "";
                var index = 1;
                response.forEach(element => {
                    var userid = element.userId;
                    var email = element.email;
                    data += '<tr><th scope="row">' + (index++) + '</th><td>' + userid + '</td><td>' + email + '</td></tr>';
                });
                Swal.fire({
                    title: 'Group-Users',
                    html: '<html><body><table class="table table-striped table-bordered">' +
                        '<thead><tr><th scope="col">#</th><th scope="col">User-Id</th><th scope="col">Email</th></tr></thead>' +
                        '<tbody>' + data + '</tbody></table></body></html>',
                    showCancelButton: false,
                    showConfirmButton: false,
                    showCloseButton : true,
                    width: '40rem'
                })
            } else {
                showTopErrorNotificationWithMessage("User Revoked failed!");
            }
        })
        .catch(() => {
            showTopErrorNotificationWithMessage("Unable to reach server")
        })

}