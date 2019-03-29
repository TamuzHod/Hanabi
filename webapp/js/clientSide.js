
document.addEventListener("DOMContentLoaded", function() {
    initUserInfo();
});

function displayWelcomeMessage(username, logoutLink, text) {
	document.getElementById('user-login').innerHTML = `Welcome <i>${username}</i> | <a href="${logoutLink}"><span style="color: #1485c3;">${text}</span></a>`;
}

function initUserInfo() {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', '/jello/data/jello.services/UserProfile/whoAmI()');
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.onload = function() {
		let response = JSON.parse(xhr.responseText);
		let profile = response.d.result;
		
		if (profile.user) {
			displayWelcomeMessage(profile.user, profile.logoutLink, "Logout");
			
			let xhr2 = new XMLHttpRequest();
			xhr2.open('GET', '/jello/data/app/UserProfile/getProfile()');
			xhr2.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
			xhr2.onload = function() {
				let response2 = JSON.parse(xhr2.responseText);
				let userProfile = response2.d.result;
			};
			xhr2.send();
		} else {
			displayWelcomeMessage("Guest", profile.loginLink, "Login");
		}
	};
	xhr.send();
}

function signOut() {
    let auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
      console.log('User signed out.');
    });
 }
