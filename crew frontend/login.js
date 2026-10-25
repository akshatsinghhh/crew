const API_URL = "http://localhost:8080/auth/login";

const loginForm = document.getElementById("loginForm");
const message = document.getElementById("message");
const loginButton = document.getElementById("loginButton");

loginForm.addEventListener("submit", async function (event) {
    event.preventDefault();

    const username = document.getElementById("username").value.trim();
    const password = document.getElementById("password").value;

    message.textContent = "";
    message.className = "message";
    loginButton.disabled = true;
    loginButton.textContent = "Signing in...";

    try {
        const response = await fetch(API_URL, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                username: username,
                password: password
            })
        });

        const data = await response.json();

        if (!response.ok) {
            throw new Error(
                data.message || "Login failed. Check your username and password."
            );
        }

        if (!data.token) {
            throw new Error("Login response did not contain a JWT token.");
        }

        // Save the JWT token for subsequent API requests.
        sessionStorage.setItem("jwtToken", data.token);

        message.textContent = "Login successful! Opening dashboard...";
        message.className = "message success";

        /*
         * Change dashboard.html to the actual filename
         * of your existing homepage/dashboard.
         */
        window.location.href = "new.html";

    } catch (error) {
        console.error("Login error:", error);

        if (error instanceof TypeError) {
            message.textContent =
                "Cannot connect to the server. Check that Spring Boot is running and CORS is configured.";
        } else {
            message.textContent = error.message;
        }

        message.className = "message error";

    } finally {
        loginButton.disabled = false;
        loginButton.textContent = "Sign In";
    }
});